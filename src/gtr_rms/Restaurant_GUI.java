package gtr_rms;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Food;
import entities.Inventory;
import entities.Menu;
import entities.Order;
import entities.Restaurant;
import entities.Staff;


/**
 * Restaurant_GUI class
 * @author W22079254
 */
public class Restaurant_GUI extends JFrame{

    private static Restaurant restaurant;
    
    private static Staff user;

    /**
     * 
     * Export today Data for tomorrow usage.
     * 
     */
    public void exportTomorrowData(){

        File file = new File("restaurant.json");

        try{
            
            Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(file), 
                    StandardCharsets.UTF_8
                )
            );

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            HashMap<String, Object> data = new HashMap<>();

            data.put("restaurntName", restaurant.getName());
            data.put("restaurntAddress", restaurant.getAddress());
            data.put("restaurntPhone", restaurant.getAddress());

            /**
             * only get the no Effect
             */
            Inventory inventory = restaurant.getInventory();

            List<HashMap<String, Object>> newFoodList = new ArrayList<>();
            for(Food newFood : inventory.getIngredients()){
                if(newFood.getNoEffect()){
                    HashMap<String, Object> FoodMap = new HashMap<>();
                    FoodMap.put("name", newFood.getName());
                    FoodMap.put("quantity", newFood.getQuantity());
                    FoodMap.put("weight", newFood.getWeight());
                    FoodMap.put("startingWeight", newFood.getStartingWeight());
                    FoodMap.put("noEffect", newFood.getNoEffect());
                    newFoodList.add(FoodMap);
                }
            }
            
            HashMap<String, Object> inventoryMap = new HashMap<>();
            inventoryMap.put("chairs", 36);
            inventoryMap.put("tables", 9);
            inventoryMap.put("dishes", 500);
            inventoryMap.put("glasses", 100);
            inventoryMap.put("chopsticks", 500);
            inventoryMap.put("spoons", 100);
            inventoryMap.put("tablecloths", 100);
            inventoryMap.put("napkins", 100);
            inventoryMap.put("kitchenSupplies", 500);
            inventoryMap.put("ingredientList", newFoodList);

            data.put("inventory", inventoryMap);

            /**
             * only get the first one
             */
            List<HashMap<String, Object>> newMenuList = new ArrayList<>();
            Menu menuSingle = restaurant.getMenu(0);
            // for (Menu menuSingle : restaurant.getMenuList()){
            HashMap<String, Object> menuMap = new HashMap<>();
            menuMap.put("name", menuSingle.getName());
            menuMap.put("description", menuSingle.getDescription());
            menuMap.put("price", menuSingle.getPrice());
            newMenuList.add(menuMap);
            // }

            data.put("dishList", newMenuList);

            /**
             * 
             *  
             */
            List<HashMap<String, Object>> staffList = new ArrayList<>();

            for (Staff staffSingle : restaurant.getStaffList()){
                HashMap<String, Boolean> workScheduleMap = new HashMap<>();
                for(Map.Entry<String, Boolean> workSchedule:staffSingle.getWorkSchedule().entrySet()){
                    workScheduleMap.put(workSchedule.getKey(), workSchedule.getValue());
                }

                HashMap<String, Object> staffMap = new HashMap<>();
                staffMap.put("username", staffSingle.getUsername()); 
                staffMap.put("password", staffSingle.getPassword());
                staffMap.put("role", staffSingle.getRole());
                staffMap.put("contact", staffSingle.getContact());
                staffMap.put("workSchedule", workScheduleMap);
                staffList.add(staffMap);
            }

            data.put("staffList", staffList);

            /**
             * HashMap to Json String
             */
            String jsonString = gson.toJson(data);
            
            writer.write(jsonString);

