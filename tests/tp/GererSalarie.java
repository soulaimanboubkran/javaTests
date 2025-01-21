package tests.tp;




import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import tests.tp.model.Salarie;

public class GererSalarie extends javax.swing.JFrame {
    // Collection to store employee data
    private ArrayList<Salarie> salaries = new ArrayList<Salarie>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_afficher;
    private javax.swing.JButton bt_ajouter;
    private javax.swing.JButton bt_modifier;
    private javax.swing.JButton bt_quitter;
    private javax.swing.JButton bt_rechercher;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_supprimer;
    private javax.swing.JButton bt_vider;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_nomsalarie;
    private javax.swing.JTextField txt_nomservice;
    private javax.swing.JTextField txt_numsalarie;
    private javax.swing.JTextField txt_salaire;
    private javax.swing.JTextField txt_service;
    private javax.swing.JTextField txt_totalsalaire;
    // End of variables declaration//GEN-END:variables

    public GererSalarie() {
        initComponents();
        initializeFrame();
    }

    private void initializeFrame() {
        setTitle("Gestion de la liste des salariés");
        setSize(1100, 700);
        setResizable(false);
        bt_modifier.setEnabled(false);
        txt_totalsalaire.setEditable(false);
        txt_totalsalaire.setText("0 dhs");
    }

    // Display list of employees
    public void afficher_liste() {
        double total_salaire = 0;
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);  // Clear table
            
