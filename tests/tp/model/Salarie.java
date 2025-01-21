package tests.tp.model;
import java.io.Serializable;
public class Salarie implements Serializable
{      
//attributs
    private int numSalarie;
    private String nomsalarie;
    private String nomservice;
    private double salaire; 
//les constructeurs
    public Salarie() {    }
    public Salarie(int numSalarie, String nomsalarie, String nomservice, double salaire) {
        this.numSalarie = numSalarie;
        this.nomsalarie = nomsalarie;
        this.nomservice = nomservice;
        this.salaire = salaire;
    }
   //les getters et setters  
    public int getNumSalarie() {        return numSalarie;    }
    public void setNumSalarie(int numSalarie) {        this.numSalarie = numSalarie;    }
    public String getNomsalarie() {        return nomsalarie;    }
    public void setNomsalarie(String nomsalarie) {        this.nomsalarie = nomsalarie;    }
    public String getNomservice() {        return nomservice;    }
    public void setNomservice(String nomservice) {        this.nomservice = nomservice;    }
    public double getSalaire() {        return salaire;    }
    public void setSalaire(double salaire) {        this.salaire = salaire;    }
 }
