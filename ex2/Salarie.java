package ex2;

public abstract class Salarie {
    private String nom;
    private String prenom;


   // Constructeur par défaut
   public Salarie() {
    this.nom = "";
    this.prenom = "";
}

// Constructeur paramétré
public Salarie(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
}

// Accesseurs (getters)
public String getNom() {
    return nom;
}

public String getPrenom() {
    return prenom;
}

// Mutateurs (setters)
public void setNom(String nom) {
    this.nom = nom;
}

public void setPrenom(String prenom) {
    this.prenom = prenom;
}

@Override
public String toString() {
    return "[Nom: " + nom + ", Prénom: " + prenom + "]";
}

// Méthode abstraite gains() pour retourner le salaire
public abstract double gains();
    
}

 class Patron extends Salarie {
    // Attribut
    private double salaire;

    // Constructeur par défaut
    public Patron() {
        super(); // Appel au constructeur par défaut de Salarie
        this.salaire = 0.0;
    }

    // Constructeur paramétré
    public Patron(String nom, String prenom, double salaire) {
        super(nom, prenom); // Appel au constructeur paramétré de Salarie
        this.salaire = salaire;
    }

    // Accesseurs (getters)
    public double getSalaire() {
        return salaire;
    }

    // Mutateurs (setters)
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "[Nom: " + getNom() + ", Prénom: " + getPrenom() + ", Salaire: " + salaire + "]";
    }

    // Redéfinition de la méthode gains()
    @Override
    public double gains() {
        return salaire;
    }
}
class TravailleurCommission extends Salarie {
    // Attributs
    private double salaire;       // Salaire mensuel de base
    private double commission;    // Montant de la commission par article vendu
    private int quantite;         // Nombre d'articles vendus par mois

    // Constructeur par défaut
    public TravailleurCommission() {
        super(); // Appel au constructeur par défaut de Salarie
        this.salaire = 0.0;
        this.commission = 0.0;
        this.quantite = 0;
    }

    // Constructeur paramétré
    public TravailleurCommission(String nom, String prenom, double salaire, double commission) {
        super(nom, prenom); // Appel au constructeur paramétré de Salarie
        this.salaire = salaire;
        this.commission = commission;
        this.quantite = 0; // Initialisé à zéro, car aucun article n'est vendu par défaut
    }

    // Accesseurs (getters)
    public double getSalaire() {
        return salaire;
    }

    public double getCommission() {
        return commission;
    }

    public int getQuantite() {
        return quantite;
    }

    // Mutateurs (setters)
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "[Nom: " + getNom() + ", Prénom: " + getPrenom() + 
               ", Salaire de base: " + salaire + 
               ", Commission par article: " + commission + 
               ", Quantité vendue: " + quantite + "]";
    }

    // Redéfinition de la méthode gains
    @Override
    public double gains() {
        return salaire + (commission * quantite);
    }
}
 class TravailleurHoraire extends Salarie {
    // Attributs
    private double retribution; // Rétribution horaire
    private int heures;         // Nombre d'heures de travail par mois

    // Constructeur par défaut
    public TravailleurHoraire() {
        super(); // Appel au constructeur par défaut de Salarie
        this.retribution = 0.0;
        this.heures = 0;
    }

    // Constructeur paramétré
    public TravailleurHoraire(String nom, String prenom, double retribution) {
        super(nom, prenom); // Appel au constructeur paramétré de Salarie
        this.retribution = retribution;
        this.heures = 0; // Par défaut, aucune heure de travail n'est définie
    }

    // Accesseurs (getters)
    public double getRetribution() {
        return retribution;
    }

    public int getHeures() {
        return heures;
    }

    // Mutateurs (setters)
    public void setRetribution(double retribution) {
        this.retribution = retribution;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "[Nom: " + getNom() + ", Prénom: " + getPrenom() + 
               ", Rétribution horaire: " + retribution + 
               ", Heures travaillées: " + heures + "]";
    }

    // Redéfinition de la méthode gains
    @Override
    public double gains() {
        return retribution * heures;
    }
}