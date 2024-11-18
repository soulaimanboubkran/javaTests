package ex1;

public class TestPersonne {
    public static void main(String[] args) {
        // Création d'un tableau de 5 personnes
        Personne[] personnes = new Personne[5];

        // Ajout d'instances de différentes classes dans le tableau
        personnes[0] = new Etudient("CIN001", "Dupont", "Jean", 101, 2);
        personnes[1] = new Etudient("CIN002", "Durand", "Marie", 102, 0);
        personnes[2] = new Professeur("CIN003", "Martin", "Paul", 2001, 10, 50.0, 2000.0);
        personnes[3] = new Professeur("CIN004", "Morel", "Anne", 2002, 5, 60.0, 2500.0);

        // Parcours du tableau et appel de la méthode afficher()
        for (Personne personne : personnes) {
            System.out.println(personne.afficher());
        }
    }
}