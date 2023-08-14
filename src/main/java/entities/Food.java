/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author W22079254
 */
public class Food extends MenuItem {

    private int quantity;
    
    private double weight;
    
    private double startingWeight;
    
    private Boolean noEffect;
    
    private String type;

    /**
     * Get quantity
     * @return Integer
     */
    public int getQuantity() {
       return this.quantity;
    }

    /**
     * Get weight
     * @return Double
     */
    public double getWeight() {
       return this.weight;
    }

    /**
     * Get noEffect
     * @return Boolean
     */
    public boolean getNoEffect() {
        return this.noEffect;
    }
    
    /**
     * Get startingWeight
     * @return Double
     */
    public double getStartingWeight() {
        return startingWeight;
    }
    
    /**
     * Get type
     * @return String
     */
    public String getType() {
        return type;
    }
    
    /**
     * Food constructor, it is inheritance with menuItem.
     * @param name String
     * @param description String
     * @param price Double
     * @param quantity Integer
     * @param weight Double
     * @param startingWeight Double
     * @param noEffect Boolean
     * @param type String
     */
    public Food(
        String name, 
        String description, 
        double price,
        int quantity,
        double weight,
        double startingWeight,
        Boolean noEffect,
        String type
    ) {
        super(name, description, price);
        this.quantity = quantity;
        this.weight = weight;
        this.startingWeight = startingWeight;
        this.noEffect = noEffect;
        this.type = type;
    }
    
}
