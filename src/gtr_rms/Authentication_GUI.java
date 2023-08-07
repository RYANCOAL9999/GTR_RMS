package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import entities.Restaurant;
import entities.Staff;
import entities.MenuItem;
import entities.Inventory;
import entities.Food;

/**
 *
 * @author W22079254
 */
public class Authentication_GUI extends JFrame{

    private static final String filePath = "restaurant.xml";

    private static Restaurant restaurant;

    private JTextField userName;
    private JTextField password;

    private void LoginEvent(){
        // getStaff
        String name = userName.getText();
        Staff user = restaurant.getStaff(name);

        if(user == null || !user.getPassword().equals(password.getText())){
            JOptionPane.showMessageDialog(this, "Authentication Error");
            return;
        }

        if(!user.getTodayFirstTimeLogin()){
            user.setTodayFirstTimeLogin(true);
            user.addBackTowork();
        }

        Restaurant_GUI gui = new Restaurant_GUI(restaurant, user);
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
    
    public HashMap<String, Object> getRestaurantBYJson(){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        HashMap<String, Object> map = new HashMap<>();
        
        try{
            Reader reader = new FileReader("restaurant.json");
            map = (HashMap<String,Object>) gson.fromJson(reader, map.getClass()); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return map;
    }
    
    /**
     * 
     */
    public Authentication_GUI(){
        
        HashMap<String, Object> data = this.getRestaurantBYJson();
         
                
        if(data == null){
            return;
        }
        
        LinkedTreeMap<String, Object> inventoryTreeMap = (LinkedTreeMap<String, Object>) data.get("inventory");
        
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
            (ArrayList<Food>) data.get("ingredientList")
        );        
        
        restaurant = new Restaurant(
            (String) data.get("restaurntName"),
            (String) data.get("restaurntAddress"), 
            (String) data.get("restaurntPhone"),
            (ArrayList<MenuItem>) data.get("distList"),
            (ArrayList<Staff>) data.get("staffList"),
            inventory
        );
        this.initializeGUI();
    }

}
