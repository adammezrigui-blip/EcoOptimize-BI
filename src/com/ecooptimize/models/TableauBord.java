package com.ecooptimize.models;

public class TableauBord {
    private double consommationTotale;
    private double empreinteCarbone;
    private int nbAlertes;
    
    public TableauBord() {
        this.consommationTotale = 0;
        this.empreinteCarbone = 0;
        this.nbAlertes = 0;
    }
    
    public TableauBord(double conso, double empreinte, int alertes) {
        this.consommationTotale = conso;
        this.empreinteCarbone = empreinte;
        this.nbAlertes = alertes;
    }
    
    // Version Sprint 1 : données en dur
    public void afficherKPIs() {
        System.out.println("\n=== TABLEAU DE BORD ECO-OPTIMIZE ===");
        System.out.println("📊 Consommation mensuelle : " + consommationTotale + " kWh");
        System.out.println("🌍 Empreinte carbone : " + empreinteCarbone + " kg CO2");
        System.out.println("⚠️ Alertes actives : " + nbAlertes);
        
        // Tendance simplifiée
        if (consommationTotale > 1000) {
            System.out.println("📈 Tendance : Hausse détectée !");
        } else {
            System.out.println("📉 Tendance : Bonne maîtrise");
        }
    }
    public void calculerEmpreinte(double consommationKWh) {
    // Facteur Tunisien (moyenne réseau STEG ≈ 0.5 kg CO2/kWh)
    double FACTEUR_CARBONE = 0.527;
    this.empreinteCarbone = consommationKWh * FACTEUR_CARBONE;
    System.out.println("Calcul effectué : " + consommationKWh + " kWh = " + 
                       this.empreinteCarbone + " kg CO2");
}
    
    // Getters/Setters
    // ...
}