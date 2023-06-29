/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package medical.management.system;

import java.awt.Color;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ravi Kant Gupta
 */
public class Add_Medicines extends javax.swing.JFrame {

    public Add_Medicines() {
        super("Add Medicines");
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        initComponents();
    }

    public void addMedicines() {
        try {
            String name = (String) Medicine_name_Field.getText();
            int price = Integer.parseInt(Rate_Field.getText());
            int quantity = Integer.parseInt(Quantity_Field.getText());

            Connection conn = new GetConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM medicines WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int updatedQuantity = rs.getInt("quantity");
                updatedQuantity += quantity;
                PreparedStatement p = conn.prepareStatement("UPDATE medicines SET quantity =? , price =? WHERE name = ?");
                p.setInt(1, updatedQuantity);
                p.setInt(2, price);
                p.setString(3, name);
                p.executeUpdate();
                JOptionPane.showMessageDialog(this, "Stock Updated");

            } else {
                PreparedStatement s = conn.prepareStatement("INSERT INTO medicines (name , price , quantity) VALUES(?,?,?)");
                s.setString(1, name);
                s.setInt(2, price);
                s.setInt(3, quantity);
                s.executeUpdate();
                JOptionPane.showMessageDialog(this, "Medicine Added");
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
        showStock();
        Medicine_name_Field.setText("");
        Rate_Field.setText("");
        Quantity_Field.setText("");
    }

    public void showStock() {
        String name = (String) Medicine_name_Field.getText();
        try {
            Connection conn = new GetConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT *  FROM medicines WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String n = rs.getString("name");
                int q = rs.getInt("quantity");
                Medicine_name_Field1.setText(n);
                Stock.setText(q + "");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Add_Medicine_Row = new javax.swing.JPanel();
        Medicine_name = new javax.swing.JLabel();
        Rate_Label = new javax.swing.JLabel();
        Rate_Field = new javax.swing.JTextField();
        Total_Label = new javax.swing.JLabel();
        Quantity_Field = new javax.swing.JTextField();
        Medicine_name_Field = new javax.swing.JTextField();
        Add_Button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        Medicine_name_Field1 = new javax.swing.JTextField();
        Medicine_name1 = new javax.swing.JLabel();
        Rate_Label1 = new javax.swing.JLabel();
        Stock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Medicines", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sitka Display", 0, 18))); // NOI18N

        Medicine_name.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name.setText("Medicine Name :");

        Rate_Label.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label.setText("Price :");

        Rate_Field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_FieldActionPerformed(evt);
            }
        });

        Total_Label.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label.setText("Quantity :");

        Quantity_Field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_FieldActionPerformed(evt);
            }
        });

        Medicine_name_Field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Medicine_name_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medicine_name_FieldActionPerformed(evt);
            }
        });

        Add_Button.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button.setText("Add ");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Medicine_RowLayout = new javax.swing.GroupLayout(Add_Medicine_Row);
        Add_Medicine_Row.setLayout(Add_Medicine_RowLayout);
        Add_Medicine_RowLayout.setHorizontalGroup(
            Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                .addGroup(Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Medicine_name)
                        .addGap(18, 18, 18)
                        .addComponent(Medicine_name_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Rate_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rate_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Total_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quantity_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(Add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        Add_Medicine_RowLayout.setVerticalGroup(
            Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name)
                    .addComponent(Rate_Label)
                    .addComponent(Rate_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label)
                    .addComponent(Quantity_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicine_name_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(Add_Button)
                .addGap(38, 38, 38))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Updated Stock", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sitka Display", 0, 18))); // NOI18N

        Medicine_name_Field1.setEditable(false);
        Medicine_name_Field1.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Medicine_name_Field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medicine_name_Field1ActionPerformed(evt);
            }
        });

        Medicine_name1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name1.setText("Medicine Name :");

        Rate_Label1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label1.setText("Stock Available :");

        Stock.setEditable(false);
        Stock.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Medicine_name1)
                .addGap(18, 18, 18)
                .addComponent(Medicine_name_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Rate_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Medicine_name1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Medicine_name_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Rate_Label1)
                        .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setText("Developed with ❤ by Ravi Kant Gupta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Add_Medicine_Row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Add_Medicine_Row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Medical Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jMenu1.setText("Operations");
        jMenu1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem4.setText("Generate Bill");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem2.setText("Check Stock");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem3.setText("Add Medicines");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("More");
        jMenu5.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem6.setText("Log Out");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Rate_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_FieldActionPerformed

    private void Quantity_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_FieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Quantity_FieldActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed

        addMedicines();
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Medicine_name_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medicine_name_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Medicine_name_FieldActionPerformed

    private void Medicine_name_Field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medicine_name_Field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Medicine_name_Field1ActionPerformed

    private void StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StockActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new BillGenerator();
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Stocks();
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Add_Medicines();
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new Login();
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Button;
    private javax.swing.JPanel Add_Medicine_Row;
    private javax.swing.JLabel Medicine_name;
    private javax.swing.JLabel Medicine_name1;
    private javax.swing.JTextField Medicine_name_Field;
    private javax.swing.JTextField Medicine_name_Field1;
    private javax.swing.JTextField Quantity_Field;
    private javax.swing.JTextField Rate_Field;
    private javax.swing.JLabel Rate_Label;
    private javax.swing.JLabel Rate_Label1;
    private javax.swing.JTextField Stock;
    private javax.swing.JLabel Total_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
