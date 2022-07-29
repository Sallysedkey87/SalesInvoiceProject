package com.myfwdcourse.fwdfirstproject.model;

import com.myfwdcourse.fwdfirstproject.view.NewJFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceTableModel extends AbstractTableModel {

    private ArrayList<InvoicesData> invoicesArray;
    private String[] columns = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};

    public InvoiceTableModel(ArrayList<InvoicesData> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoicesData inv = invoicesArray.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inv.getInvoiceNumber();
            case 1:
                return NewJFrame.sdf.format(inv.getInvoiceDate());
            case 2:
                return inv.getCustomerName();
            case 3:
                return inv.getTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
