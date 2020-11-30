package com.sondage.user;

import com.sondage.user.Utilisateur;
import com.sondage.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends DAO<Utilisateur> {

    public Utilisateur create(Utilisateur obj) {
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery("SELECT NEXTVAL('utilisateur_id_utilisateur_seq') as id");

            if(result.first()){
                int id = result.getInt("id");
                PreparedStatement prepare = this.connect
                        .prepareStatement(
                                "INSERT INTO langage (nom_utilisateur,prenom_utilisateur,username_utilisateur,password_utilisateur,email_utilisateur) VALUES(?, ?, ?, ?, ?)"
                        );
                prepare.setString(1, obj.getNom());
                prepare.setString(2, obj.getPrenom());
                prepare.setString(3, obj.getUsername());
                prepare.setString(4, obj.getPassword());
                prepare.setString(5, obj.getEmail());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }



    public Utilisateur find(int id) {
        Utilisateur user = new Utilisateur();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery("SELECT * FROM utilisateur WHERE id_utilisateur = " + id);

            if(result.first())
                user = new Utilisateur(
                        id,
                        result.getString("prenom_utilisateur"),
                        result.getString("nom_utilisateur"),
                        result.getString("username_utilisateur"),
                        result.getString("email_utilisateur"),
                        result.getString("password_utilisateur")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }


    public Utilisateur update(Utilisateur obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                            String.format("UPDATE utilisateur SET nom_utilisateur = \'%s\', prenom_utilisateur = \'%s\', username_utilisateur = " +
                                    "\'%s\', email_utilisateur = \'%s\', password_utilisateur = \'%s\' WHERE id_utilisateur = %d;",
                                    obj.getNom(), obj.getPrenom(), obj.getUsername(), obj.getEmail(), obj.getPassword(), obj.getId())
                            );
            obj = this.find(obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public void delete(Utilisateur obj) {
        try {

            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM utilisateur WHERE id_utilisateur = " + obj.getId()
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}