import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;

public class CreditCardTransactionGUI extends JFrame implements ActionListener {
    
    private JLabel cardNumberLabel, expiryDateLabel, cvvLabel, nameHolder;
    private JTextField cardNumberField, expiryDateField, cvvField, nameHolderField;
    private JButton submitButton, clearButton;
    double a;
    
    public CreditCardTransactionGUI(double amount) {
        a = amount;
        setTitle("Credit Card Transaction");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(5, 2));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        cardNumberLabel = new JLabel("Card Number:");
        expiryDateLabel = new JLabel("Expiry Date (mm/yy):");
        cvvLabel = new JLabel("CVV:");
        nameHolder = new JLabel("Name Holder:");
        
        cardNumberField = new JTextField(16);
        expiryDateField = new JFormattedTextField(createFormatter("##/##"));
        cvvField = new JTextField(3);
        nameHolderField = new JTextField(10);
        
        submitButton = new JButton("Check out");
        clearButton = new JButton("Clear");
        
        add(nameHolder);
        add(nameHolderField);
        add(cardNumberLabel);
        add(cardNumberField);
        add(expiryDateLabel);
        add(expiryDateField);
        add(cvvLabel);
        add(cvvField);
        add(submitButton);
        add(clearButton);
        
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String cardNumber = cardNumberField.getText();
            String expiryDate = expiryDateField.getText();
            String cvv = cvvField.getText();
            String nameHolder = nameHolderField.getText();
            // perform transaction processing here
            CreditCardTransaction creditcard = new CreditCardTransaction(nameHolder, expiryDate, cardNumber, cvv);
            if (creditcard.authorized()) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to complete the transaction of $" + String.valueOf(a) + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Transaction completed.");
                    dispose();
                };
            }
            else {
                JOptionPane.showMessageDialog(this, "Transaction failed. Please try again");
            }
        } else if (e.getSource() == clearButton) {
            cardNumberField.setText("");
            expiryDateField.setText("");
            cvvField.setText("");
            nameHolderField.setText("");
        }
    }
    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("Error creating formatter: " + exc.getMessage());
        }
        return formatter;
    }
    
    public static void main(String[] args) {
        CreditCardTransactionGUI gui = new CreditCardTransactionGUI(32.00);
    }
}
