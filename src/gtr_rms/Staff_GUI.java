package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Restaurant;
import entities.Staff;

/**
 * Staff_GUI class
 * @author W22079254
 */
public class Staff_GUI extends JFrame {

    private Restaurant restaurant;
    
    private Staff staff;

    private JTextField userName;
    
    private JTextField role;
    
    private JTextField contact;
    
    /**
     * add staff with Text and staffIsNull
     * @param userNameText String
     * @param roleText String
     * @param contactText String
     * @param staffIsNull Boolean
     */
    public void addStaffWithText(String userNameText, String roleText, String contactText, Boolean staffIsNull){
        if(staffIsNull) {
            restaurant.addStaff(
                new Staff(
                    userNameText,
                    "", 
                    roleText, 
                    contactText,
                    null
                )
            );
        }
        else{
            staff.setRole(roleText);
            staff.setContact(contactText);
        }
    }

    /**
     * 
     * Cancel add staff with action listeners
     * 
     */
    private void cancelEvent() {
        this.dispose();
    }

    /**
     * Add staff with action listeners
     * @param staffIsNull Boolean
     */
    private void confirmEvent(Boolean staffIsNull) {
        this.addStaffWithText(userName.getText(), role.getText(), contact.getText(), staffIsNull);
        this.dispose();
    }

    /**
     * 
     * Create the adding staff GUI
     * 
     */
    private void initializeGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

        /**
         * North 
         */
        JLabel labelShowName = new JLabel("UserName:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        Boolean staffIsNull = this.staff == null;

        userName = new JTextField(staffIsNull?"":this.staff.getUsername());
        userName.setPreferredSize(new Dimension( 120, 24 ));
        userName.setEnabled(staffIsNull);

        JLabel labelShowRole = new JLabel("Role:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        role = new JTextField(staffIsNull?"":this.staff.getRole());
        role.setPreferredSize(new Dimension( 120, 24 ));

        JLabel labelShowContact = new JLabel("Contact:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        contact = new JTextField(staffIsNull?"":this.staff.getContact());
        contact.setPreferredSize(new Dimension( 120, 24 ));

        /**
         * South
         */
        JButton confirmButton = new JButton("confirm Button");
        JButton cancelButton = new JButton("cancel Button");

        tablePanel_North.add(labelShowName, BorderLayout.WEST);
        tablePanel_North.add(labelShowRole, BorderLayout.CENTER);
        tablePanel_North.add(labelShowContact, BorderLayout.EAST);

        tablePanel_Center.add(userName, BorderLayout.WEST);
        tablePanel_Center.add(role, BorderLayout.CENTER);
        tablePanel_Center.add(contact, BorderLayout.EAST);

        tablePanel_South.add(confirmButton, BorderLayout.CENTER);
        tablePanel_South.add(cancelButton, BorderLayout.EAST);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        confirmButton.addActionListener(e -> confirmEvent(staffIsNull));    
        cancelButton.addActionListener(e -> cancelEvent());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * Staff_GUI constructor
     * @param res Restaurant
     * @param staff Staff
     */
    public Staff_GUI(Restaurant res, Staff staff) {
        super("Restaurant Management System Staff");
        this.restaurant = res;
        if(staff != null){
            this.staff = staff;
        }
        this.initializeGUI();
    }

}
