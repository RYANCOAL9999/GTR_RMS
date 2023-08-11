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
     * Get chairs
     * @return
     */
    public int getChairs() {
        return chairs;
    }

    /**
     * Set chairs with integer number
     * @param chairs
     */
    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    /**
     * Get tables
     * @return
     */
    public int getTables() {
        return tables;
    }

    /**
     * Set tables with integer number
     * @param tables
     */
    public void setTables(int tables) {
        this.tables = tables;
    }

    /**
     * Get dishes
     * @return
     */
    public int getDishes() {
        return dishes;
    }

    /**
     * Set dishes with integer number
     * @param dishes
     */
    public void setDishes(int dishes) {
        this.dishes = dishes;
    }

    /**
     * Get glasses
     * @return
     */
    public int getGlasses() {
        return glasses;
    }

    /**
     * Set glasses with integer number
     * @param glasses
     */
    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    /**
     * Get chopsticks
     * @return
     */
    public int getChopsticks() {
        return chopsticks;
    }

    /**
     * Set chopsticks with integer number
     * @param chopsticks
     */
    public void setChopsticks(int chopsticks) {
        this.chopsticks = chopsticks;
    }

    /**
     * Set spoons
     * @return
     */
    public int getSpoons() {
        return spoons;
    }

    /**
     * Set spoons with integer number
     * @param spoons
     */
    public void setSpoons(int spoons) {
        this.spoons = spoons;
    }

    /**
     * Get tableCloths
     * @return
     */
    public int getTablecloths() {
        return tablecloths;
    }

    /**
     * Set tableCloths with integer number
     * @param tablecloths
     */
    public void setTablecloths(int tablecloths) {
        this.tablecloths = tablecloths;
    }

    /**
     * Get napkins
     * @return
     */
    public int getNapkins() {
        return napkins;
    }

    /**
     * Set napkins with integer number
     * @param napkins
     */
    public void setNapkin(int napkins) {
        this.napkins = napkins;
    }

    /**
     * Get kitchenSupplies
     * @return
     */
    public int getKitchenSupplies() {
        return kitchenSupplies;
    }

    /**
     * Set kitchenSupplies with integer number
     * @param kitchenSupplies
     */
    public void setKitchenSupplies(int kitchenSupplies) {
        this.kitchenSupplies = kitchenSupplies;
    }

    /**
     * Set ingredientsReady with true or false for today is ready
     * @param ready
     */
    public void setIngredientsReady(Boolean ready) {
        this.ingredientsReady = ready;
    }

    /**
     * Get ingredientsReady
     * @return
     */
    public boolean getIngredientsReady(){
        return this.ingredientsReady;
    }

    /**
     * Get ingredients
     * @return
     */
    public List<Food> getIngredients() {
        return ingredients;
    }

    /**
     * Add ingredients with food
     * @param foodItem
     */
    public void addIngredients(Food foodItem) {
        this.ingredients.add(foodItem);
    }
    
    /**
     * Remove ingredients with food
     * @param foodItem
     */
    public void removeIngredients(Food foodItem){
        this.ingredients.remove(foodItem);
    }
    
    /**
     * Find ingredients by name
     * @param name
     * @return
     */
    public Food getIngredientsByKey(String name){
        Food food = null;
        for(Food item:this.ingredients){
            if(name.equals(item.getName())){
                food = item;
            }
        }
        return food;
    }

    /**
     * Inventory constructor
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
