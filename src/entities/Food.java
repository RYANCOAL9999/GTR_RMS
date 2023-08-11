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
     * Set quantity with integer number
     * @param quantity
     */
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }

    /**
     * Get quantity
     * @return
     */
    public int getQuantity() {
       return this.quantity;
    }
    
    /**
     * minus quantity with integer number
     * @param number 
     */
    public void minusQuantity(int number){
        this.quantity -= number;
    }
    
    /**
     * check quantity is equal to 0
     * @return
     */
    public Boolean getQuantityEqualToZero(){
        return this.quantity == 0.0;
    }

    /**
     * Set weight with double number
     * @param weight
     */
    public void setWeight(double weight){
       this.weight = weight;
    }

    /**
     * Get weight
     * @return
     */
    public double getWeight() {
       return this.weight;
    }
    
    /**
     * minus weight with double number
     * @param number
     */
    public void minusWeight(double number){
        this.weight -= number;
    }

    /**
     * Set noEffect with true or false
     * @param noEffect
     */
    public void setNoEffect(Boolean noEffect) {
        this.noEffect = noEffect;
    }

    /**
     * Get noEffect
     * @return
     */
    public boolean getNoEffect() {
        return this.noEffect;
    }
    
    /**
     * check startingWeight is Equal to 0
     * @return
     */
    public Boolean getStartingWeightEqualToZero(){
        return this.startingWeight == 0.0;
    }
    
    /**
     * Get startingWeight
     * @return
     */
    public double getStartingWeight() {
        return startingWeight;
    }

    /**
     * Set startingWeight with double number
     * @param startingWeight
     */
    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }
    
    /**
     * Reset startingWeight equal to Weight
     * @void
     */
    public void resSetStartingWeight() {
        this.startingWeight = this.weight;
    }
    
    /**
     * Get type
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     * Set type with string
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * check the type is equal to str
     * @param str
     * @return
     */
    public Boolean getTypeWithStr(String str){
        return str.equals(this.type);
    }
    
    /**
     * Food constructor, it is inheritance with menuItem.
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
