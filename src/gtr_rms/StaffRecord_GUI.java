package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Restaurant;
import entities.Staff;

/**
 *
 * @author W22079254
 */
public class StaffRecord_GUI extends JFrame{

    private Restaurant restaurant;

    private List<JButton> staffItem;

    private final int constantsNumber = 3;

    /**
     * 
     * @param text
     */
    private void staffSingleItemClick(String text) {
        Staff staffSingle = restaurant.getStaff(text);
        Staff_GUI gui = new Staff_GUI(restaurant, staffSingle);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void addNewStaff() {
        Staff_GUI gui = new Staff_GUI(restaurant, null);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI() {
        staffItem = new ArrayList<>();

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

         /**
         * List out All staff such as chef and waiters
         * add Personal Details, contact information, roles, and work schedules
         */

        //North
        JLabel labelShowName = new JLabel("Staff:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        //Center
        for(Staff staff : restaurant.getStaffList()){
            JButton orderButton = new JButton(String.valueOf(staff.getUsername()));
            staffItem.add(orderButton);
        }

        //South
        JButton addNewStaff = new JButton("addNewStaff");

        tablePanel_North.add(labelShowName, BorderLayout.CENTER);

        for(int i=0; i<staffItem.size(); i++){
            JButton item = staffItem.get(i);
            item.setPreferredSize(new Dimension( 20, 24 ));
            tablePanel_Center.add(item, Helper.getCheckBoxConstraints(i, constantsNumber));
        }

        tablePanel_South.add(addNewStaff, BorderLayout.EAST);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        for(JButton item: staffItem){
            item.addActionListener(e -> staffSingleItemClick(item.getText()));
        }

        addNewStaff.addActionListener(e -> addNewStaff());    

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(270, 150);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * @param res
     */
    public StaffRecord_GUI(Restaurant res){
        this.restaurant = res;
        this.initializeGUI();
    }


}
