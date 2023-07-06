// pass in Userid

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSettingsPage extends JFrame implements ActionListener{
    private JPanel panel1;
    private JButton historyButton;
    private JButton changePasswordButton;


    public AccountSettingsPage(User user) {
        // set up the window properties
        setTitle("Account Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        // create the panel to hold the components
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 2));

        // create the components
        JLabel nameLabel = new JLabel("User name:");
        JLabel nameField = new JLabel(user.getUsername());
        JLabel addressLabel = new JLabel("Address:");
        JLabel addressField = new JLabel("user.account.accountSettings.address");
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        JLabel paymentMethodField = new JLabel("user.account.accountSettings.paymentMethod");
        JLabel update = new JLabel("Update*:");
        JLabel message = new JLabel("No message");
        historyButton = new JButton("View History");
        historyButton.addActionListener(this);
        changePasswordButton = new JButton("Change Password");
        changePasswordButton.addActionListener(this);

        // add the components to the panel
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(addressLabel);
        panel1.add(addressField);
        panel1.add(paymentMethodLabel);
        panel1.add(paymentMethodField);
        panel1.add(update);
        panel1.add(message);
        panel1.add(historyButton);
        panel1.add(changePasswordButton);

        // add the panel to the frame
        add(panel1);

        // set the frame to be visible
        setVisible(true);
    }
    public static void main (String[] args) {
        new AccountSettingsPage(new User(2));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == historyButton) {
            System.out.println("HELLO");
        }
        else if (e.getSource() == changePasswordButton) {
            ChangePasswordGUI change = new ChangePasswordGUI();
            change.setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
