/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import database.db;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author M_Samly
 */
public class loan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Loan
     */
    public loan() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAmount = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBillNo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        btnLoan = new javax.swing.JButton();
        txtTelephone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 712));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 100, 20));

        txtNIC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNIC.setText("-");
        txtNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNICKeyPressed(evt);
            }
        });
        jPanel1.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 210, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NIC");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 70, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Bill No");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 70, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 70, 20));

        txtBillNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 100, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Amount");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 70, 20));

        txtCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerKeyPressed(evt);
            }
        });
        jPanel1.add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 210, -1));

        btnLoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoan.setText("Loan");
        btnLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanActionPerformed(evt);
            }
        });
        jPanel1.add(btnLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        txtTelephone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyPressed(evt);
            }
        });
        jPanel1.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 210, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Telephone");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 70, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
        // TODO add your handling code here:
        try {

            Connection con;
            PreparedStatement pst;
            con = db.getConnection();

            String query = "Insert into loan (b_id,date,time,customer,telephone,nic,status,amount) values (?,CURDATE(),CURTIME(),?,?,?,?,?)";
            pst = con.prepareStatement(query);

            pst.setInt(1, Integer.parseInt(txtBillNo.getText().trim()));
            pst.setString(2, txtCustomer.getText().trim());
            int telephone = Integer.parseInt(txtTelephone.getText());
            pst.setInt(3, telephone);
            pst.setString(4, txtNIC.getText().trim());
            pst.setString(5, "loan");
            float amount = Float.parseFloat(txtAmount.getText().toString().trim());
            pst.setFloat(6, amount);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Loan Sucessfully Added!");
           // billPrint();
            this.dispose();
            cashier.txtSearchBarcode.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnLoanActionPerformed

    private void txtNICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                Connection con;
                PreparedStatement pst;
                con = db.getConnection();

                String query = "Insert into loan (b_id,date,time,customer,telephone,nic,status,amount) values (?,CURDATE(),CURTIME(),?,?,?,?,?)";
                pst = con.prepareStatement(query);

                pst.setInt(1, Integer.parseInt(txtBillNo.getText().trim()));
                pst.setString(2, txtCustomer.getText().trim());
                int telephone = Integer.parseInt(txtTelephone.getText());
                pst.setInt(3, telephone);
                pst.setString(4, txtNIC.getText().trim());
                pst.setString(5, "loan");
                float amount = Float.parseFloat(txtAmount.getText().toString().trim());
                pst.setFloat(6, amount);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Loan Sucessfully Added!");
               // billPrint();
                this.dispose();
                cashier.txtSearchBarcode.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txtNICKeyPressed

    private void txtCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelephone.requestFocus();
        }
    }//GEN-LAST:event_txtCustomerKeyPressed

    private void txtTelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNIC.requestFocus();
        }
    }//GEN-LAST:event_txtTelephoneKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoan;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel txtAmount;
    public static javax.swing.JLabel txtBillNo;
    public static javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtNIC;
    public static javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
