package tests.tp.model;
import java.io.Serializable;
public class Salarie implements Serializable {
    private int numSalarie;
    private String nomSalarie;
    private String nomService;
    private double salaire;

    // Constructeur par défaut
    public Salarie() {
    }

    // Constructeur avec paramètres
    public Salarie(int numSalarie, String nomSalarie, String nomService, double salaire) {
        this.numSalarie = numSalarie;
        this.nomSalarie = nomSalarie;
        this.nomService = nomService;
        this.salaire = salaire;
    }

    // Getters et Setters
    public int getNumSalarie() {
        return numSalarie;
    }

    public void setNumSalarie(int numSalarie) {
        this.numSalarie = numSalarie;
    }

    public String getNomSalarie() {
        return nomSalarie;
    }

    public void setNomSalarie(String nomSalarie) {
        this.nomSalarie = nomSalarie;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "numSalarie=" + numSalarie +
                ", nomSalarie='" + nomSalarie + '\'' +
                ", nomService='" + nomService + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
