/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import code.employeeCode;
import database.db;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author M_Samly
 */
public class addemployee extends javax.swing.JInternalFrame {

    /**
     * Creates new form income
     */
    public addemployee() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        show_employee();
    }

    public ArrayList<employeeCode> employeeList() {
        ArrayList<employeeCode> employeeList = new ArrayList<>();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from user order by u_id";
            ResultSet rs = st.executeQuery(query);
            employeeCode pro;
            while (rs.next()) {
                pro = new employeeCode(rs.getString("name"), rs.getString("role"), rs.getString("nic"), rs.getString("address"), rs.getInt("telephone"), rs.getBoolean("user_status"));
                employeeList.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return employeeList;
    }

    public void show_employee() {
        ArrayList<employeeCode> list = employeeList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getRole();
            row[2] = list.get(i).getNic();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getTelephone();
            row[5] = list.get(i).isUser_status();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelephone = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcomrole = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 712));

        jPanel4.setPreferredSize(new java.awt.Dimension(1024, 662));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Role", "NIC", "Address", "Telephone", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        txtSearh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearhKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Saerch By Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NIC");

        txtnic.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnicKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Telephone");

        txttelephone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txttelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelephoneKeyPressed(evt);
            }
        });

        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddressKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Role");

        jcomrole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcomrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));
        jcomrole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcomroleKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Dissabled");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcomrole, 0, 148, Short.MAX_VALUE)
                                        .addComponent(txtname)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtnic)
                                        .addComponent(txtaddress)
                                        .addComponent(txttelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSearh)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearhKeyReleased
        // TODO add your handling code here:
        ArrayList<employeeCode> list = new ArrayList<employeeCode>();
        //al = new ArrayList<AddItems>();
        String val = txtSearh.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from user where name like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            employeeCode pro;
            while (rs.next()) {
                pro = new employeeCode(rs.getString("name"), rs.getString("role"), rs.getString("nic"), rs.getString("address"), rs.getInt("telephone"), rs.getBoolean("user_status"));
                list.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            Object[] row = new Object[6];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getName();
                row[1] = list.get(i).getRole();
                row[2] = list.get(i).getNic();
                row[3] = list.get(i).getAddress();
                row[4] = list.get(i).getTelephone();
                row[5] = list.get(i).isUser_status();
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Product Barcode", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSearhKeyReleased

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcomrole.requestFocus();
        }
    }//GEN-LAST:event_txtnameKeyPressed

    private void jcomroleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcomroleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtnic.requestFocus();
        }
    }//GEN-LAST:event_jcomroleKeyPressed

    private void txtnicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnicKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtaddress.requestFocus();
        }
    }//GEN-LAST:event_txtnicKeyPressed

    private void txtaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddressKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txttelephone.requestFocus();
        }
    }//GEN-LAST:event_txtaddressKeyPressed

    private void txttelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelephoneKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!txtname.getText().equals("")) {
                if (!txtnic.getText().equals("")) {
                    if (!txtaddress.getText().equals("")) {
                        if (!txttelephone.getText().equals("")) {

                            try {
                                Connection con;
                                PreparedStatement pst;
                                con = db.getConnection();

                                String query = "Insert into user (name,role,nic,address,telephone,password,user_status) values (?,?,?,?,?,12345,true)";
                                pst = con.prepareStatement(query);

                                pst.setString(1, txtname.getText().trim());
                                pst.setString(2, jcomrole.getSelectedItem().toString());
                                pst.setString(3, txtnic.getText().trim());
                                pst.setString(4, txtaddress.getText().toString());
                                int tele = Integer.parseInt(txttelephone.getText().toString().trim());
                                pst.setInt(5, tele);

                                pst.executeUpdate();

                                JOptionPane.showMessageDialog(null, "User Sucessfully Added!");

                                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                                model.setRowCount(0);
                                show_employee();

                                txtSearh.setText(null);
                                txtaddress.setText(null);
                                txtname.setText(null);
                                txtnic.setText(null);
                                txttelephone.setText(null);
                                txtname.requestFocus();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Alredy Add Name! ,Check The User", "Save Error", JOptionPane.ERROR_MESSAGE);
                                txtname.requestFocus();
                            }
                        } else {
                            txttelephone.requestFocus();
                        }
                    } else {
                        txtaddress.requestFocus();
                    }
                } else {
                    txtnic.requestFocus();
                }
            } else {
                txtname.requestFocus();
            }
        }
    }//GEN-LAST:event_txttelephoneKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (!txtname.getText().equals("")) {
            if (!txtnic.getText().equals("")) {
                if (!txtaddress.getText().equals("")) {
                    if (!txttelephone.getText().equals("")) {

                        try {
                            Connection con;
                            PreparedStatement pst;
                            con = db.getConnection();

                            String query = "Insert into user (name,role,nic,address,telephone,password,user_status) values (?,?,?,?,?,12345,true)";
                            pst = con.prepareStatement(query);

                            pst.setString(1, txtname.getText().trim());
                            pst.setString(2, jcomrole.getSelectedItem().toString());
                            pst.setString(3, txtnic.getText().trim());
                            pst.setString(4, txtaddress.getText().toString());
                            int tele = Integer.parseInt(txttelephone.getText().toString().trim());
                            pst.setInt(5, tele);

                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null, "User Sucessfully Added!");

                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            model.setRowCount(0);
                            show_employee();

                            txtSearh.setText(null);
                            txtaddress.setText(null);
                            txtname.setText(null);
                            txtnic.setText(null);
                            txttelephone.setText(null);
                            txtname.requestFocus();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Alredy Add Name! ,Check The User", "Save Error", JOptionPane.ERROR_MESSAGE);
                            txtname.requestFocus();
                        }
                    } else {
                        txttelephone.requestFocus();
                    }
                } else {
                    txtaddress.requestFocus();
                }
            } else {
                txtnic.requestFocus();
            }
        } else {
            txtname.requestFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        show_employee();

        txtSearh.setText(null);
        txtaddress.setText(null);
        txtname.setText(null);
        txtnic.setText(null);
        txttelephone.setText(null);
        txtname.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        txtname.setText(model.getValueAt(i, 0).toString());
        jcomrole.setSelectedItem(model.getValueAt(i, 1).toString());
        txtnic.setText(model.getValueAt(i, 2).toString());
        txtaddress.setText(model.getValueAt(i, 3).toString());
        txttelephone.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!txtname.getText().equals("")) {
            if (!txtnic.getText().equals("")) {
                try {
                    Connection con;
                    PreparedStatement pst;
                    Statement st;
                    con = db.getConnection();
                    st = con.createStatement();
                    String name = txtname.getText();
                    String nic = txtnic.getText();
                    String query = "Select user_status from user where name = '" + name + "' AND nic = '" + nic + "'";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        boolean status = rs.getBoolean("user_status");

                        if (status == true) {
                            String query1 = "update user set user_status = '0' where name = '" + name + "' AND nic = '" + nic + "'";
                            pst = con.prepareStatement(query1);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Account Disabled!");
                        } else {
                            String query1 = "update user set user_status = '1' where name = '" + name + "' AND nic = '" + nic + "'";
                            pst = con.prepareStatement(query1);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Account Enabled!");
                        }
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        show_employee();

                        txtSearh.setText(null);
                        txtaddress.setText(null);
                        txtname.setText(null);
                        txtnic.setText(null);
                        txttelephone.setText(null);
                        txtname.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                txtnic.requestFocus();
            }
        } else {
            txtname.requestFocus();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (!txtname.getText().equals("")) {
            if (!txtnic.getText().equals("")) {
                int YesORNo = JOptionPane.showConfirmDialog(null, "Do you want Delete Account?", "Delete Option", JOptionPane.YES_NO_OPTION);
                if (YesORNo == 0) {
                    try {
                        Connection con;
                        PreparedStatement pst;
                        Statement st;
                        con = db.getConnection();
                        st = con.createStatement();
                        String name = txtname.getText();
                        String nic = txtnic.getText();
                        String query = "delete from user where name = '" + name + "' AND nic = '" + nic + "'";

                        pst = con.prepareStatement(query);
                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Account Deleted!");

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        show_employee();

                        txtSearh.setText(null);
                        txtaddress.setText(null);
                        txtname.setText(null);
                        txtnic.setText(null);
                        txttelephone.setText(null);
                        txtname.requestFocus();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            } else {
                txtnic.requestFocus();
            }
        } else {
            txtname.requestFocus();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcomrole;
    private javax.swing.JTextField txtSearh;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txttelephone;
    // End of variables declaration//GEN-END:variables
}