            writer.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * print out 
     * food remainder, 
     * today's income, 
     * and Tomorrow's Food ingredients
     */
    public void printOutTodayEvent(){
        
        final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        List<Order> orderFinished = new ArrayList<>();
        for(Order orderItem: restaurant.getOrderList()){
            if(!"paid".equals(orderItem.getTableNumber())){
                orderItem.setTableNumber("paid");
                restaurant.addTodayWage(orderItem.getTotal());
            }
            orderFinished.add(orderItem); 
        }
        
        List<Food> foodRemainer = new ArrayList<>();
        // this one included raw, sashimi, and vegs
        List<Food> ingredients = new ArrayList<>();
        for(Food foodItem: restaurant.getInventoryByIngredients()){
            if(
                !foodItem.getTypeWithStr("vegs") ||
                foodItem.getQuantityEqualToZero() ||
                !foodItem.getTypeWithStr("raw") ||
                !foodItem.getTypeWithStr("sashimi")
            ){
                ingredients.add(foodItem);
            }
            else{
                foodRemainer.add(foodItem);
            }
        }
        
        Double todayWage = restaurant.getTodayWage();
        
        System.out.println(restaurant.getName());
        System.out.println(restaurant.getAddress());
        System.out.println(restaurant.getPhone());
        System.out.println();
        System.out.println("********************************");
        System.out.println("Today Order");
        for(Order order: orderFinished){
            System.out.println("********************************");
            System.out.println("number" + "      " + order.getOrderId());
            System.out.println("Date" + "      " + order.getOrderDate());
            System.out.println("Time" + "      " + order.getOrderTime());
            System.out.println("Total" + "      " + order.getTotal());
        }
        System.out.println("********************************");
        System.out.println();
        System.out.println("********************************");
        System.out.println("Food Reminders");
        for(Food remainer: foodRemainer){
            System.out.println("********************************");
            System.out.println("name" + "      " + remainer.getName());
            System.out.println("name" + "      " + remainer.getQuantity());
        }
        System.out.println("********************************");
        System.out.println();
        System.out.println("********************************");
        System.out.println("Tomorrow ingredients");
        for(Food item: ingredients){
            System.out.println("********************************");
            System.out.println("name" + "      " + item.getName());
            System.out.println("type" + "      " + item.getType());
        }
        System.out.println("********************************");
        System.out.println();
        System.out.println("Today" + "      " + sdf3.format(timestamp));      
        System.out.println("Total" + "      " + todayWage);
        System.out.println();
    }
    
    /**
     * 
     * Close the restaurant
     * 
     */
    private void closeEvent() {
        restaurant.setTodayFirstTimeLoginForAllStaff(false);
        restaurant.getInventory().setIngredientsReady(false);
        restaurant.setMenuReady(false);
        restaurant.setAllReady(false);
        this.printOutTodayEvent();
        this.exportTomorrowData();
        System.exit(0);
    }

    /**
     * 
     * Set restaurant today is ready to serve.
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
     * Call the sale Record GUI initialize 
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
     * Call the staff Record GUI initialize
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
     * Call the table GUI initialize
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
     * Call the order GUI initialize
     * 
     */
    private void orderGUIEvent() {
        SalesRecord_GUI gui = new SalesRecord_GUI(restaurant, new Date(), "Orders:");
        gui.setVisible(true);
    }

    /**
     * 
     * Call the menu GUI initialize
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
     * Call the Authentication GUI initialize with user is Log out
     * 
     */
    private void logoutEvent() {
        user = null;
        General_GUI gui = new General_GUI(restaurant);
        gui.setVisible(true);
        this.dispose();
    }
    
    /**
     * 
     * Call the ingredients GUI initialize 
     * 
     */
    private void ingredientsGUIEvent() {
        if("staff".equals(user.getRole())){
            JOptionPane.showMessageDialog(this, "Your role is not chef or Manager !");
            return;
        }
        Ingredients_GUI gui = new Ingredients_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     * Create the Restaurant GUI
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
        ingredientsGUIControl.addActionListener(e -> ingredientsGUIEvent());    
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
     * @param res Restaurant
     * @param userSession Staff
     */
    public Restaurant_GUI(Restaurant res, Staff userSession){
        restaurant = res;
        user = userSession;
        this.initializeGUI();
    }

}
