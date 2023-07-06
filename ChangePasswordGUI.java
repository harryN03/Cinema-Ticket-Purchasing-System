import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ChangePasswordGUI extends JFrame implements ActionListener {
   // GUI components
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JPasswordField newPassword;
   private JPasswordField confirmNewJPasswordField;
   private JButton changeButton;
   private JLabel messageLabel;
   // File to store user information
   private static final String USER_FILE = "users.csv";

   public ChangePasswordGUI() {
      // Set up the GUI components
      setTitle("Change Password");
      setSize(600, 350);
      setResizable(false);
      setLocationRelativeTo(null);
      setVisible(true);

      Container contentPane = getContentPane();
      contentPane.setLayout(new GridLayout(5, 2, 5, 5));
      usernameField = new JTextField();
      passwordField = new JPasswordField();
      newPassword = new JPasswordField();
      confirmNewJPasswordField = new JPasswordField();
      changeButton = new JButton("Change password");
      changeButton.addActionListener(this);
      messageLabel = new JLabel();

      contentPane.add(new JLabel("Username: "));
      contentPane.add(usernameField);
      contentPane.add(new JLabel("Old password: "));
      contentPane.add(passwordField);
      contentPane.add(new JLabel("New password"));
      contentPane.add(newPassword);
      contentPane.add(new JLabel("Comfirm new password:"));
      contentPane.add(confirmNewJPasswordField);
      contentPane.add(changeButton);
      contentPane.add(messageLabel);
}

   public void actionPerformed(ActionEvent event) {
      if (event.getSource() == changeButton) {
         // Get the user information from the text fields
         String username = new String(usernameField.getText());
         String oldpass = new String(passwordField.getPassword());
         String newpass = new String(newPassword.getPassword());
         String confirmNew = new String(confirmNewJPasswordField.getPassword());
         if (!checkUser(username, oldpass)) {
            messageLabel.setText("User name or old password not correct");
         }
         if (newpass.isEmpty() || confirmNew.isEmpty()) {
            messageLabel.setText("New password cannot be empty");
         }
         // Check if the old password match with the new one
         else if (newpass != confirmNew)  {
            messageLabel.setText("Password does not match");
        }

         // Store the user information in the file
         try (BufferedReader in = new BufferedReader(new FileReader(USER_FILE));
           PrintWriter out = new PrintWriter(new FileWriter(USER_FILE + ".tmp"))) {
         String line;
         while ((line = in.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
               parts[1] = newpass;
               line = String.join(",", parts);
            }
            out.println(line);
         }
      } catch (IOException e) {
         messageLabel.setText("Error updating user information");
         return;
      }
      
      // Replace the original file with the updated file
      File originalFile = new File(USER_FILE);
      originalFile.delete();
      File updatedFile = new File(USER_FILE + ".tmp");
      updatedFile.renameTo(originalFile);
      
      // Display success message
      messageLabel.setText("User information updated successfully");
      }
   }

   public static void main(String[] args) {
      ChangePasswordGUI gui = new ChangePasswordGUI();
      gui.setVisible(true);
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
         messageLabel.setText("Error checking user information");
         return false;
      }
   }
}
