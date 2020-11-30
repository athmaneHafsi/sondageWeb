package com.sondage.user;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;

    public Utilisateur(int id, String prenom, String nom, String username, String email, String password) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
    }

    public Utilisateur() {

    }

                // GETTERS \\
    public int getId()                          { return id; }
    public String getNom()                      { return nom; }
    public String getPrenom()                   { return prenom; }
    public String getEmail()                    { return email; }
    public String getUsername()                 { return username; }
    public String getPassword()                 { return password; }

                // SETTERS \\
    public void setId(int id)                   { this.id = id; }
    public void setNom(String nom)              { this.nom = nom; }
    public void setPrenom(String prenom)        { this.prenom = prenom; }
    public void setEmail(String email)          { this.email = email; }
    public void setUsername(String username)    { this.username = username; }
    public void setPassword(String Password)    { this.password = password; }
















}
