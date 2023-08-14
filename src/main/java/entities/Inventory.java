/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Inventory class
 * @author W22079254
 */
@Document("Inventory")
public class Inventory {
    
    @Id
    private String id;
    
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
     * @return Integer
     */
    public int getChairs() {
        return chairs;
    }

    /**
     * Set chairs with integer number
     * @param chairs Integer
     */
    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    /**
     * Get tables
     * @return Integer
     */
    public int getTables() {
        return tables;
    }

    /**
     * Set tables with integer number
     * @param tables Integer
     */
    public void setTables(int tables) {
        this.tables = tables;
    }

    /**
     * Get dishes
     * @return Integer
     */
    public int getDishes() {
        return dishes;
    }

    /**
     * Set dishes with integer number
     * @param dishes integer
     */
    public void setDishes(int dishes) {
        this.dishes = dishes;
    }

    /**
     * Get glasses
     * @return Integer
     */
    public int getGlasses() {
        return glasses;
    }

    /**
     * Set glasses with integer number
     * @param glasses Integer
     */
    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    /**
     * Get chopsticks
     * @return integer
     */
    public int getChopsticks() {
        return chopsticks;
    }

    /**
     * Set chopsticks with integer number
     * @param chopsticks Integer
     */
    public void setChopsticks(int chopsticks) {
        this.chopsticks = chopsticks;
    }

    /**
     * Set spoons
     * @return Integer
     */
    public int getSpoons() {
        return spoons;
    }

    /**
     * Set spoons with integer number
     * @param spoons Integer
     */
    public void setSpoons(int spoons) {
        this.spoons = spoons;
    }

    /**
     * Get tableCloths
     * @return Integer
     */
    public int getTablecloths() {
        return tablecloths;
    }

    /**
     * Set tableCloths with integer number
     * @param tablecloths Integer
     */
    public void setTablecloths(int tablecloths) {
        this.tablecloths = tablecloths;
    }

    /**
     * Get napkins
     * @return Integer
     */
    public int getNapkins() {
        return napkins;
    }

    /**
     * Set napkins with integer number
     * @param napkins Integer
     */
    public void setNapkin(int napkins) {
        this.napkins = napkins;
    }

    /**
     * Get kitchenSupplies
     * @return Integer
     */
    public int getKitchenSupplies() {
        return kitchenSupplies;
    }

    /**
     * Set kitchenSupplies with integer number
     * @param kitchenSupplies Integer
     */
    public void setKitchenSupplies(int kitchenSupplies) {
        this.kitchenSupplies = kitchenSupplies;
    }

    /**
     * Set ingredientsReady with true or false for today is ready
     * @param ready Boolean
     */
    public void setIngredientsReady(Boolean ready) {
        this.ingredientsReady = ready;
    }

    /**
     * Get ingredientsReady
     * @return Boolean
     */
    public boolean getIngredientsReady(){
        return this.ingredientsReady;
    }

    /**
     * Get ingredients
     * @return food with List
     */
    public List<Food> getIngredients() {
        return ingredients;
    }

    /**
     * Add ingredients with food
     * @param foodItem Food
     */
    public void addIngredients(Food foodItem) {
        this.ingredients.add(foodItem);
    }
    
    /**
     * Remove ingredients with food
     * @param foodItem Food
     */
    public void removeIngredients(Food foodItem){
        this.ingredients.remove(foodItem);
    }
    
    /**
     * Find ingredients by name
     * @param name String
     * @return Food
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
     * @param chairs Integer
     * @param tables Integer
     * @param dishes Integer
     * @param glasses Integer
     * @param chopsticks Integer
     * @param spoons Integer
     * @param tablecloths Integer
     * @param napkins Integer
     * @param kitchenSupplies Integer
     * @param foodList Food with List 
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