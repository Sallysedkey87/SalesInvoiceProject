package com.myfwdcourse.fwdfirstproject.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewItemDialog extends JDialog {

    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;

    public NewItemDialog(NewJFrame frame) {
        itemNameField = new JTextField(20);
        itemNameLbl = new JLabel("Item Name");

        itemCountField = new JTextField(20);
        itemCountLbl = new JLabel("Item Count");

        itemPriceField = new JTextField(20);
        itemPriceLbl = new JLabel("Item Price");

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("newLineOK");
        cancelBtn.setActionCommand("newLineCancel");

        okBtn.addActionListener(frame.getListenner());
        cancelBtn.addActionListener(frame.getListenner());
        setLayout(new GridLayout(4, 2));

        add(itemNameLbl);
        add(itemNameField);
        add(itemCountLbl);
        add(itemCountField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(okBtn);
        add(cancelBtn);

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}
