package com.myfwdcourse.fwdfirstproject.model;

public class ItemsData {

    private String itemName;
    private Double itemPrice;
    private int count;
    private InvoicesData invoices;

    public ItemsData(String itemName, Double itemPrice, int count, InvoicesData invoices) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoices = invoices;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoicesData getInvoices() {
        return invoices;
    }

    public void setInvoices(InvoicesData invoices) {
        this.invoices = invoices;
    }

    public double getTotal() {
        return getCount() * getItemPrice();
    }

    @Override
    public String toString() {
        return invoices.getInvoiceNumber() + "," + itemName + "," + itemPrice + "," + count;
    }

}
