import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class homescreenGUI extends JFrame implements ActionListener {
    private JPanel contentPanel = new JPanel();
    private JLabel title = new JLabel("Available Movies");
    private JButton btnChangeTheaterLocation = new JButton("Change Theater Locations");

    private JButton accountSettings = new JButton("Account Settings");

    private JScrollPane materialScrollPane;

    private JPanel movieDisplayPanel = new JPanel();

    //Stores all the materials in the database and everything that is stored in the list
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    public static ArrayList<Movie> materialList;
    private ArrayList<JLabel> materialNames = new ArrayList<JLabel>();

    //Stores all the images of the materials
    private ArrayList<JLabel> movieImages = new ArrayList<JLabel>();

    public homescreenGUI() {
        
        panelSetup();
        buttonsSetup();
        frameSetup();

    }

    public void panelSetup() {

        contentPanel.setLayout(null);
        contentPanel.setVisible(true);
        contentPanel.setBounds(0, 0, 1280, 720);
        contentPanel.setBackground(new Color(147, 196, 125));

        materialScrollPane = new JScrollPane(movieDisplayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        materialScrollPane.setBounds(50, 80, 1170, 520);

        movieDisplayPanel.setLayout(null);
        movieDisplayPanel.setVisible(true);
        movieDisplayPanel.setBounds(50, 80, 1170, 520);
        movieDisplayPanel.setBackground(Color.WHITE);

        title.setFont(new Font("Ultra", Font.BOLD, 40));
        title.setBounds(450, 30, 500, 60);
        title.setForeground(Color.black);

        contentPanel.add(title);
        contentPanel.add(movieDisplayPanel);

    }

//    public void displayTheOneMovie(int quantityAsked) {
//        //Adds the images to the panel
//        movieImages.add(imageResize(materials.get(similarities.get(0)).getPhoto(), 150, 100));
//        movieImages.get(0).setBounds(30, 100, 150, 100);
//        movieDisplayPanel.add(movieImages.get(0));
//
//        //Adds the names to the panel
//        materialName.setText(materials.get(similarities.get(0)).getName());
//        materialName.setFont(new Font("Ultra", Font.BOLD, 15));
//        materialName.setBounds(270, 100, 200, 100);
//        materialDisplayPanel.add(materialName);
//
//        //Adds the costs to the panel
//        materialCost.setText("$ " + materials.get(similarities.get(0)).getPrice() * quantityAsked);
//        materialCost.setFont(new Font("Ultra", Font.BOLD, 15));
//        materialCost.setBounds(480, 100, 200, 100);
//        materialDisplayPanel.add(materialCost);
//
//        //Adds the units to the panel
//        materialUnits.setText(materials.get(similarities.get(0)).getUnits());
//        materialUnits.setFont(new Font("Ultra", Font.BOLD, 15));
//        materialUnits.setBounds(680, 100, 200, 100);
//        materialDisplayPanel.add(materialUnits);
//
//        if (quantityAsked == 1) {
//            materialQuantityInput.get(0).setText("1");
//        }
//
//        //Adds the textbox to the panel
//        materialQuantityInput.get(0).setFont(new Font("Ultra", Font.BOLD, 15));
//        materialQuantityInput.get(0).setBounds(655, 142, 20, 17);
//        materialDisplayPanel.add(materialQuantityInput.get(0));
//        addButton1.setVisible(true);
//        materialDisplayPanel.add(addButton1);
//    }
//
//    //Stores the images of all the materials to be used in the materials class
//    public void storeImages() {
//
//        //Stores the photos in the materials arraylist
//        movies.get(0).setPhoto("images/Photo1.jpg");
//        movies.get(1).setPhoto("images/Photo2.jpg");
//        movies.get(2).setPhoto("images/Photo3.jpg");
//        movies.get(3).setPhoto("images/Photo4.jpg");
//        movies.get(4).setPhoto("images/Photo5.jpg");
//        movies.get(5).setPhoto("images/Photo6.jpg");
//        movies.get(6).setPhoto("images/Photo7.jpg");
//        movies.get(7).setPhoto("images/Photo8.jpg");
//
//    }

    public void buttonsSetup() {

        btnChangeTheaterLocation.setBounds(950, 10, 150, 100);
        btnChangeTheaterLocation.addActionListener(this);
        contentPanel.add(btnChangeTheaterLocation);

        accountSettings.setBounds(1120, 10, 150, 100);
//        accountSettings.setFont(new Font("Ultra", Font.BOLD, 25));
        accountSettings.setForeground(Color.black);
        accountSettings.addActionListener(this);
        contentPanel.add(accountSettings);

    }

    public void frameSetup() {

        add(contentPanel);
        setTitle("Movie Ticket Purchasing System");
        setBounds(0, 0, 1280, 720);

        setSize(1280, 720);
        setLayout(null);
        getContentPane().setBackground(new Color(147, 196, 125));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public JLabel imageResize(String imageLocation, int width, int height) {

        // Gets the image location and then gives it a new size
        ImageIcon image = new ImageIcon(imageLocation);
        Image image1 = image.getImage();
        ImageIcon image2 = new ImageIcon(image1.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        JLabel actualImage = new JLabel(image2);
        return actualImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == btnChangeTheaterLocation) {

            this.dispose();
            //new LoginScreenGUI();

        } else if (e.getSource() == accountSettings) {

            //new SignupScreenGUI();

        }

    }


}
