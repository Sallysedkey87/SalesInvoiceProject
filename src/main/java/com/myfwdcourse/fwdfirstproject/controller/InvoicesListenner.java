
package com.myfwdcourse.fwdfirstproject.controller;

import com.myfwdcourse.fwdfirstproject.model.InvoiceTableModel;
import com.myfwdcourse.fwdfirstproject.model.ItemsTableModel;
import com.myfwdcourse.fwdfirstproject.model.InvoicesData;
import com.myfwdcourse.fwdfirstproject.model.ItemsData;
import com.myfwdcourse.fwdfirstproject.view.NewInvoiceDialog;
import com.myfwdcourse.fwdfirstproject.view.NewItemDialog;
import com.myfwdcourse.fwdfirstproject.view.NewJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author LENOVO
 */
public class InvoicesListenner implements ActionListener, ListSelectionListener {

    private NewJFrame frame;
    private NewInvoiceDialog newInvoiceDialog;
    private NewItemDialog newItemDialog;

    public InvoicesListenner(NewJFrame frame) {
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Item":
                newItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "Load Invoice": {
                try {
                    try {
                        loadInvoice(null, null);
                    } catch (ParseException ex) {
                        Logger.getLogger(InvoicesListenner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InvoicesListenner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "Save Invoice":
                saveInvoice();
                break;
            case "newInvoiceOK":
                newInvoiceDialogOK();
                break;

            case "newInvoiceCancel":
                newInvoiceDialogCancel();
                break;

            case "newLineCancel":
                newLineDialogCancel();
                break;

            case "newLineOK":
                newLineDialogOK();
                break;

        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvIndex != -1) {
            InvoicesData selectedInv = frame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<ItemsData> lines = selectedInv.getLines();
            ItemsTableModel lineTableModel = new ItemsTableModel(lines);
            frame.setLinesArray(lines);
            frame.getItemsTable().setModel(lineTableModel);
            frame.getCustomerNameLabel().setText(selectedInv.getCustomerName());
            frame.getInvoiceNoLabel().setText("" + selectedInv.getInvoiceNumber());
            frame.getInvoiceTotalLabel().setText("" + selectedInv.getTotal());
            frame.getInvoiceDateLabel().setText(NewJFrame.sdf.format(selectedInv.getInvoiceDate()));
        }
    }

    private void newInvoice() {
        newInvoiceDialog = new NewInvoiceDialog(frame);
        newInvoiceDialog.setVisible(true);
    }

    private void newItem() {
        newItemDialog = new NewItemDialog(frame);
        newItemDialog.setVisible(true);
    }

    private void deleteItem() {
        int selectedLineIndex = frame.getItemsTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            frame.getLinesArray().remove(selectedLineIndex);
            ItemsTableModel lineTableModel = (ItemsTableModel) frame.getItemsTable().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getInvoiceTotalLabel().setText("" + frame.getInvoicesArray().get(selectedInvoiceIndex).getTotal());
            frame.getInvoiceTableModel().fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

    public void loadInvoice(String invoiceHeaderFilePath, String itemListFilePath) throws IOException, ParseException {
        File headerFile = null;
        File itemFile = null;
        if (invoiceHeaderFilePath == null && itemListFilePath == null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fileChooser.getSelectedFile();
                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemFile = fileChooser.getSelectedFile();
                }
            } else {
                headerFile = new File(invoiceHeaderFilePath);
                itemFile = new File(itemListFilePath);
            }
            if (headerFile != null && itemFile != null) {
                try {
                    List<String> headerItems = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                    List<String> itemLines = Files.lines(Paths.get(itemFile.getAbsolutePath())).collect(Collectors.toList());
                    ArrayList<InvoicesData> invoices = new ArrayList<>();

                    for (String headerItem : headerItems) {
                        String[] parts = headerItem.split(",");
                        int numberString = Integer.parseInt(parts[0]);
                        Date dateString = NewJFrame.sdf.parse(parts[1]);
                        String nameString = parts[2];

                        InvoicesData invoice = new InvoicesData(numberString, dateString, nameString);
                        invoices.add(invoice);

                    }
                    frame.setInvoicesArray(invoices);
                    InvoiceTableModel headerTableModel = new InvoiceTableModel(invoices);
                    frame.setInvoiceTableModel(headerTableModel);
                    frame.getInvoicesTable().setModel(headerTableModel);
                    System.out.println("Invoices File read success");

                    for (String lineLine : itemLines) {
                        String[] arr = lineLine.split(",");
                        String str1 = arr[0];    // invoice num (int)
                        String str2 = arr[1];    // item name   (String)
                        String str3 = arr[2];    // price       (double)
                        String str4 = arr[3];    // count       (int)
                        int invCode = Integer.parseInt(str1);
                        double price = Double.parseDouble(str3);
                        int count = Integer.parseInt(str4);
                        InvoicesData inv = frame.getInvObject(invCode);
                        ItemsData Item = new ItemsData(str2, price, count, inv);
                        inv.getLines().add(Item);
                    }
                } catch (NoSuchFileException ex) {
                    JOptionPane.showMessageDialog(frame, "File Not Found !!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong Date Format !!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong File Format !!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (UncheckedIOException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong File Format !!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        else{
            headerFile = new File(invoiceHeaderFilePath);
            itemFile = new File(itemListFilePath);
            List<String> headerItems = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                    List<String> itemLines = Files.lines(Paths.get(itemFile.getAbsolutePath())).collect(Collectors.toList());
                    ArrayList<InvoicesData> invoices = new ArrayList<>();

                    for (String headerItem : headerItems) {
                        String[] parts = headerItem.split(",");
                        int numberString = Integer.parseInt(parts[0]);
                        Date dateString = NewJFrame.sdf.parse(parts[1]);
                        String nameString = parts[2];

                        InvoicesData invoice = new InvoicesData(numberString, dateString, nameString);
                        invoices.add(invoice);

                    }
                    frame.setInvoicesArray(invoices);
                    InvoiceTableModel headerTableModel = new InvoiceTableModel(invoices);
                    frame.setInvoiceTableModel(headerTableModel);
                    frame.getInvoicesTable().setModel(headerTableModel);
                    System.out.println("Invoices File read success");

                    for (String lineLine : itemLines) {
                        String[] arr = lineLine.split(",");
                        String str1 = arr[0];    // invoice num (int)
                        String str2 = arr[1];    // item name   (String)
                        String str3 = arr[2];    // price       (double)
                        String str4 = arr[3];    // count       (int)
                        int invCode = Integer.parseInt(str1);
                        double price = Double.parseDouble(str3);
                        int count = Integer.parseInt(str4);
                        InvoicesData inv = frame.getInvObject(invCode);
                        ItemsData Item = new ItemsData(str2, price, count, inv);
                        inv.getLines().add(Item);
                    }
        }
    }

    private void saveInvoice() {
        ArrayList<InvoicesData> invoicesArray = frame.getInvoicesArray();
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (InvoicesData invoice : invoicesArray) {
                    headers += invoice.toString();
                    headers += "\n";
                    for (ItemsData line : invoice.getLines()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
                //  w e l c o m e
                //  0 1 2 3 4 5 6
                //  1 2 3 4 5 6 7
                headers = headers.substring(0, headers.length() - 1);
                lines = lines.substring(0, lines.length() - 1);
                result = fc.showSaveDialog(frame);
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                hfw.write(headers);
                lfw.write(lines);
                hfw.close();
                lfw.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newInvoiceDialogCancel() {
        newInvoiceDialog.setVisible(false);
        newInvoiceDialog.dispose();
        newInvoiceDialog = null;
    }

    private void newInvoiceDialogOK() {
        newInvoiceDialog.setVisible(false);

        String custName = newInvoiceDialog.getCustNameField().getText();
        String str = newInvoiceDialog.getInvDateField().getText();
        Date d = new Date();
        try {
            d = NewJFrame.sdf.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot parse date, resetting to today.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }

        int invNum = 0;
        for (InvoicesData inv : frame.getInvoicesArray()) {
            if (inv.getInvoiceNumber() > invNum) {
                invNum = inv.getInvoiceNumber();
            }
        }
        invNum++;
        InvoicesData newInv = new InvoicesData(invNum, d, custName);
        frame.getInvoicesArray().add(newInv);
        frame.getInvoiceTableModel().fireTableDataChanged();
        newInvoiceDialog.dispose();
        newInvoiceDialog = null;
    }

    private void newLineDialogCancel() {
        newItemDialog.setVisible(false);
        newItemDialog.dispose();
        newItemDialog = null;
    }

    private void newLineDialogOK() {
        newItemDialog.setVisible(false);

        String name = newItemDialog.getItemNameField().getText();
        String str1 = newItemDialog.getItemCountField().getText();
        String str2 = newItemDialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(str1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvHeader != -1) {
            InvoicesData invHeader = frame.getInvoicesArray().get(selectedInvHeader);
            ItemsData line = new ItemsData(name, price, count, invHeader);
            //invHeader.getLines().add(line);
            frame.getLinesArray().add(line);
            ItemsTableModel lineTableModel = (ItemsTableModel) frame.getItemsTable().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getInvoiceTableModel().fireTableDataChanged();
        }
        frame.getInvoicesTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        newItemDialog.dispose();
        newItemDialog = null;
    }

    private void deleteInvoice() {
        int selectedInvoiceIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            frame.getInvoicesArray().remove(selectedInvoiceIndex);
            frame.getInvoiceTableModel().fireTableDataChanged();

            frame.getItemsTable().setModel(new ItemsTableModel(null));
            frame.setLinesArray(null);
            frame.getCustomerNameLabel().setText("");
            frame.getInvoiceNoLabel().setText("");
            frame.getInvoiceTotalLabel().setText("");
            frame.getInvoiceDateLabel().setText("");
        }
    }

}
