/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import code.productCode;
import database.db;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M_Samly
 */
public class barcodeProduct extends javax.swing.JInternalFrame {

    /**
     * Creates new form addProduct
     */
    public barcodeProduct() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        show_Product();
    }

    public ArrayList<productCode> ProductList() {
        ArrayList<productCode> ProductList = new ArrayList<>();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from product order by barcode";
            ResultSet rs = st.executeQuery(query);
            productCode pro;
            while (rs.next()) {
                pro = new productCode(rs.getString("Barcode"), rs.getString("Name"), rs.getInt("Quantity"), rs.getFloat("BPrice"), rs.getFloat("WPrice"), rs.getFloat("RPrice"));
                ProductList.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ProductList;
    }

    public void show_Product() {
        ArrayList<productCode> list = ProductList();
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getBarcode();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getQty();
            row[3] = list.get(i).getBprice();
            row[4] = list.get(i).getWprice();
            row[5] = list.get(i).getRprice();
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

        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        txtSearchBarcode = new javax.swing.JTextField();
        txtSerchName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        txtName = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1024, 712));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("Print");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Quantity", "B Price", "W Price", "R Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        tblProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        txtSearchBarcode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearchBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBarcodeKeyReleased(evt);
            }
        });

        txtSerchName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSerchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerchNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerchNameKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Search By Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Search By Barcode");

        txtQty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtBarcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQty)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSerchName)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            int Qty = Integer.parseInt(txtQty.getText());
            int YesORNo = JOptionPane.showConfirmDialog(null, "Are you ready for print barcodes?", "Barcode Print", JOptionPane.YES_NO_OPTION);
            if (YesORNo == 0) {
                for (int i = 0; i < Qty; i++) {
                    BarcodePrint();
                }
                Connection con;
                PreparedStatement pst1;
                con = db.getConnection();

                String query1 = "Insert into barcode_print (date,time,Barcode,Name,Qty) values (CURDATE(),CURTIME(),?,?,?)";
                pst1 = con.prepareStatement(query1);

                pst1.setString(1, txtBarcode.getText().trim());
                pst1.setString(2, txtName.getText().trim());
                pst1.setInt(3, Qty);
                pst1.executeUpdate();

                txtBarcode.setText(null);
                txtName.setText(null);
                txtQty.setText(null);
                txtSerchName.setText(null);
                txtSearchBarcode.setText(null);
                txtSerchName.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);//"Alredy Add Product! ,Check The Product", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public void BarcodePrint() {

        try {
            Connection con;
            PreparedStatement pst, pst1, pst2, pst3, pst4, pst5;
            con = db.getConnection();
            String barcode = txtBarcode.getText();
            HashMap m = new HashMap();
            m.put("barcode", barcode);
            try {
                JasperDesign jdesing = JRXmlLoader.load("E:\\M.Samly\\Clothing Management System\\Cloth_System\\src\\print\\barcode.jrxml");//("C:\\Users\\msham.DESKTOP-RE7Q19V\\Desktop\\TonyCash\\src\\UI\\report1.jrxml");//
                JasperReport ireport = JasperCompileManager.compileReport(jdesing);
                JasperPrint jprint = JasperFillManager.fillReport(ireport, m, con);
                //JasperViewer.viewReport(jprint);
                JasperPrintManager.printReport(jprint, false);
            } catch (JRException ex) {
                Logger.getLogger(barcodeProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void txtSerchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerchNameKeyReleased
        // TODO add your handling code here:
        ArrayList<productCode> al = new ArrayList<productCode>();
        //al = new ArrayList<AddProducts>();
        String val = txtSerchName.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from product where name like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            productCode pro;
            while (rs.next()) {
                pro = new productCode(rs.getString("Barcode"), rs.getString("Name"), rs.getInt("Quantity"), rs.getFloat("BPrice"), rs.getFloat("WPrice"), rs.getFloat("RPrice"));
                al.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
            model.setRowCount(0);
            Object[] row = new Object[6];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getBarcode();
                row[1] = al.get(i).getName();
                row[2] = al.get(i).getQty();
                row[3] = al.get(i).getBprice();
                row[4] = al.get(i).getWprice();
                row[5] = al.get(i).getRprice();
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Product Name", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSerchNameKeyReleased

    private void txtSearchBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBarcodeKeyReleased
        // TODO add your handling code here:
        ArrayList<productCode> al = new ArrayList<productCode>();
        //al = new ArrayList<AddProducts>();
        String val = txtSearchBarcode.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from product where barcode like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            productCode pro;
            while (rs.next()) {
                pro = new productCode(rs.getString("Barcode"), rs.getString("Name"), rs.getInt("Quantity"), rs.getFloat("BPrice"), rs.getFloat("WPrice"), rs.getFloat("RPrice"));
                al.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
            model.setRowCount(0);
            Object[] row = new Object[6];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getBarcode();
                row[1] = al.get(i).getName();
                row[2] = al.get(i).getQty();
                row[3] = al.get(i).getBprice();
                row[4] = al.get(i).getWprice();
                row[5] = al.get(i).getRprice();
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Product Barcode", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchBarcodeKeyReleased

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int i = tblProduct.getSelectedRow();
        TableModel model = tblProduct.getModel();
        txtBarcode.setText(model.getValueAt(i, 0).toString());
        txtName.setText(model.getValueAt(i, 1).toString());
        txtQty.requestFocus();
    }//GEN-LAST:event_tblProductMouseClicked

    private void tblProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            int i = tblProduct.getSelectedRow();
            TableModel model = tblProduct.getModel();
            txtBarcode.setText(model.getValueAt(i, 0).toString());
            txtName.setText(model.getValueAt(i, 1).toString());
        }
    }//GEN-LAST:event_tblProductKeyReleased

    private void txtSerchNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerchNameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tblProduct.requestFocus();
            tblProduct.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_txtSerchNameKeyPressed

    private void txtSearchBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBarcodeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tblProduct.requestFocus();
            tblProduct.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_txtSearchBarcodeKeyPressed

    private void tblProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = tblProduct.getSelectedRow();
            TableModel model = tblProduct.getModel();
            txtBarcode.setText(model.getValueAt(i, 0).toString());
            txtName.setText(model.getValueAt(i, 1).toString());
            txtQty.requestFocus();
        }
    }//GEN-LAST:event_tblProductKeyPressed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int Qty = Integer.parseInt(txtQty.getText());
                int YesORNo = JOptionPane.showConfirmDialog(null, "Are you ready for print barcodes?", "Barcode Print", JOptionPane.YES_NO_OPTION);
                if (YesORNo == 0) {
                    for (int i = 0; i < Qty; i++) {
                        BarcodePrint();
                    }
                    Connection con;
                    PreparedStatement pst1;
                    con = db.getConnection();

                    String query1 = "Insert into barcode_print (date,time,Barcode,Name,Qty) values (CURDATE(),CURTIME(),?,?,?)";
                    pst1 = con.prepareStatement(query1);

                    pst1.setString(1, txtBarcode.getText().trim());
                    pst1.setString(2, txtName.getText().trim());
                    pst1.setInt(3, Qty);
                    pst1.executeUpdate();

                    txtBarcode.setText(null);
                    txtName.setText(null);
                    txtQty.setText(null);
                    txtSerchName.setText(null);
                    txtSearchBarcode.setText(null);
                    txtSerchName.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);//"Alredy Add Product! ,Check The Product", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtQtyKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JLabel txtBarcode;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearchBarcode;
    private javax.swing.JTextField txtSerchName;
    // End of variables declaration//GEN-END:variables
}
