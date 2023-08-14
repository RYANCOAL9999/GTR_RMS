/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author W22079254
 */
@Document("Kitchen")
public class Kitchen {
    
    @Id
    private String id;
    
    private int kitchenSupplies;

    
    private List<Food> ingredients;
    
    private Boolean ingredientsReady;
    
    private List<MenuItem> menuItemList;
    
    /**
     * Set kitchenSupplies with integer number
     * @param kitchenSupplies integer
     */
    public void setKitchenSupplies(int kitchenSupplies) {
        this.kitchenSupplies = kitchenSupplies;
    }
    
    /**
     * Get kitchenSupplies
     * @return integer
     */
    public int getKitchenSupplies() {
        return kitchenSupplies;
    }
    
    /**
     * Get menuItem List with today 
     * @param ingredients Food
     */
    public void setIngredients(List<Food> ingredients) {
        this.ingredients = ingredients;
    }
    
    /**
     * Get ingredientsReady
     * @return Boolean
     */
    public boolean getIngredientsReady(){
        return this.ingredientsReady;
    }
    
    /**
     * Get menuItem List with today 
     * @param ingredientsReady Boolean
     */
    public void setIngredientsReady(Boolean ingredientsReady) {
        this.ingredientsReady = ingredientsReady;
    }
    
    /**
     * Get ingredients 
     * @return Food
     */
    public List<Food> getIngredients() {
        return ingredients;
    }
    
    /**
     * Set menuItemList with list object  
     * @param menuItemList MenuItem with List
     */
    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
    
    /**
     * Get menuItem List with today 
     * @return MenuItem with List 
     */
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
    
    /**
     * Get menuItem List with today 
     * @param kitchenSupplies Integer
     * @param ingredients Food with List
     * @param menuItemList MenuItem with List 
     */
    public Kitchen(
        int kitchenSupplies,
        List<Food> ingredients,
        List<MenuItem> menuItemList
    ){
        super();
        this.kitchenSupplies = kitchenSupplies;
        this.ingredients = ingredients;
        this.menuItemList = menuItemList;
        this.ingredientsReady = false;
    }
   
}
