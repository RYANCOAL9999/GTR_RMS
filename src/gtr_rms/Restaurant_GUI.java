package gtr_rms;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Date;

import entities.Restaurant;
import entities.Staff;

/**
 *
 * @author W22079254
 */
public class Restaurant_GUI extends JFrame{

    private static Restaurant restaurant;
    private static Date today;
    private static Staff user;

    /**
     * print out 
     * food remainder, 
     * today's income, 
     * and Tomorrow's Food ingredients
     */
    private void printOutTodayEvent(){
        
    }

    /**
     * 
     */
    private void closeEvent() {
        restaurant.setTodayFirstTimeLoginForAllStaff(false);
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
        JOptionPane.showMessageDialog(this, "Preparation finished, Everything is ready");
        restaurant.setAllReady(true);
    }

    /**
     * 
     */
    private void salesRecordGUIEvent() {
        if(!"manager".equals(user.getRole())){
            JOptionPane.showMessageDialog(this, "Your role is not Manager !");
            return;
        }
        SalesRecord_GUI gui = new SalesRecord_GUI(restaurant, null, "Sales Record:");
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void staffRecordGUIEvent() {
        if(!"manager".equals(user.getRole())){
            JOptionPane.showMessageDialog(this, "Your role is not Manager !");
            return;
        }
        StaffRecord_GUI gui = new StaffRecord_GUI(restaurant);
        gui.setVisible(true);
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
        SalesRecord_GUI gui = new SalesRecord_GUI(restaurant, today, "Orders:");
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void menuGUIEvent() {
        if("staff".equals(user.getRole())){
            JOptionPane.showMessageDialog(this, "Your role is not chef or Manager !");
            return;
        }
        Menu_GUI gui = new Menu_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUIEvent() {
        if("staff".equals(user.getRole())){
            JOptionPane.showMessageDialog(this, "Your role is not chef or Manager !");
            return;
        }
        Ingredients_GUI gui = new Ingredients_GUI(restaurant);
        gui.setVisible(true);
    }

    private void logoutEvent() {
        Authentication_GUI gui = new Authentication_GUI();
        gui.setVisible(true);
        this.dispose();
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
        JButton staffRecordGUIControl = new JButton("Staff Record");
        JButton salesRecordGUIControl = new JButton("Sales Record");

        tablePanel_Center.add(tableGUIControl, BorderLayout.WEST);
        tablePanel_Center.add(staffRecordGUIControl, BorderLayout.CENTER);
        tablePanel_Center.add(salesRecordGUIControl, BorderLayout.EAST);
        
        JButton logout  = new JButton("Logout");
        JButton preparedFinished = new JButton("Ready");
        JButton closeOfBusiness = new JButton("Close");

        tablePanel_South.add(logout, BorderLayout.WEST);
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
        staffRecordGUIControl.addActionListener(e -> staffRecordGUIEvent());    
        salesRecordGUIControl.addActionListener(e -> salesRecordGUIEvent());
        logout.addActionListener(e -> logoutEvent());    
        preparedFinished.addActionListener(e -> ReadyEvent());
        closeOfBusiness.addActionListener(e -> closeEvent());
        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * @param res
     * @param userSession
     */
    public Restaurant_GUI(Restaurant res, Staff userSession){
        restaurant = res;
        user = userSession;
        today = new Date();
        this.initializeGUI();
    }

}
