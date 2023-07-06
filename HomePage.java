import javax.swing.*;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener{
    private JButton button1;
    private JButton button2;
    
    HomePage() {
        setTitle("Two Buttons");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        JPanel mainPanel = new JPanel();
        button1 = new JButton("Log in");
        button2 = new JButton("Sign up");
        button1.addActionListener(this);
        button2.addActionListener(this);
        mainPanel.add(button1);
        mainPanel.add(button2);
        add(mainPanel);
    }
    LoginGUI login = new LoginGUI();
    SignUpGUI signup = new SignUpGUI();
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() ==button1) {
            login.setVisible(true);
            signup.setVisible(false);
        }
        else if (e.getSource() == button2) {   
            login.setVisible(false);
            signup.setVisible(true);
        }
    }
}
