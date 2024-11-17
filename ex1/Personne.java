package ex1;

public abstract class Personne {
    private String cin;
    private String nom;
    private String prenom;

    // 1
    public Personne() {
        this.cin = "";
        this.nom = "";
        this.prenom = "";
    }

    // 2
    public Personne(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    // 3 Accesseurs (getters)
    public String getCin() {
        return this.cin;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
    // 3. Mutateurs (setters)

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // 4
    public String afficher() {
        return this.cin + this.nom + this.prenom;
    }

}

// 6
class Etudient extends Personne implements IEtudiant {
    private int numeroInscription;
    private int nbreAbsences;

    public Etudient(String cin, String nom, String prenom, int numeroInscription, int nbreAbsences) {
        super(cin, nom, prenom);
        this.numeroInscription = numeroInscription;
        this.nbreAbsences = nbreAbsences;
    }

    public int getNumeroInscription() {
        return this.numeroInscription;
    }

    public int getNbreAbsences() {
        return this.nbreAbsences;
    }

    public void setNumeroInscription(int numeroInscription) {
        this.numeroInscription = numeroInscription;
    }

    public void setNbreAbsences(int nbreAbsences) {
        this.nbreAbsences = nbreAbsences;
    }

    @Override
    public String afficher() {
        return super.afficher() + numeroInscription + nbreAbsences;
    }

    public void absence() {
        this.nbreAbsences++;
    }
}

class Professeur extends Personne implements IProf {
    private int matricule;
    private int nombreHeureSup;
    private double tauxHoraire;
    private double salaireFixe;

    public Professeur(String cin, String nom, String prenom, int matricule, int nombreHeureSup, double tauxHoraire,
            double salaireFixe) {
        super(cin, nom, prenom);
        this.matricule = matricule;
        this.nombreHeureSup = nombreHeureSup;
        this.tauxHoraire = tauxHoraire;
        this.salaireFixe = salaireFixe;
    }
       // Accesseurs (getters)
       public int getMatricule() {
        return matricule;
    }

    public int getNombreHeureSup() {
        return nombreHeureSup;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public double getSalaireFixe() {
        return salaireFixe;
    }

    // Mutateurs (setters)
    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNombreHeureSup(int nombreHeureSup) {
        this.nombreHeureSup = nombreHeureSup;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public void setSalaireFixe(double salaireFixe) {
        this.salaireFixe = salaireFixe;
    }
@Override
public String afficher(){
    return super.afficher() + this.matricule +this.nombreHeureSup+this.tauxHoraire+this.salaireFixe;
}

public double calculerSalaire(){
    return this.salaireFixe + (this.nombreHeureSup * this.tauxHoraire);
}
}
 /**
  *  
  */
interface    IProf {
    double calculerSalaire();
    String afficher();
    
 }
 interface IEtudiant {
   void absence();
   String afficher();
 }

