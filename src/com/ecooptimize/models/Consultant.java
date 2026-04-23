package com.ecooptimize.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Consultant - Hérite de Utilisateur
 * Rôle : Consultant externe, peut analyser les données et exporter des rapports
 */
public class Consultant extends Utilisateur {
    
    // Attributs spécifiques au Consultant
    private String specialite;  // "Efficacité énergétique", "Audit carbone", "Conseil stratégique"
    private String entreprise;
    private int niveauExpertise;  // 1 (Junior) à 5 (Expert)
    private List<String> certifications;  // Ex: "ISO 50001", "Certificat Énergie"
    
    // Constructeur vide
    public Consultant() {
        super();
        this.certifications = new ArrayList<>();
        this.niveauExpertise = 1;
    }
    
    // Constructeur complet
    public Consultant(int id, String nom, String email, String motDePasse, 
                      String specialite, String entreprise, int niveauExpertise) {
        super(id, nom, email, motDePasse, "Consultant");
        this.specialite = specialite;
        this.entreprise = entreprise;
        this.niveauExpertise = niveauExpertise;
        this.certifications = new ArrayList<>();
    }
    
    // Constructeur avec certifications
    public Consultant(int id, String nom, String email, String motDePasse, 
                      String specialite, String entreprise, int niveauExpertise, 
                      List<String> certifications) {
        super(id, nom, email, motDePasse, "Consultant");
        this.specialite = specialite;
        this.entreprise = entreprise;
        this.niveauExpertise = niveauExpertise;
        this.certifications = certifications;
    }
    
    // ========== MÉTHODES MÉTIER ==========
    
    /**
     * Exporter un rapport au format CSV (simulation)
     * @param historique L'historique des relevés
     */
    public void exporterRapportCSV(HistoriqueReleves historique) {
        System.out.println("\n📁 [Consultant " + getNom() + "] Export du rapport CSV");
        System.out.println("Consultant : " + getNom() + " (" + specialite + ")");
        System.out.println("Entreprise : " + entreprise);
        System.out.println("Date d'export : " + java.time.LocalDate.now());
        
        List<ReleveConsommation> releves = historique.getReleves();
        
        if (releves.isEmpty()) {
            System.out.println("Aucune donnée à exporter.");
            return;
        }
        
        // Simulation d'export CSV
        System.out.println("\n--- CONTENU DU FICHIER CSV SIMULÉ ---");
        System.out.println("Date,Site,Valeur (kWh),Type Capteur");
        for (ReleveConsommation r : releves) {
            System.out.println(r.getDate() + "," + r.getSite() + "," + 
                               r.getValeurKWh() + "," + r.getTypeCapteur());
        }
        System.out.println("--- FIN DU RAPPORT ---");
        System.out.println("✅ Rapport exporté avec succès !");
    }
    
    /**
     * Analyser la performance énergétique (via Membre 4)
     * @param comparateur Le comparateur de performances
     * @param consommation La consommation à analyser
     * @param secteur Le secteur d'activité
     */
    public void analyserPerformance(ComparateurPerformances comparateur, 
                                    double consommation, String secteur) {
        System.out.println("\n🔍 [Consultant " + getNom() + "] Analyse de performance");
        System.out.println("Expertise : Niveau " + niveauExpertise + "/5 - " + specialite);
        comparateur.afficherComparaison(consommation, secteur);
    }
    
    /**
     * Fournir des recommandations personnalisées
     * @param comparateur Le comparateur de performances
     * @param consommation La consommation actuelle
     * @param secteur Le secteur d'activité
     */
    public void fournirRecommandations(ComparateurPerformances comparateur,
                                        double consommation, String secteur) {
        System.out.println("\n💡 [Consultant " + getNom() + "] Recommandations personnalisées");
        System.out.println("Basées sur : " + consommation + " kWh en " + secteur);
        
        // Évaluation préliminaire
        String evaluation = comparateur.evaluerPerformance(consommation, secteur);
        System.out.println("📊 Évaluation : " + evaluation);
        System.out.println("📝 " + comparateur.getRecommandation());
        
        // Recommandations additionnelles selon spécialité
        if (specialite.contains("Audit")) {
            System.out.println("🔧 Recommandation spécifique : Audit énergétique approfondi recommandé (détection des fuites, isolation)");
        } else if (specialite.contains("Conseil")) {
            System.out.println("🎯 Recommandation spécifique : Mise en place d'un plan d'action sur 6 mois avec KPIs mensuels");
        } else if (specialite.contains("Efficacité")) {
            System.out.println("💡 Recommandation spécifique : Remplacement des équipements vétustes par des versions économes (retour sur investissement estimé à 18 mois)");
        }
    }
    
    /**
     * Ajouter une certification
     * @param certification Nom de la certification
     */
    public void ajouterCertification(String certification) {
        if (!certifications.contains(certification)) {
            certifications.add(certification);
            System.out.println("🏅 Certification '" + certification + "' ajoutée pour " + getNom());
        } else {
            System.out.println("⚠️ Certification '" + certification + "' déjà existante");
        }
    }
    
    /**
     * Afficher les certifications du consultant
     */
    public void afficherCertifications() {
        System.out.println("🏅 Certifications de " + getNom() + " :");
        if (certifications.isEmpty()) {
            System.out.println("   Aucune certification renseignée");
        } else {
            for (String certif : certifications) {
                System.out.println("   - " + certif);
            }
        }
    }
    
    /**
     * Consulter les benchmarks sectoriels
     * @param comparateur Le comparateur de performances
     */
    public void consulterBenchmarks(ComparateurPerformances comparateur) {
        System.out.println("\n📊 [Consultant " + getNom() + "] Consultation des benchmarks");
        System.out.println("Source : ANME Tunisie - Étude benchmark énergétique 2025\n");
        
        for (Benchmark b : comparateur.getBenchmarks()) {
            System.out.println("• " + b.getSecteur() + " : " + b.getMoyenneKWhParMois() + " kWh/mois");
        }
    }
    
    /**
     * Calculer le niveau de confiance d'une analyse basé sur l'expertise
     * @return Pourcentage de confiance
     */
    public int getNiveauConfiance() {
        // Plus l'expertise est élevée, plus la confiance est haute
        return 60 + (niveauExpertise * 8);  // Min 68%, Max 100%
    }
    
    /**
     * Surcharge de la méthode afficherInfos() de Utilisateur
     */
    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("   👔 Rôle spécifique : Consultant Externe");
        System.out.println("   📚 Spécialité : " + specialite);
        System.out.println("   🏢 Entreprise : " + entreprise);
        System.out.println("   ⭐ Niveau d'expertise : " + niveauExpertise + "/5");
        System.out.println("   🔒 Niveau de confiance : " + getNiveauConfiance() + "%");
        afficherCertifications();
    }
    
    // ========== GETTERS ET SETTERS ==========
    
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    
    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }
    
    public int getNiveauExpertise() { return niveauExpertise; }
    public void setNiveauExpertise(int niveauExpertise) { this.niveauExpertise = niveauExpertise; }
    
    public List<String> getCertifications() { return certifications; }
    public void setCertifications(List<String> certifications) { this.certifications = certifications; }
}