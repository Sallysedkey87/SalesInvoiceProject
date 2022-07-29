package com.myfwdcourse.fwdfirstproject.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ItemsTableModel extends AbstractTableModel {

    private ArrayList<ItemsData> linesArray;
    private String[] columns = {"Item Name", "Unit Price", "Count", "Line Total"};

    public ItemsTableModel(ArrayList<ItemsData> linesArray) {
        this.linesArray = linesArray;
    }

    @Override
    public int getRowCount() {
        return linesArray == null ? 0 : linesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (linesArray == null) {
            return "";
        } else {
            ItemsData Item = linesArray.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return Item.getItemName();
                case 1:
                    return Item.getItemPrice();
                case 2:
                    return Item.getCount();
                case 3:
                    return Item.getTotal();
                default:
                    return "";
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
