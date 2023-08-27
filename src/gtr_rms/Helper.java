package gtr_rms;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import entities.Food;
import entities.Inventory;
import entities.Menu;
import entities.Restaurant;
import entities.Staff;

/**
 * Helper class with static function
 * @author W22079254
 */
public class Helper {
    
    /**
     * 
     * default constructor with static 
     * 
     */
    public Helper(){
    }

    /**
     * Check string is number 
     * @param str String
     * @return Boolean
     */
    public static Boolean checkStringIsNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * Get box constraints is west, centre, or east.
     * @param i Integer
     * @param number Integer
     * @return String
     */
    public static String getCheckBoxConstraints(int i, int number){
        return i % number == 0 ? BorderLayout.WEST : i % number == 1 ? BorderLayout.CENTER : BorderLayout.EAST;
    }
    
    /**
     * Get restaurant data By JSON
     * @param filePath String
     * @return HashMap
     */
    public static HashMap<String, Object> getRestaurantBYJson(String filePath){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        HashMap<String, Object> map = new HashMap<>();
        
        try{
            Reader reader = new FileReader(filePath);
            map = (HashMap<String,Object>) gson.fromJson(reader, map.getClass()); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return map;
    }

    /**
     * Load RestaurantData with json file
     * @param file String
     * @return Restaurant
     */
    public static Restaurant loadRestaurantData(String file) {

        HashMap<String, Object> data = Helper.getRestaurantBYJson(file);
                
        if(data == null){
            return null;
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
        
        ArrayList<Menu> menuList = new ArrayList<>();
        
        for(LinkedTreeMap dishTreeMap :dishListArrayList){
            Menu new_Menu = new Menu(
               (String) dishTreeMap.get("name"),
               (String) dishTreeMap.get("description"),
               Double.parseDouble(dishTreeMap.get("price").toString())
            );
            menuList.add(new_Menu);
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
        
        return new Restaurant(
            (String) data.get("restaurntName"),
            (String) data.get("restaurntAddress"), 
            (String) data.get("restaurntPhone"),
            menuList,
            staffList,
            inventory,
            file
        );
    }

}