            // Populate table with employee data
            for (Salarie sal : salaries) {
                model.addRow(new Object[]{
                    sal.getNumSalarie(),
                    sal.getNomsalarie(),
                    sal.getNomservice(),
                    sal.getSalaire()
                });
                total_salaire += sal.getSalaire();
            }
            txt_totalsalaire.setText(total_salaire + " dhs");
        } catch (Exception ex) {
            // Silent exception handling as per original code
        }
    }

    // Event Handlers
    private void bt_ajouterMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            int numsal = Integer.parseInt(txt_numsalarie.getText());
            String nomsal = txt_nomsalarie.getText();
            String nomser = txt_nomservice.getText();
            double salaire = Double.parseDouble(txt_salaire.getText());

            if (!txt_numsalarie.getText().isEmpty() && 
                !txt_nomsalarie.getText().isEmpty() &&
                !txt_nomservice.getText().isEmpty() &&
                !txt_salaire.getText().isEmpty()) {
                
                Salarie s = new Salarie(numsal, nomsal, nomser, salaire);
                salaries.add(s);
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez saisir toutes les informations!!!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "veuillez verifier les informations!!");
        }
        afficher_liste();
        bt_resetMouseClicked(evt);
    }

    private void bt_modifierMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            for (Salarie s : salaries) {
                if (s.getNumSalarie() == Integer.parseInt(txt_numsalarie.getText())) {
                    if (JOptionPane.showConfirmDialog(this, 
                        "Voulez-vous valider la modification", 
                        "Confirmation", 
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        s.setNomsalarie(txt_nomsalarie.getText());
                        s.setNomservice(txt_nomservice.getText());
                        s.setSalaire(Double.parseDouble(txt_salaire.getText()));
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuillez verifier les informations");
        }
        bt_modifier.setEnabled(false);
        afficher_liste();
        bt_resetMouseClicked(evt);
    }

    private void bt_supprimerMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            for (Salarie s : salaries) {
                if (s.getNumSalarie() == Integer.parseInt(txt_numsalarie.getText())) {
                    if (JOptionPane.showConfirmDialog(this, 
                        "Voulez-vous supprimer ce salarié", 
                        "Confirmation", 
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        salaries.remove(s);
                        bt_resetMouseClicked(evt);
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuilez saisie le N° du salarié!!!");
        }
        afficher_liste();
    }

    private void bt_rechercherMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            bt_modifier.setEnabled(false);
            if (txt_numsalarie.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir le N° Salarié!!!!");
                return;
            }

            Iterator<Salarie> it = salaries.iterator();
            boolean exists = false;
            while (it.hasNext()) {
                Salarie s = it.next();
                if (s.getNumSalarie() == Integer.parseInt(txt_numsalarie.getText())) {
                    txt_nomsalarie.setText(s.getNomsalarie());
                    txt_nomservice.setText(s.getNomservice());
                    txt_salaire.setText(String.valueOf(s.getSalaire()));
                    exists = true;
                    bt_modifier.setEnabled(true);
                    break;
                }
            }

            if (!exists) {
                JOptionPane.showMessageDialog(this, 
                    "Le N° " + txt_numsalarie.getText() + " non trouvé !!!");
                bt_resetMouseClicked(evt);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuillez Verifier la saisie du N° Salarié");
        }
    }

    private void bt_afficherMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            if (txt_service.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir le Nom services");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);  // Clear table

            if (txt_service.getText().equalsIgnoreCase("tous")) {
                afficher_liste();
                return;
            }

            // Filter and display employees by service
            for (Salarie s : salaries) {
                if (s.getNomservice().equalsIgnoreCase(txt_service.getText())) {
                    model.addRow(new Object[]{
                        s.getNumSalarie(),
                        s.getNomsalarie(),
                        s.getNomservice(),
                        s.getSalaire()
                    });
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuillez verifier les informations");
        }
    }

    private void bt_resetMouseClicked(java.awt.event.MouseEvent evt) {
        txt_numsalarie.setText(null);
        txt_nomsalarie.setText(null);
        txt_nomservice.setText(null);
        txt_salaire.setText(null);
        txt_numsalarie.requestFocus();
        bt_modifier.setEnabled(false);
    }

    private void bt_quitterMouseClicked(java.awt.event.MouseEvent evt) {
        if (JOptionPane.showConfirmDialog(this, 
            "Voulez-vous quitter l'applictaion", 
            "Confirmation", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void bt_viderMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            txt_numsalarie.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            txt_nomsalarie.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            txt_nomservice.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            txt_salaire.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            bt_modifier.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un salarié de la liste");
        }
    }

    // Main method to launch the application
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GererSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GererSalarie().setVisible(true);
        });
    }

    // The initComponents() method would be here, generated by the IDE
    // It contains all the UI component initialization code


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_salaire = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_numsalarie = new javax.swing.JTextField();
        txt_nomsalarie = new javax.swing.JTextField();
        txt_nomservice = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bt_afficher = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_service = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bt_supprimer = new javax.swing.JButton();
        bt_ajouter = new javax.swing.JButton();
        bt_modifier = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        bt_rechercher = new javax.swing.JButton();
        bt_quitter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_totalsalaire = new javax.swing.JTextField();
        bt_vider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Salaire");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 270, 130, 50);

        txt_salaire.setBackground(new java.awt.Color(204, 204, 255));
        txt_salaire.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_salaire);
        txt_salaire.setBounds(190, 270, 200, 50);

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("N° Salarié");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 130, 50);

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Non Salarié");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 130, 50);

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Non Service");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 200, 130, 50);

        txt_numsalarie.setBackground(new java.awt.Color(204, 204, 255));
        txt_numsalarie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_numsalarie);
        txt_numsalarie.setBounds(190, 60, 200, 50);

        txt_nomsalarie.setBackground(new java.awt.Color(204, 204, 255));
        txt_nomsalarie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_nomsalarie);
        txt_nomsalarie.setBounds(190, 130, 200, 50);

        txt_nomservice.setBackground(new java.awt.Color(204, 204, 255));
        txt_nomservice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_nomservice);
        txt_nomservice.setBounds(190, 200, 200, 50);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 380, 370, 210);

        bt_afficher.setBackground(new java.awt.Color(204, 255, 204));
        bt_afficher.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_afficher.setForeground(new java.awt.Color(255, 51, 51));
        bt_afficher.setText("Afficher");
        bt_afficher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_afficherMouseClicked(evt);
            }
        });
        jPanel1.add(bt_afficher);
        bt_afficher.setBounds(110, 120, 130, 50);

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nom Service ");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 40, 130, 50);

        txt_service.setBackground(new java.awt.Color(255, 255, 204));
        txt_service.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_service.setToolTipText("Tapez tous pour afficher tous les salariés");
        jPanel1.add(txt_service);
        txt_service.setBounds(160, 40, 170, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(440, 350, 370, 210);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(null);
        jPanel3.add(jPanel4);
        jPanel4.setBounds(50, 380, 370, 210);

        bt_supprimer.setBackground(new java.awt.Color(255, 255, 204));
        bt_supprimer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_supprimer.setForeground(new java.awt.Color(0, 0, 255));
        bt_supprimer.setText("Supprimer");
        bt_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_supprimerMouseClicked(evt);
            }
        });
        jPanel3.add(bt_supprimer);
        bt_supprimer.setBounds(200, 30, 130, 50);

        bt_ajouter.setBackground(new java.awt.Color(255, 255, 204));
        bt_ajouter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_ajouter.setForeground(new java.awt.Color(0, 0, 255));
        bt_ajouter.setText("Ajouter");
        bt_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ajouterMouseClicked(evt);
            }
        });
        jPanel3.add(bt_ajouter);
        bt_ajouter.setBounds(40, 30, 130, 50);

        bt_modifier.setBackground(new java.awt.Color(255, 255, 204));
        bt_modifier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_modifier.setForeground(new java.awt.Color(0, 0, 255));
        bt_modifier.setText("Modifier");
        bt_modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_modifierMouseClicked(evt);
            }
        });
        jPanel3.add(bt_modifier);
        bt_modifier.setBounds(40, 90, 130, 50);

        bt_reset.setBackground(new java.awt.Color(255, 255, 204));
        bt_reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_reset.setForeground(new java.awt.Color(0, 0, 255));
        bt_reset.setText("Reset");
        bt_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_resetMouseClicked(evt);
            }
        });
        jPanel3.add(bt_reset);
        bt_reset.setBounds(40, 150, 130, 50);

        jButton5.setBackground(new java.awt.Color(255, 255, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Ajouter");
        jPanel3.add(jButton5);
        jButton5.setBounds(200, 30, 130, 50);

        bt_rechercher.setBackground(new java.awt.Color(255, 255, 204));
        bt_rechercher.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_rechercher.setForeground(new java.awt.Color(0, 0, 255));
        bt_rechercher.setText("Rechercher");
        bt_rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_rechercherMouseClicked(evt);
            }
        });
      //  bt_rechercher.addActionListener(new java.awt.event.ActionListener() {
      //      public void actionPerformed(java.awt.event.ActionEvent evt) {
      //          bt_rechercherActionPerformed(evt);
      //      }
      //  });
        jPanel3.add(bt_rechercher);
        bt_rechercher.setBounds(200, 90, 130, 50);

        bt_quitter.setBackground(new java.awt.Color(255, 255, 204));
        bt_quitter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_quitter.setForeground(new java.awt.Color(0, 0, 255));
        bt_quitter.setText("Quitter");
        bt_quitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_quitterMouseClicked(evt);
            }
        });
        jPanel3.add(bt_quitter);
        bt_quitter.setBounds(200, 150, 130, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 350, 370, 210);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Salarié", "Nom Salarié", "Nom Service", "Salaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 100, 452, 170);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("La liste des Salariés");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 60, 450, 30);

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Total Salaire :");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(600, 280, 110, 40);

        txt_totalsalaire.setBackground(new java.awt.Color(255, 204, 204));
        txt_totalsalaire.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_totalsalaire.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(txt_totalsalaire);
        txt_totalsalaire.setBounds(740, 280, 130, 40);

        bt_vider.setBackground(new java.awt.Color(255, 204, 204));
        bt_vider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_vider.setForeground(new java.awt.Color(51, 51, 255));
        bt_vider.setText("Vider La liste");
        bt_vider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_viderMouseClicked(evt);
            }
        });
        getContentPane().add(bt_vider);
        bt_vider.setBounds(880, 160, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
}
