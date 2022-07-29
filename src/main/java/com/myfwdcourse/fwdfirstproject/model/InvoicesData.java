package com.myfwdcourse.fwdfirstproject.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoicesData {

    private int invoiceNumber;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<ItemsData> items;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private ArrayList<ItemsData> itemsData;

    public InvoicesData(int invoiceNumber, Date invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<ItemsData> getItemsData() {
        if (itemsData == null) {
            itemsData = new ArrayList<>();
        }
        return itemsData;
    }

    public void setItemsData(ArrayList<ItemsData> itemsData) {
        this.itemsData = itemsData;
    }

    public double getTotal() {
        double total = 0.0;

        for (int i = 0; i < getLines().size(); i++) {
            total += getLines().get(i).getTotal();
        }

        return total;
    }

    public ArrayList<ItemsData> getLines() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setLines(ArrayList<ItemsData> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return invoiceNumber + "," + df.format(invoiceDate) + "," + customerName;
    }

}
