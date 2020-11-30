package com.sondage.DAO;

import com.sondage.user.Utilisateur;
import com.sondage.user.UserDAO;

public class DAOFactory {

    public static DAO<Utilisateur> getUtilisateurDAO(){
        return new UserDAO();
    }
}
