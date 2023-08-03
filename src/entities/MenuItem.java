/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.HashMap;

/**
 *
 * @author W22079254
 */
public class MenuItem {
    
    private String name;
    private String description;
    private double price; 
    private HashMap<String, Boolean> usedIngredients;

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 
     * @return
     */
    public HashMap<String, Boolean> getUsedIngredients() {
        return this.usedIngredients;
    }

    /**
     * 
     * @param key
     * @param value
     */
    public void addIngredients(String key, Boolean value) {
        this.usedIngredients.put(key, value);
    }
    
    /**
     * 
     * @param key
     */
    public void removeIngredients(String key) {
        this.usedIngredients.remove(key);
    }

    /**
     * 
     * @param name
     * @param description
     * @param price
     */
    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.usedIngredients = new HashMap<>();
    }
    
}
