package gtr_rms;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class Restaurant_GUI extends JFrame{

    /**
     * @param args the command line arguments
     */
    private final static String restaurntName = "";
    private final static String restaurntAddress = "";
    private final static String restaurntPhone = "";

    private static Restaurant restaurant;

    /**
     * print out 
     * food remainder, 
     * today's income, 
     * and Tomorrow's Food ingrediention
     */
    private void printOutTodayEvent(){

    }

    /**
     * 
     */
    private void CloseEvent() {
        restaurant.getInventory().setIngredientsReady(false);
        restaurant.setMenuReady(false);
        restaurant.setAllReady(false);
        printOutTodayEvent();
        System.exit(0);
    }

    /**
     * 
     */
    private void ReadyEvent() {
        if(
            !restaurant.getInventory().getIngredientsReady() &&
            !restaurant.getMenuReady()
        ){
            JOptionPane.showMessageDialog(this, "Preparation is not ready! Please Check");
            return;
        }
        JOptionPane.showMessageDialog(this, "Ingredients food action finished!");
        restaurant.setAllReady(true);
    }

    /**
     * 
     */
    private void salesGUIEvent() {
        /**
         * List out sales staff
         */
        // gui.setVisible(true);
    }

    /**
     * 
     */
    private void staffGUIEvent() {
        /**
         * List out All staff
         */
        // gui.setVisible(true);
    }

    /**
     * 
     */
    private void tableGUIEvent() {
        if(!restaurant.getAllReady()){
            JOptionPane.showMessageDialog(this, "Restaurant is not ready, and it cannot serve customer !");
            return;
        }
        Table_GUI gui = new Table_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void orderGUIEvent() {
        /**
         * List out All Order
         */
        // Order_GUI gui = new Order_GUI(restaurant);
        // gui.setVisible(true);
    }

    /**
     * 
     */
    private void menuGUIEvent() {
        Menu_GUI gui = new Menu_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUIEvent() {
        Ingredients_GUI gui = new Ingredients_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI(){

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        JButton ingredientsGUIControl = new JButton("Ingredients");
        JButton menuGUIControl = new JButton("Menu");
        JButton orderGUIControl = new JButton("Order");

        tablePanel_North.add(ingredientsGUIControl, BorderLayout.WEST);
        tablePanel_North.add(menuGUIControl, BorderLayout.CENTER);
        tablePanel_North.add(orderGUIControl, BorderLayout.EAST);
        
        JButton tableGUIControl = new JButton("Table");
        JButton staffGUIControl = new JButton("Staff");
        JButton salesGUIControl = new JButton("Sales");

        tablePanel_Center.add(tableGUIControl, BorderLayout.WEST);
        tablePanel_Center.add(staffGUIControl, BorderLayout.CENTER);
        tablePanel_Center.add(salesGUIControl, BorderLayout.EAST);
        
        JButton loginUser  = new JButton(" ");
        JButton preparedFinished = new JButton("Ready");
        JButton closeOfBusiness = new JButton("Close");

        tablePanel_South.add(loginUser, BorderLayout.EAST);
        tablePanel_South.add(preparedFinished, BorderLayout.CENTER);
        tablePanel_South.add(closeOfBusiness, BorderLayout.EAST);
        
        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        ingredientsGUIControl.addActionListener(e -> initializeGUIEvent());    
        menuGUIControl.addActionListener(e -> menuGUIEvent());
        orderGUIControl.addActionListener(e -> orderGUIEvent());    
        tableGUIControl.addActionListener(e -> tableGUIEvent());
        staffGUIControl.addActionListener(e -> staffGUIEvent());    
        salesGUIControl.addActionListener(e -> salesGUIEvent());
        // loginUser.addActionListener(e -> placeTable());    
        preparedFinished.addActionListener(e -> ReadyEvent());
        closeOfBusiness.addActionListener(e -> CloseEvent());
        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     */
    public Restaurant_GUI(){
        restaurant = new Restaurant(restaurntName, restaurntAddress, restaurntPhone);
        this.initializeGUI();
    }

}
