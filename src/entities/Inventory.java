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
public class Inventory {
    
//    private int chairs;
//    private int tables;
//    private int dishes;
//    private int glasses;
    private HashMap<String, Integer> ingredients;

    public Inventory(
//            int chairs, 
//            int tables, 
//            int dishes, 
//            int glasses
    ) {
//        this.chairs = chairs;
//        this.tables = tables;
//        this.dishes = dishes;
//        this.glasses = glasses;
        this.ingredients = new HashMap<>();
    }
    
//    public int getChairs() {
//        return chairs;
//    }

//    public void setChairs(int chairs) {
//        this.chairs = chairs;
//    }

//    public int getTables() {
//        return tables;
//    }

//    public void setTables(int tables) {
//        this.tables = tables;
//    }

//    public int getDishes() {
//        return dishes;
//    }

//    public void setDishes(int dishes) {
//        this.dishes = dishes;
//    }

//    public int getGlasses() {
//        return glasses;
//    }

//    public void setGlasses(int glasses) {
//        this.glasses = glasses;
//    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public void addIngredients(String key, int number) {
        this.ingredients.put(key, number);
    }
    
    public void removeIngredients(String key) {
        this.ingredients.remove(key);
    }
    
}
