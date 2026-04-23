package com.ecooptimize.models;

public class Admin extends Utilisateur {
    public Admin() {}
    
    public Admin(int id, String nom, String email, String motDePasse) {
        super(id, nom, email, motDePasse, "Admin");
    }
    
    public void gererUtilisateurs() {
        System.out.println("[Admin] Gestion des utilisateurs - affichage de la liste...");
    }
}