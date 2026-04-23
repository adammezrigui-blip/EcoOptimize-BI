package com.ecooptimize.models;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;  // "Admin", "Manager", "Consultant"
    
    // Constructeur vide
    public Utilisateur() {}
    
    // Constructeur complet
    public Utilisateur(int id, String nom, String email, String motDePasse, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }
    
    // Méthode métier simplifiée pour Sprint 1
    public boolean seConnecter(String emailSaisi, String mdpSaisi) {
        // Version simplifiée : affiche seulement un message
        System.out.println("Tentative de connexion pour : " + emailSaisi);
        
        if (this.email.equals(emailSaisi) && this.motDePasse.equals(mdpSaisi)) {
            System.out.println("Connexion réussie ! Rôle : " + this.role);
            return true;
        }
        System.out.println("Échec de connexion : identifiants incorrects");
        return false;
    }
    
    public void afficherInfos() {
        System.out.println("ID: " + id + " | Nom: " + nom + " | Email: " + email + " | Rôle: " + role);
    }
    
    // Getters et Setters (génère-les automatiquement avec VS Code)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}