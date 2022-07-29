package com.myfwdcourse.fwdfirstproject.view;

import com.myfwdcourse.fwdfirstproject.controller.InvoicesListenner;
import com.myfwdcourse.fwdfirstproject.model.InvoiceTableModel;
import com.myfwdcourse.fwdfirstproject.model.InvoicesData;
import com.myfwdcourse.fwdfirstproject.model.ItemsData;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JTable;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(listenner);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceNoLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        newInvoiceButton = new javax.swing.JButton();
        newInvoiceButton.addActionListener(listenner);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(listenner);
        newItemButton = new javax.swing.JButton();
        newItemButton.addActionListener(listenner);
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(listenner);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadInvoice = new javax.swing.JMenuItem();
        loadInvoice.addActionListener(listenner);
        saveInvoice = new javax.swing.JMenuItem();
        saveInvoice.addActionListener(listenner);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice Number", "Invoice Date", "Customer Name", "Invoice Total"
            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        jLabel1.setText("Invoice No.");

        jLabel2.setText("Customer Name");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Invoice Total");

        invoiceNoLabel.setText("jLabel5");

        customerNameLabel.setText("jLabel6");

        invoiceDateLabel.setText("jLabel7");

        invoiceTotalLabel.setText("jLabel8");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Price", "Count", "Total"
            }
        ));
        itemsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemsTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemsTableFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(itemsTable);
        itemsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        newInvoiceButton.setText("New Invoice");
        newInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvoiceButtonActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed(evt);
            }
        });

        newItemButton.setText("New Item");

        deleteItemButton.setText("Delete Item");

        jMenu1.setText("File");

        loadInvoice.setText("Load Invoice");
        loadInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadInvoiceActionPerformed(evt);
            }
        });
        jMenu1.add(loadInvoice);

        saveInvoice.setText("Save Invoice");
        saveInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInvoiceActionPerformed(evt);
            }
        });
        jMenu1.add(saveInvoice);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(newInvoiceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteInvoiceButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(invoiceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoiceNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteItemButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoiceNoLabel))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customerNameLabel))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(invoiceDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(invoiceTotalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newItemButton)
                    .addComponent(deleteItemButton))
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(newInvoiceButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveInvoiceActionPerformed

    private void newInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInvoiceButtonActionPerformed

    private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceButtonActionPerformed

    private void loadInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadInvoiceActionPerformed

    private void itemsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemsTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_itemsTableFocusGained

    private void itemsTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemsTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_itemsTableFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            List<String> fileLines = Files.lines(Paths.get("InvoiceHeader.csv")).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame frame = new NewJFrame();
                frame.setVisible(true);
                try {
                    frame.listenner.loadInvoice("InvoiceHeader.csv", "InvoiceLine.csv");
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceNoLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JTable itemsTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadInvoice;
    private javax.swing.JButton newInvoiceButton;
    private javax.swing.JButton newItemButton;
    private javax.swing.JMenuItem saveInvoice;
    // End of variables declaration//GEN-END:variables

    private ArrayList<InvoicesData> invoicesArray;
    private ArrayList<ItemsData> itemsArray;
    private InvoicesListenner listenner = new InvoicesListenner(this);
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private InvoiceTableModel invoiceTableModel;

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public void setInvoicesTable(JTable invoicesTable) {
        this.invoicesTable = invoicesTable;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    public void setItemsTable(JTable itemsTable) {
        this.itemsTable = itemsTable;
    }

    public ArrayList<InvoicesData> getInvoicesArray() {
        return invoicesArray;
    }

    public void setInvoicesArray(ArrayList<InvoicesData> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    public ArrayList<ItemsData> getLinesArray() {
        return itemsArray;
    }

    public void setLinesArray(ArrayList<ItemsData> linesArray) {
        this.itemsArray = linesArray;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public void setInvoiceDateLabel(JLabel invoiceDateLabel) {
        this.invoiceDateLabel = invoiceDateLabel;
    }

    public JLabel getInvoiceNoLabel() {
        return invoiceNoLabel;
    }

    public void setInvoiceNoLabel(JLabel invoiceNoLabel) {
        this.invoiceNoLabel = invoiceNoLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public void setInvoiceTotalLabel(JLabel invoiceTotalLabel) {
        this.invoiceTotalLabel = invoiceTotalLabel;
    }

    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public void setCustomerNameLabel(JLabel customerNameLabel) {
        this.customerNameLabel = customerNameLabel;
    }

    public void setInvoiceTableModel(InvoiceTableModel invoiceTableModel) {
        this.invoiceTableModel = invoiceTableModel;
    }

    public InvoiceTableModel getInvoiceTableModel() {
        return invoiceTableModel;
    }

    public InvoicesData getInvObject(int code) {
        for (InvoicesData inv : invoicesArray) {
            if (inv.getInvoiceNumber() == code) {
                return inv;
            }
        }
        return null;
    }

    public InvoicesListenner getListenner() {
        return listenner;
    }

    public void setListenner(InvoicesListenner listenner) {
        this.listenner = listenner;
    }

}
