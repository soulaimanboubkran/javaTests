package tests.tp2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import tests.tp2.model.Employe;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class App extends JFrame {
   public static List<Employe> list_employe = new ArrayList<>(); 
   private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtMatricule;
    private JTextField txtNom;
    private JTextField txtSalaire;
    private JTextField txtSexe;

    public App(){
        list_employe.add(new Employe("emp001","Alami",5600,"male"));

        setTitle("Gestion des employés");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Tableau pour afficher les employés
        String[] columnNames = {"Matricule", "Nom", "Salaire", "Sexe"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // inputs
// Initialize the text fields
txtMatricule = new JTextField();
txtNom = new JTextField();
txtSalaire = new JTextField();
txtSexe = new JTextField();
        // Panel for input fields
    JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
    inputPanel.add(new JLabel("Matricule:"));
    inputPanel.add(txtMatricule);
    inputPanel.add(new JLabel("Nom:"));
    inputPanel.add(txtNom);
    inputPanel.add(new JLabel("Salaire:"));
    inputPanel.add(txtSalaire);
    inputPanel.add(new JLabel("Sexe:"));
    inputPanel.add(txtSexe);

    add(inputPanel, BorderLayout.NORTH);
        // Boutons
        JPanel panel = new JPanel();

        JButton btnAdd = new JButton("Ajouter");
        JButton btnDelete = new JButton("Supprimer");
        JButton btnDisplay = new JButton("Afficher");
        panel.add(btnAdd);
        panel.add(btnDelete);   
        panel.add(btnDisplay);  
        add(panel, BorderLayout.SOUTH);


       btnAdd.addActionListener(e -> ajouter());
       btnDelete.addActionListener(e -> Supprimer());
       btnDisplay.addActionListener(e -> Afficher());

        setVisible(true);
    }


   private void ajouter(){

    try {
        String matricule = txtMatricule.getText();
        String nom = txtNom.getText();
        double salaire = Double.parseDouble(txtSalaire.getText());
        String sexe = txtSexe.getText();

        System.out.println(matricule); // Debugging output
       list_employe.add(new Employe(matricule, nom, salaire, sexe));
       clearInputs();
       Afficher();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Le salaire doit être un nombre valide !");
    }

   }
   private void Supprimer(){

    String matricule = txtMatricule.getText();
    if (!matricule.isEmpty()) {
    for (Employe employe : list_employe){
        if(employe.getMatricule().equals(matricule)){
            list_employe.remove(employe);
            JOptionPane.showMessageDialog(this, "Employé supprimé avec succès !");

            break;
        }
    }
    clearInputs();
    Afficher();
} else {
    JOptionPane.showMessageDialog(this, "Veuillez entrer un matricule pour supprimer !");
}
   }
   private void Afficher(){
    tableModel.setRowCount(0);
    for (Employe emp : list_employe) {
        tableModel.addRow(new Object[]{
            emp.getMatricule(),
            emp.getNom(),
            emp.getSalaire(),
            emp.getSexe()
        });
    }
   }

   // Clear the input fields
private void clearInputs() {
    txtMatricule.setText("");
    txtNom.setText("");
    txtSalaire.setText("");
    txtSexe.setText("");
}
    public static void main(String[] args) {
        new App();
    }

}
