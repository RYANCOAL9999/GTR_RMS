package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.internal.LinkedTreeMap;

import entities.Restaurant;
import entities.Staff;
import entities.MenuItem;
import entities.Inventory;
import entities.Food;

/**
 * Authentication_GUI class 
 * @author W22079254
 */
public class Authentication_GUI extends JFrame{

    private static final String filePath = "restaurant.json";

    private static Restaurant restaurant;
    
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
    public Authentication_GUI(){
        
        HashMap<String, Object> data = Helper.getRestaurantBYJson(filePath);
                
        if(data == null){
            return;
        }
        
        /**
         * handle Inventory
         */
        LinkedTreeMap<String, Object> inventoryTreeMap = (LinkedTreeMap<String, Object>) data.get("inventory");
        
        ArrayList<LinkedTreeMap> ingredientArrayList = (ArrayList<LinkedTreeMap>) inventoryTreeMap.get("ingredientList");
        
        ArrayList<Food> foodList = new ArrayList<>();
        
        for(LinkedTreeMap ingredientTreeMap :ingredientArrayList){
            Food new_Food = new Food(
                (String) ingredientTreeMap.get("name"),
                "",
                0.0,
                Integer.parseInt(ingredientTreeMap.get("quantity").toString()),
                Double.parseDouble(ingredientTreeMap.get("weight").toString()),
                Double.parseDouble(ingredientTreeMap.get("startingWeight").toString()),
                ingredientTreeMap.get("noEffect") == "true",
                (String) ingredientTreeMap.get("type").toString()
            );
            foodList.add(new_Food);
        }
        
        Inventory inventory = new Inventory(
            Integer.parseInt(inventoryTreeMap.get("chairs").toString()),
            Integer.parseInt(inventoryTreeMap.get("tables").toString()), 
            Integer.parseInt(inventoryTreeMap.get("dishes").toString()), 
            Integer.parseInt(inventoryTreeMap.get("glasses").toString()),
            Integer.parseInt(inventoryTreeMap.get("chopsticks").toString()),
            Integer.parseInt(inventoryTreeMap.get("spoons").toString()),
            Integer.parseInt(inventoryTreeMap.get("tablecloths").toString()),
            Integer.parseInt(inventoryTreeMap.get("napkins").toString()),
            Integer.parseInt(inventoryTreeMap.get("kitchenSupplies").toString()),
            foodList
        );
        
        /*
        * handle Menu
        */
        ArrayList<LinkedTreeMap> dishListArrayList = (ArrayList<LinkedTreeMap>) data.get("dishList");
        
        ArrayList<MenuItem> menuItemList = new ArrayList<>();
        
        for(LinkedTreeMap dishTreeMap :dishListArrayList){
            MenuItem new_Menu = new MenuItem(
               (String) dishTreeMap.get("name"),
               (String) dishTreeMap.get("description"),
               Double.parseDouble(dishTreeMap.get("price").toString())
            );
            menuItemList.add(new_Menu);
        }
        
        /*
        * handle Staff
        */
        ArrayList<LinkedTreeMap> staffListArrayList = (ArrayList<LinkedTreeMap>) data.get("staffList");
        
        ArrayList<Staff> staffList = new ArrayList<>();
        
        for(LinkedTreeMap staffTreeMap :staffListArrayList){
            HashMap<String, Boolean> workScheduleMap = new HashMap<>();
            LinkedTreeMap<String, Object> workScheduleTreepMap = (LinkedTreeMap<String, Object>) staffTreeMap.get("workSchedule");
            for(Map.Entry<String, Object> workSchedule:workScheduleTreepMap.entrySet()){
                workScheduleMap.put(workSchedule.getKey(), workSchedule.getValue() == "true" );
            }
            
            Staff new_staff = new Staff(
                (String) staffTreeMap.get("username"),
                (String) staffTreeMap.get("password"),
                (String) staffTreeMap.get("role"),
                (String) staffTreeMap.get("contact"),
                workScheduleMap
            );
            staffList.add(new_staff);
        }
        
        
        restaurant = new Restaurant(
            (String) data.get("restaurntName"),
            (String) data.get("restaurntAddress"), 
            (String) data.get("restaurntPhone"),
            menuItemList,
            staffList,
            inventory,
            filePath
        );
        this.initializeGUI();
    }

}
