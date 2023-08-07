/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author W22079254
 */
public class Inventory {
    
    private int chairs;
    
    private int tables;
    
    private int dishes;
    
    private int glasses;
    
    private int chopsticks;
    
    private int spoons;
    
    private int tablecloths;
    
    private int napkins;
    
    private int kitchenSupplies;
    
    private List<Food> ingredients;
    
    private Boolean ingredientsReady;

    /**
     * 
     * @return
     */
    public int getChairs() {
        return chairs;
    }

    /**
     * 
     * @param chairs
     */
    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    /**
     * 
     * @return
     */
    public int getTables() {
        return tables;
    }

    /**
     * 
     * @param tables
     */
    public void setTables(int tables) {
        this.tables = tables;
    }

    /**
     * 
     * @return
     */
    public int getDishes() {
        return dishes;
    }

    /**
     * 
     * @param dishes
     */
    public void setDishes(int dishes) {
        this.dishes = dishes;
    }

    /**
     * 
     * @return
     */
    public int getGlasses() {
        return glasses;
    }

    /**
     * 
     * @param glasses
     */
    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    /**
     * 
     * @return
     */
    public int getChopsticks() {
        return chopsticks;
    }

    /**
     * 
     * @param chopsticks
     */
    public void setChopsticks(int chopsticks) {
        this.chopsticks = chopsticks;
    }

    /**
     * 
     * @return
     */
    public int getSpoons() {
        return spoons;
    }

    /**
     * 
     * @param spoons
     */
    public void setSpoons(int spoons) {
        this.spoons = spoons;
    }

    /**
     * 
     * @return
     */
    public int getTablecloths() {
        return tablecloths;
    }

    /**
     * 
     * @param tablecloths
     */
    public void setTablecloths(int tablecloths) {
        this.tablecloths = tablecloths;
    }

    /**
     * 
     * @return
     */
    public int getNapkin() {
        return napkins;
    }

    /**
     * 
     * @param napkins
     */
    public void setNapkin(int napkins) {
        this.napkins = napkins;
    }

    /**
     * 
     * @return
     */
    public int getKitchenSupplies() {
        return kitchenSupplies;
    }

    /**
     * 
     * @param kitchenSupplies
     */
    public void setKitchenSupplies(int kitchenSupplies) {
        this.kitchenSupplies = kitchenSupplies;
    }

    /**
     * 
     * @param ready
     */
    public void setIngredientsReady(Boolean ready) {
        this.ingredientsReady = ready;
    }

    /**
     * 
     * @return
     */
    public boolean getIngredientsReady(){
        return this.ingredientsReady;
    }

    /**
     * 
     * @return
     */
    public List<Food> getIngredients() {
        return ingredients;
    }

    /**
     * 
     * @param foodItem
     */
    public void addIngredients(Food foodItem) {
        this.ingredients.add(foodItem);
    }

    /*
    * 
    * @param foodItem
    */
    public void removeIngredients(Food foodItem){
        this.ingredients.remove(foodItem);
    }

    /**
     * 
     * @param chairs
     * @param tables
     * @param dishes
     * @param glasses
     * @param chopsticks
     * @param spoons
     * @param tablecloths
     * @param napkins
     * @param kitchenSupplies
     * @param foodList
     */
    public Inventory(
           int chairs, 
           int tables, 
           int dishes, 
           int glasses,
           int chopsticks,
           int spoons,
           int tablecloths,
           int napkins,
           int kitchenSupplies,
           ArrayList<Food> foodList
    ) {
        this.chairs = chairs;
        this.tables = tables;
        this.dishes = dishes;
        this.glasses = glasses;
        this.chopsticks = chopsticks;
        this.spoons = spoons;
        this.tablecloths = tablecloths;
        this.napkins = napkins;
        this.kitchenSupplies = kitchenSupplies;
        this.ingredients = foodList;
        this.ingredientsReady = false;
    }
    
}
