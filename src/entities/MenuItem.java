/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.HashMap;

/**
 * MenuItem class
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
     * Set name with string
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description with string
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get price
     * @return Double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price with double number
     * @param price Double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get ingredients which used
     * @return HashMap
     */
    public HashMap<String, Double> getUsedIngredients() {
        return this.usedIngredients;
    }

    /**
     * Add ingredients
     * @param key String
     * @param value Double
     */
    public void addIngredients(String key, Double value) {
        this.usedIngredients.put(key, value);
    }
    
    /**
     * Remove ingredients
     * @param key String
     */
    public void removeIngredients(String key) {
        this.usedIngredients.remove(key);
    }
    
    /**
     * Get order is paid or not
     * @return Boolean
     */
    public boolean getSumPlus() {
        return sumPlus;
    }

    /**
     * Set order paid is true or false
     * @param sumPlus Boolean
     */
    public void setSumPlus(Boolean sumPlus) {
        this.sumPlus = sumPlus;
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
