private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       
    try {
        String code = JOptionPane.showInputDialog(this, "Enter Code:");
        
        if (!code.isEmpty()) {
            boolean found = false;
            
            for (Salarie item : data) {
                if (code.equals(item.getCode())) {
                    jTextField1.setText(item.getCode());
                    jTextField2.setText(item.getNom());
                    jComboBox1.setSelectedItem(item.getGrade());
                    
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(this, "No Salarie found with the given code.", "Not Found", JOptionPane.WARNING_MESSAGE);
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void affiche() {
    try {
        // Reset counts before updating
        technicianCount = 0;
        technicianSuperieurCount = 0;
        ingenieurCount = 0;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Salarie item : data) {
            model.addRow(new Object[]{item.getCode(), item.getNom(), item.getGrade()});
            
            switch (item.getGrade()) {
                case "technician":
                    technicianCount++;
                    break;
                case "technician superieur":
                    technicianSuperieurCount++;
                    break;
                case "ingenieur":
                    ingenieurCount++;
                    break;
            }
        }
        
        // Update UI labels
        tech.setText(String.valueOf(technicianCount));
        techS.setText(String.valueOf(technicianSuperieurCount));
        ing.setText(String.valueOf(ingenieurCount));
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void vider() {
    try {
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
    try {
        String code = jTextField1.getText().trim();
        String nom = jTextField2.getText().trim();
        String grade = jComboBox1.getSelectedItem().toString().trim();

        if (code.isEmpty() || nom.isEmpty() || grade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        data.add(new Salarie(code, nom, grade));
        affiche();
        vider();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}                                   

private void suppActionPerformed(java.awt.event.ActionEvent evt) {                                     
    try {
        String code = JOptionPane.showInputDialog(this, "Enter Code:");

        if (!code.isEmpty()) {
            Iterator<Salarie> iterator = data.iterator();

            while (iterator.hasNext()) {
                Salarie item = iterator.next();

                if (item.getCode().equals(code)) {
                    iterator.remove();
                    break;
                }
            }
        }

        affiche();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} 
