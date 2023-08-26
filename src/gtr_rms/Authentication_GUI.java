package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Restaurant;
import entities.Staff;

/**
 * Authentication_GUI class 
 * @author W22079254
 */
public class Authentication_GUI extends JFrame{

    private Restaurant restaurant;
    
    private JTextField userName;

    private JTextField password;
    
    /**
     * return User
     * @param name String 
     * @param password String
     * @return Staff
     */
    public Staff getUser(String name, String password){
        
        if(name == null || password == null){
            return null;
        }
        
        Staff user = restaurant.getStaff(name);
        
        if(user == null || !user.getPassword().equals(password)){
            return null;
        }
        
        if(!user.getTodayFirstTimeLogin()){
            user.setTodayFirstTimeLogin(true);
            user.addBackTowork();
        }
        
        return user;
        
    }

    /**
     * 
     * Staff login with action listeners
     * 
     */
    private void LoginEvent(){
        // getStaff
        Staff user = getUser(userName.getText(), password.getText());
        if(user == null){
            JOptionPane.showMessageDialog(this, "Authentication Error");
            return;
        }
        Restaurant_GUI gui = new Restaurant_GUI(restaurant, user);
        gui.setVisible(true);
        this.dispose();
    }

    /**
     * 
     * Create the authentication GUI
     * 
     */
    private void initializeGUI(){

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Upper = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Down = new JPanel(new BorderLayout());

        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_Center_Upper = new JPanel(new BorderLayout());
        JPanel tablePanel_Center_Down = new JPanel(new BorderLayout());

        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        // LoginEvent
        //North
        JLabel labelShowName = new JLabel("UserName:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));
        userName = new JTextField();
        userName.setPreferredSize(new Dimension( 120, 24 ));

        //Center
        JLabel labelShowPassword = new JLabel("Password:");
        labelShowPassword.setPreferredSize(new Dimension( 120, 24 ));
        password = new JTextField();
        password.setPreferredSize(new Dimension( 120, 24 ));

        //South
        JButton LoginButton = new JButton("Login");

        tablePanel_North_Upper.add(labelShowName, BorderLayout.CENTER);
        tablePanel_North_Down.add(userName, BorderLayout.CENTER);

        tablePanel_Center_Upper.add(labelShowPassword, BorderLayout.CENTER);
        tablePanel_Center_Down.add(password, BorderLayout.CENTER);

        tablePanel_South.add(LoginButton, BorderLayout.EAST);

        tablePanel_North.add(tablePanel_North_Upper, BorderLayout.NORTH);
        tablePanel_North.add(tablePanel_North_Down, BorderLayout.SOUTH);

        tablePanel_Center.add(tablePanel_Center_Upper, BorderLayout.NORTH);
        tablePanel_Center.add(tablePanel_Center_Down, BorderLayout.SOUTH);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        LoginButton.addActionListener(e -> LoginEvent());    

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 150);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    /**
     * 
     * Authentication_GUI constructor
     * 
     */
    public Authentication_GUI(Restaurant res){
        super("Restaurant Management System Authentication");
        this.restaurant = res;
        this.initializeGUI();
    }

}
