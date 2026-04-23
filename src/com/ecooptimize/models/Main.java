package com.ecooptimize.models;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ECO-OPTIMIZE BI — SPRINT 1 ===\n");
        
        // === Test Authentification (Membre 1) ===
        System.out.println("-- Authentification & Rôles --");
        Admin admin = new Admin(1, "Karim Ben Ali", "karim@eco.tn", "admin123");
        Manager manager = new Manager(2, "Sara Mansouri", "sara@eco.tn", "manager123");
        
        admin.afficherInfos();
        admin.seConnecter("karim@eco.tn", "admin123");
        admin.gererUtilisateurs();
        
        System.out.println();
        manager.seConnecter("sara@eco.tn", "wrongpass");  // Échec simulé
        
        // === Test Tableau de bord (Membre 1) ===
        System.out.println("\n-- Tableau de bord KPI --");
        TableauBord dashboard = new TableauBord(1450, 725, 2);
        dashboard.afficherKPIs();
        
        System.out.println("\n✅ Fin de la démo Sprint 1 - Membre 1");
    }
}
