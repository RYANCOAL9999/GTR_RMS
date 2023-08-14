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
    
    private HashMap<String, Double> usedIngredients;
    
    private Boolean sumPlus; 

    /**
     * Get name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get price
     * @return Double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get ingredients which used
     * @return HashMap
     */
    public HashMap<String, Double> getUsedIngredients() {
        return this.usedIngredients;
    }
    
    /**
     * Get order is paid or not
     * @return Boolean
     */
    public boolean getSumPlus() {
        return sumPlus;
    }

    /**
     * MenuItem constructor
     * @param name String
     * @param description String
     * @param price Double
     */
    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.usedIngredients = new HashMap<>();
        this.sumPlus = true;
    }
    
}
