package tests.api.model;

public class Carnet {
    private String nom;
    private String ville;
    private String age;

    // Constructor
    public Carnet(String nom, String ville, String age) {
        this.nom = nom;
        this.ville = ville;
        this.age = age;
    }

    // Default Constructor
    public Carnet() {}

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Carnet{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
