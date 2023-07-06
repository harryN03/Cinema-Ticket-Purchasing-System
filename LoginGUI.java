// update the code line 39

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private static final String USER_FILE = "users.csv";
    
    public LoginGUI() {
        setTitle("Login");
        setSize(300, 150);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        statusLabel = new JLabel("");
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(statusLabel);
        add(mainPanel);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (checkUser(username, password)) {
                    statusLabel.setText("Login successful"); // change this to proceed to account page
                } else {
                    statusLabel.setText("Login failed");
                }
            }
        });
    }
    private boolean checkUser(String username, String password) {
        try (BufferedReader in = new BufferedReader(new FileReader(USER_FILE))) {
           String line;
           while ((line = in.readLine()) != null) {
              String[] parts = line.split(",");
              if (parts[0].equals(username) && parts[1].equals(password)) {
                 return true;
              }
           }
           return false;
        } catch (IOException e) {
           statusLabel.setText("Error checking user information");
           return false;
        }
     }

     public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        gui.setVisible(true);
     }
}
