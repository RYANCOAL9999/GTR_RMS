package gtr_rms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

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

}
