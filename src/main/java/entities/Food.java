/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Food Class
 * @author W22079254
 */
@Document("Food")
public class Food extends MenuItem {
    
    @Id
    private String id;

    private int quantity;
    
    private double weight;
    
    private double startingWeight;
    
    private Boolean noEffect;
    
    private String type;

    /**
     * Set quantity with integer number
     * @param quantity Integer
     */
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }

    /**
     * Get quantity
     * @return Integer
     */
    public int getQuantity() {
       return this.quantity;
    }
    
    /**
     * minus quantity with integer number
     * @param number Integer
     */
    public void minusQuantity(int number){
        this.quantity -= number;
    }
    
    /**
     * check quantity is equal to 0
     * @return Double
     */
    public Boolean getQuantityEqualToZero(){
        return this.quantity == 0.0;
    }

    /**
     * Set weight with double number
     * @param weight Double
     */
    public void setWeight(double weight){
       this.weight = weight;
    }

    /**
     * Get weight
     * @return Double
     */
    public double getWeight() {
       return this.weight;
    }
    
    /**
     * minus weight with double number
     * @param number Double
     */
    public void minusWeight(double number){
        this.weight -= number;
    }

    /**
     * Set noEffect with true or false
     * @param noEffect Boolean
     */
    public void setNoEffect(Boolean noEffect) {
        this.noEffect = noEffect;
    }

    /**
     * Get noEffect
     * @return Boolean
     */
    public boolean getNoEffect() {
        return this.noEffect;
    }
    
    /**
     * check startingWeight is Equal to 0
     * @return Boolean
     */
    public Boolean getStartingWeightEqualToZero(){
        return this.startingWeight == 0.0;
    }
    
    /**
     * Get startingWeight
     * @return Double
     */
    public double getStartingWeight() {
        return startingWeight;
    }

    /**
     * Set startingWeight with double number
     * @param startingWeight Double
     */
    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }
    
    /**
     * 
     * Reset startingWeight equal to Weight
     * 
     */
    public void resSetStartingWeight() {
        this.startingWeight = this.weight;
    }
    
    /**
     * Get type
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Set type with string
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * check the type is equal to str
     * @param str String
     * @return Boolean
     */
    public Boolean getTypeWithStr(String str){
        return str.equals(this.type);
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