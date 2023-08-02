/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author W22079254
 */
public class MenuItem {
    
    private String name;
    private String description;
    private double price; 
    private HashMap<String, Boolean> usedIngredients;
    
    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.usedIngredients = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HashMap<String, Boolean> getUsedIngredients() {
        return this.usedIngredients;
    }

    public void addIngredients(String key, Boolean value) {
        this.usedIngredients.put(key, value);
    }
    
    public void removeIngredients(String key) {
        this.usedIngredients.remove(key);
    }
}
