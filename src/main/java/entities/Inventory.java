/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * Inventory class
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

    /**
     * Get chairs
     * @return Integer
     */
    public int getChairs() {
        return chairs;
    }

    /**
     * Get tables
     * @return Integer
     */
    public int getTables() {
        return tables;
    }

    /**
     * Get dishes
     * @return Integer
     */
    public int getDishes() {
        return dishes;
    }

    /**
     * Get glasses
     * @return Integer
     */
    public int getGlasses() {
        return glasses;
    }

    /**
     * Get chopsticks
     * @return integer
     */
    public int getChopsticks() {
        return chopsticks;
    }

    /**
     * Set spoons
     * @return Integer
     */
    public int getSpoons() {
        return spoons;
    }

    /**
     * Get tableCloths
     * @return Integer
     */
    public int getTablecloths() {
        return tablecloths;
    }

    /**
     * Get napkins
     * @return Integer
     */
    public int getNapkins() {
        return napkins;
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
     */
    public Inventory(
           int chairs, 
           int tables, 
           int dishes, 
           int glasses,
           int chopsticks,
           int spoons,
           int tablecloths,
           int napkins
    ) {
        this.chairs = chairs;
        this.tables = tables;
        this.dishes = dishes;
        this.glasses = glasses;
        this.chopsticks = chopsticks;
        this.spoons = spoons;
        this.tablecloths = tablecloths;
        this.napkins = napkins;
    }
    
}