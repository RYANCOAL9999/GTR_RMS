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
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }

    /**
     * 
     * @return
     */
    public int getQuantity() {
       return this.quantity;
    }
    
    public void minusQuantity(int number){
        this.quantity -= number;
    }
    
    /**
     * 
     * @return
     */
    public Boolean getQuantityEqualTooZero(){
        return this.quantity == 0.0;
    }

    /**
     * 
     * @param weight
     */
    public void setWeight(double weight){
       this.weight = weight;
    }

    /**
     * 
     * @return
     */
    public double getWeight() {
       return this.weight;
    }
    
    public void minusWeight(double number){
        this.weight -= number;
    }

    /**
     * 
     * @param noEffect
     */
    public void setNoEffect(Boolean noEffect) {
        this.noEffect = noEffect;
    }

    /**
     * 
     * @return
     */
    public boolean getNoEffect() {
        return this.noEffect;
    }
    
    /**
     * 
     * @return
     */
    public Boolean getStartingWeightEqualTooZero(){
        return this.startingWeight == 0.0;
    }
    
    /**
     * 
     * @return
     */
    public double getStartingWeight() {
        return startingWeight;
    }

    /**
     * 
     * @param startingWeight
     */
    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }
    
    /**
     * 
     */
    public void resSetStartingWeight() {
        this.startingWeight = this.weight;
    }
    
    /**
     * 
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * 
     * @return 
     */
    public Boolean getTypeIsRaw(){
        return "raw".equals(this.type);
    }
    
    /**
     * 
     * @return 
     */
    public Boolean getTypeIsSashimi(){
        return "sashimi".equals(this.type);
    }
    
    /**
     * 
     * @return 
     */
    public Boolean getTypeIsVegs(){
        return "vegs".equals(this.type);
    }
    
    /**
     * have Effect with MenuItem
     * @param name
     * @param description
     * @param price
     * @param quantity
     * @param weight
     * @param startingWeight
     * @param noEffect
     * @param type
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
