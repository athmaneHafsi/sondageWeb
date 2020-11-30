package com.sondage.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL {

        /**
         * URL de connexion
         */
        private static String url = "jdbc:postgresql://15.236.164.19:5432/sondage";
        /**
         * Nom du user
         */
        private static String user = "admin";
        /**
         * Mot de passe du user
         */
        private static String passwd = "Pass01?@";
        /**
         * Objet Connexion
         */
        private static Connection connect;

        /**
         * Méthode qui va nous retourner notre instance
         * et la créer si elle n'existe pas...
         * @return
         */
        public static Connection getInstance(){
            if(connect == null){
                try {
                    connect = DriverManager.getConnection(url, user, passwd);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return connect;
        }
}
