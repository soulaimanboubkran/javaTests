package tests.tp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CompteurMots extends JFrame {
    private JTextField txtTexte;
    private JTextArea txtResultat;
    private HashMap<String, Integer> occurrences;

    public CompteurMots() {
        setTitle("Compteur de mots");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        occurrences = new HashMap<>();
        
        // Création des composants
        JPanel panelSaisie = new JPanel(new BorderLayout(5, 5));
        panelSaisie.setBorder(BorderFactory.createTitledBorder("Saisie du texte"));
        
        txtTexte = new JTextField();
        JButton btnCompter = new JButton("Compter");
        
        panelSaisie.add(txtTexte, BorderLayout.CENTER);
        panelSaisie.add(btnCompter, BorderLayout.EAST);
        
        txtResultat = new JTextArea();
        txtResultat.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultat);
        
        // Layout principal
        setLayout(new BorderLayout(5, 5));
        add(panelSaisie, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Gestionnaire d'événements
        btnCompter.addActionListener(e -> compterMots());
    }
    
    private void compterMots() {
        occurrences.clear();
        String texte = txtTexte.getText().trim();
        
        // Utilisation de StringTokenizer pour séparer les mots
        StringTokenizer st = new StringTokenizer(texte, " ,.");
        
        while (st.hasMoreTokens()) {
            String mot = st.nextToken().toLowerCase();
            occurrences.merge(mot, 1, Integer::sum);
        }
        
        // Affichage des résultats
        StringBuilder resultat = new StringBuilder();
        resultat.append("Nombre total de mots : ").append(occurrences.values().stream().mapToInt(Integer::intValue).sum()).append("\n\n");
        resultat.append("Occurrences par mot :\n");
        occurrences.forEach((mot, compte) -> 
            resultat.append(mot).append(" : ").append(compte).append("\n")
        );
        
        txtResultat.setText(resultat.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CompteurMots().setVisible(true);
        });
    }
}