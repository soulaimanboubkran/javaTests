package tests.tp2.model;


public class Employe {
    private String matricule;
    private String nom;
    private double salaire;
    private String sexe;

    // Constructeur
    public Employe(String matricule, String nom, double salaire, String sexe) {
        this.matricule = matricule;
        this.nom = nom;
        this.salaire = salaire;
        this.sexe = sexe;
    }

    // Getters et Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
