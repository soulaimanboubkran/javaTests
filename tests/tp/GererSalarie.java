package tests.tp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import tests.tp.model.Salarie;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GererSalarie extends JFrame {
    private ArrayList<Salarie> listeSalaries = new ArrayList<>();
    private JTextField txtNumSalarie, txtNomSalarie, txtNomService, txtSalaire;
    private JTable tableSalaries;
    private DefaultTableModel tableModel;

    public GererSalarie() {
        setTitle("Gestion des Salariés");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        
        // Création des composants //
        JPanel panelFormulaire = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulaire.setBorder(BorderFactory.createTitledBorder("Informations Salarié"));
        
        panelFormulaire.add(new JLabel("Numéro Salarié:"));
        txtNumSalarie = new JTextField();
        panelFormulaire.add(txtNumSalarie);
        
        panelFormulaire.add(new JLabel("Nom Salarié:"));
        txtNomSalarie = new JTextField();
        panelFormulaire.add(txtNomSalarie);
        
        panelFormulaire.add(new JLabel("Nom Service:"));
        txtNomService = new JTextField();
        panelFormulaire.add(txtNomService);
        
        panelFormulaire.add(new JLabel("Salaire:"));
        txtSalaire = new JTextField();
        panelFormulaire.add(txtSalaire);

        // Création des boutons
        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnRechercher = new JButton("Rechercher");
        JButton btnModifier = new JButton("Modifier");
    
        JButton btnSupprimer = new JButton("Supprimer");
        JButton btnAfficher = new JButton("Afficher");
        JButton btnTrier = new JButton("Trier");
        JButton btnReset = new JButton("Reset");
        JButton btnQuitter = new JButton("Quitter");

        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnRechercher);
        panelBoutons.add(btnModifier);
        panelBoutons.add(btnSupprimer);
        panelBoutons.add(btnAfficher);
        panelBoutons.add(btnTrier);
        panelBoutons.add(btnReset);
        panelBoutons.add(btnQuitter);

        // Création de la table
        String[] colonnes = {"N° Salarié", "Nom", "Service", "Salaire"};
        tableModel = new DefaultTableModel(colonnes, 0);
        tableSalaries = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableSalaries);

        // Layout principal
        setLayout(new BorderLayout(5, 5));
        add(panelFormulaire, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        // Gestionnaires d'événements
        btnAjouter.addActionListener(e -> ajouterSalarie());
        btnRechercher.addActionListener(e -> rechercherSalarie());
        btnModifier.addActionListener(e -> modifierSalarie());
        btnSupprimer.addActionListener(e -> supprimerSalarie());
        btnAfficher.addActionListener(e -> afficherParService());
        btnTrier.addActionListener(e -> trierSalaries());
        btnReset.addActionListener(e -> {
          // listeSalaries.clear();
          // actualiserTable();
          // viderChamps();
          txtNumSalarie.setText("");
          txtNomSalarie.setText("");
          txtNomService.setText("");
          txtSalaire.setText("");
        });
        btnQuitter.addActionListener(e -> System.exit(0));
    }

    private void ajouterSalarie() {
        try {
            // Parse the input values
            int num = Integer.parseInt(txtNumSalarie.getText());
            String nom = txtNomSalarie.getText().trim(); // Trim whitespace
            String service = txtNomService.getText().trim(); // Trim whitespace
            double salaire = Double.parseDouble(txtSalaire.getText().trim()); // Trim and parse the salary
    
            // Check if any required fields are empty
            if (nom.isEmpty() || service.isEmpty() || txtSalaire.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Create a new Salarie object and add it to the list
            Salarie s = new Salarie(num, nom, service, salaire);
            listeSalaries.add(s);
            
            // Update the table and clear the input fields
            actualiserTable();
            viderChamps();
        } catch (NumberFormatException e) {
            // Display a more specific error message for invalid number formats
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de salarié valide et un salaire valide", "Erreur de format", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // General exception handling for unexpected issues
            JOptionPane.showMessageDialog(this, "Une erreur est survenue: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void rechercherSalarie() {
        try {
            int num = Integer.parseInt(txtNumSalarie.getText());
            Salarie trouve = null;
            for (Salarie s : listeSalaries) {
                if (s.getNumSalarie() == num) {
                    trouve = s;
                    break;
                }
            }
            if (trouve != null) {
                txtNomSalarie.setText(trouve.getNomSalarie());
                txtNomService.setText(trouve.getNomService());
                txtSalaire.setText(String.valueOf(trouve.getSalaire()));
              
            } else {
                JOptionPane.showMessageDialog(this, "Salarié non trouvé !!!!!!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numéro de salarié invalide");
        }
    }

    private void modifierSalarie() {
        try {
            int num = Integer.parseInt(txtNumSalarie.getText());
            for (int i = 0; i < listeSalaries.size(); i++) {
                if (listeSalaries.get(i).getNumSalarie() == num) {
                    Salarie s = listeSalaries.get(i);
                    s.setNomSalarie(txtNomSalarie.getText());
                    s.setNomService(txtNomService.getText());
                    s.setSalaire(Double.parseDouble(txtSalaire.getText()));
                    actualiserTable();
                    viderChamps();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Salarié non trouvé");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valeurs invalides");
        }
    }

    private void supprimerSalarie() {
        try {
            int num = Integer.parseInt(txtNumSalarie.getText());
            listeSalaries.removeIf(s -> s.getNumSalarie() == num);
            actualiserTable();
            viderChamps();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numéro de salarié invalide");
        }
    }

    private void afficherParService() {
        String service = txtNomService.getText();
        List<Salarie> filtres = listeSalaries.stream()
                .filter(s -> s.getNomService().equalsIgnoreCase(service))
                .collect(Collectors.toList());
        actualiserTable(filtres);
    }

    private void trierSalaries() {
        List<Salarie> tries = listeSalaries.stream()
                .sorted(Comparator.comparingInt(Salarie::getNumSalarie))
                .collect(Collectors.toList());
        actualiserTable(tries);
    }

    private void actualiserTable() {
        actualiserTable(listeSalaries);
    }

    private void actualiserTable(List<Salarie> salaries) {
        tableModel.setRowCount(0);
        for (Salarie s : salaries) {
            Object[] row = {s.getNumSalarie(), s.getNomSalarie(), 
                          s.getNomService(), s.getSalaire()};
            tableModel.addRow(row);
        }
    }

    private void viderChamps() {
        txtNumSalarie.setText("");
        txtNomSalarie.setText("");
        txtNomService.setText("");
        txtSalaire.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GererSalarie().setVisible(true);
        });
    }
}