/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import code.reportCode;
import database.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M_Samly
 */
public class reportYearly extends javax.swing.JInternalFrame {

    /**
     * Creates new form incomemonth
     */
    public reportYearly() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

         show_Report();
    }

    public ArrayList<reportCode> reportList() {
        ArrayList<reportCode> reportList = new ArrayList<>();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from sales WHERE YEAR(date) = YEAR(CURDATE()) order by b_id";
            ResultSet rs = st.executeQuery(query);
            reportCode pro;
            while (rs.next()) {
                pro = new reportCode(rs.getInt("b_id"), rs.getString("cashier"), rs.getString("date"), rs.getString("time"), rs.getInt("item"), rs.getString("customer"), rs.getString("type"), rs.getFloat("total"), rs.getFloat("discount"), rs.getFloat("payment"), rs.getFloat("balance"));
                reportList.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reportList;
    }

    public void show_Report() {
        ArrayList<reportCode> al = reportList();
        DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
        Object[] row = new Object[11];
        for (int i = 0; i < al.size(); i++) {
            row[0] = al.get(i).getBilno();
            row[1] = al.get(i).getCashier();
            row[2] = al.get(i).getDate();
            row[3] = al.get(i).getTime();
            row[4] = al.get(i).getItem();
            row[5] = al.get(i).getCustomer();
            row[6] = al.get(i).getType();
            row[7] = al.get(i).getTotal();
            row[8] = al.get(i).getDiscount();
            row[9] = al.get(i).getPayment();
            row[10] = al.get(i).getBalance();
            model.addRow(row);
        }
        totalincome();
    }

    public void totalincome() {
        float totalincome = 0;
        float cash = 0;
        float returnAmount = 0;
        float expence = 0;
        float card = 0;
        float loan = 0;
        float cheque = 0;
        float totalSales = 0;
        String type = "";
        for (int i = 0; i < tblReport.getRowCount(); i++) {
            float Total = (Float.parseFloat(tblReport.getValueAt(i, 7).toString()));
            totalincome = totalincome + Total;
            type = tblReport.getValueAt(i, 6).toString();
            if (type.equalsIgnoreCase("Cash")) {
                cash = cash + Total;
            } else if (type.equalsIgnoreCase("Card")) {
                card = card + Total;
            } else if (type.equalsIgnoreCase("Return")) {
                returnAmount = returnAmount + Total;
            } else if (type.equalsIgnoreCase("Expence")) {
                expence = expence + Total;
            } else if (type.equalsIgnoreCase("Loan")) {
                loan = loan + Total;
            } else if (type.equalsIgnoreCase("Cheque")) {
                cheque = cheque + Total;
            }
        }
        totalSales = cash + returnAmount - loan - expence;
        txtCash.setText(String.valueOf(new DecimalFormat("0.00").format(cash)));
        txtCard.setText(String.valueOf(new DecimalFormat("0.00").format(card)));
        txtReturn.setText(String.valueOf(new DecimalFormat("0.00").format(returnAmount)));
        txtExpense.setText(String.valueOf(new DecimalFormat("0.00").format(expence)));
        txtLoan.setText(String.valueOf(new DecimalFormat("0.00").format(loan)));
        txtCheque.setText(String.valueOf(new DecimalFormat("0.00").format(cheque)));
//        txtIncome.setText(String.valueOf(new DecimalFormat("0.00").format(totalincome)));
        txtTotalSales.setText(String.valueOf(new DecimalFormat("0.00").format(totalSales)));
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
        tblReport = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtsearchbydate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsearchbybillno = new javax.swing.JTextField();
        txtsearchbycustomer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCash = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCard = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtReturn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLoan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCheque = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtExpense = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 712));

        jPanel4.setPreferredSize(new java.awt.Dimension(1024, 662));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill #", "Cashier", "Date", "Time", "Item", "Customer", "Type", "Total", "Discount", "Payment", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReport.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblReport);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 208, 1012, 460));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Search By Date");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 23, 88, -1));

        txtsearchbydate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearchbydate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchbydateKeyReleased(evt);
            }
        });
        jPanel4.add(txtsearchbydate, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 45, 88, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("2023-11-16");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 75, 88, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Search By Bill No.");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 23, -1, -1));

        txtsearchbybillno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearchbybillno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchbybillnoKeyReleased(evt);
            }
        });
        jPanel4.add(txtsearchbybillno, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 45, 97, -1));

        txtsearchbycustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearchbycustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchbycustomerKeyReleased(evt);
            }
        });
        jPanel4.add(txtsearchbycustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 48, 97, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Search By Custmer");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 23, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 180, -1, -1));

        txtCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCash.setText("0.00");
        jPanel4.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 192, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cash");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 79, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("K");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 13, -1));

        txtCard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCard.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCard.setText("0.00");
        jPanel4.add(txtCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 191, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Card");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 79, -1));

        txtReturn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtReturn.setText("0.00");
        jPanel4.add(txtReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 192, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Return");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 79, -1));

        txtLoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLoan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtLoan.setText("0.00");
        jPanel4.add(txtLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 192, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Loan");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 79, -1));

        txtCheque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCheque.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCheque.setText("0.00");
        jPanel4.add(txtCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 192, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Cheque");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 79, -1));

        txtExpense.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtExpense.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtExpense.setText("0.00");
        jPanel4.add(txtExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 192, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Expense");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 79, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("K");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 14, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("K");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 13, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("K");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, 13, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("K");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 13, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("K");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 13, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Total Sale");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 79, -1));

        txtTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalSales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalSales.setText("0.00");
        jPanel4.add(txtTotalSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 192, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("K");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 13, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Total Sales = Cash - Loan - Expence - Return");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 320, -1));

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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
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

    private void txtsearchbydateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchbydateKeyReleased
        // TODO add your handling code here:
        ArrayList<reportCode> al = new ArrayList<reportCode>();
        //al = new ArrayList<AddItems>();
        String val = txtsearchbydate.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from sales where YEAR(date) = YEAR(CURDATE()) AND date like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            reportCode pro;
            while (rs.next()) {
                pro = new reportCode(rs.getInt("b_id"), rs.getString("cashier"), rs.getString("date"), rs.getString("time"), rs.getInt("item"), rs.getString("customer"), rs.getString("type"), rs.getFloat("total"), rs.getFloat("discount"), rs.getFloat("payment"), rs.getFloat("balance"));
                al.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
            model.setRowCount(0);
            Object[] row = new Object[11];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getBilno();
                row[1] = al.get(i).getCashier();
                row[2] = al.get(i).getDate();
                row[3] = al.get(i).getTime();
                row[4] = al.get(i).getItem();
                row[5] = al.get(i).getCustomer();
                row[6] = al.get(i).getType();
                row[7] = al.get(i).getTotal();
                row[8] = al.get(i).getDiscount();
                row[9] = al.get(i).getPayment();
                row[10] = al.get(i).getBalance();
                model.addRow(row);
            }
            totalincome();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Item Name", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtsearchbydateKeyReleased

    private void txtsearchbybillnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchbybillnoKeyReleased
        // TODO add your handling code here:
        ArrayList<reportCode> al = new ArrayList<reportCode>();
        //al = new ArrayList<AddItems>();
        String val = txtsearchbybillno.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from sales where YEAR(date) = YEAR(CURDATE()) AND b_id like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            reportCode pro;
            while (rs.next()) {
                pro = new reportCode(rs.getInt("b_id"), rs.getString("cashier"), rs.getString("date"), rs.getString("time"), rs.getInt("item"), rs.getString("customer"), rs.getString("type"), rs.getFloat("total"), rs.getFloat("discount"), rs.getFloat("payment"), rs.getFloat("balance"));
                al.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
            model.setRowCount(0);
            Object[] row = new Object[11];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getBilno();
                row[1] = al.get(i).getCashier();
                row[2] = al.get(i).getDate();
                row[3] = al.get(i).getTime();
                row[4] = al.get(i).getItem();
                row[5] = al.get(i).getCustomer();
                row[6] = al.get(i).getType();
                row[7] = al.get(i).getTotal();
                row[8] = al.get(i).getDiscount();
                row[9] = al.get(i).getPayment();
                row[10] = al.get(i).getBalance();
                model.addRow(row);
            }
            totalincome();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Item Name", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtsearchbybillnoKeyReleased

    private void txtsearchbycustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchbycustomerKeyReleased
        // TODO add your handling code here:
        ArrayList<reportCode> al = new ArrayList<reportCode>();
        //al = new ArrayList<AddItems>();
        String val = txtsearchbycustomer.getText().toString().trim();
        try {
            Connection con;
            Statement st;
            con = db.getConnection();
            st = con.createStatement();
            String query = "Select * from sales where YEAR(date) = YEAR(CURDATE()) AND customer like '" + val + "%'";
            ResultSet rs = st.executeQuery(query);
            reportCode pro;
            while (rs.next()) {
                pro = new reportCode(rs.getInt("b_id"), rs.getString("cashier"), rs.getString("date"), rs.getString("time"), rs.getInt("item"), rs.getString("customer"), rs.getString("type"), rs.getFloat("total"), rs.getFloat("discount"), rs.getFloat("payment"), rs.getFloat("balance"));
                al.add(pro);
            }

            DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
            model.setRowCount(0);
            Object[] row = new Object[11];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getBilno();
                row[1] = al.get(i).getCashier();
                row[2] = al.get(i).getDate();
                row[3] = al.get(i).getTime();
                row[4] = al.get(i).getItem();
                row[5] = al.get(i).getCustomer();
                row[6] = al.get(i).getType();
                row[7] = al.get(i).getTotal();
                row[8] = al.get(i).getDiscount();
                row[9] = al.get(i).getPayment();
                row[10] = al.get(i).getBalance();
                model.addRow(row);
            }
            totalincome();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot find Item Name", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtsearchbycustomerKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            MessageFormat header = new MessageFormat("All Reports");
            MessageFormat footer = new MessageFormat("Page{0, number, integer}");
            String data[] = {};
            DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
            model.addRow(data);
            String data1[] = {"", "", "", "", "", "", "", "", "", "Total Sales", txtTotalSales.getText()};
            DefaultTableModel model1 = (DefaultTableModel) tblReport.getModel();
            model1.addRow(data1);
            tblReport.print(JTable.PrintMode.FIT_WIDTH, header, footer);

            txtsearchbybillno.setText(null);
            txtsearchbycustomer.setText(null);
            txtsearchbydate.setText(null);
            DefaultTableModel model2 = (DefaultTableModel) tblReport.getModel();
            model2.setRowCount(0);
            show_Report();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblReport;
    public static javax.swing.JLabel txtCard;
    public static javax.swing.JLabel txtCash;
    public static javax.swing.JLabel txtCheque;
    public static javax.swing.JLabel txtExpense;
    public static javax.swing.JLabel txtLoan;
    public static javax.swing.JLabel txtReturn;
    public static javax.swing.JLabel txtTotalSales;
    private javax.swing.JTextField txtsearchbybillno;
    private javax.swing.JTextField txtsearchbycustomer;
    private javax.swing.JTextField txtsearchbydate;
    // End of variables declaration//GEN-END:variables
}
