/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;

/**
 *
 * @author W22079254
 */
public class Kitchen {
    
    private int kitchenSupplies;
    
    private List<Food> ingredients;
    
    private Boolean ingredientsReady;
    
    private List<MenuItem> menuItemList;
    
    
    /**
     * Get kitchenSupplies
     * @return
     */
    public int getKitchenSupplies() {
        return kitchenSupplies;
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
        this.kitchenSupplies = kitchenSupplies;
        this.ingredients = ingredients;
        this.menuItemList = menuItemList;
        this.ingredientsReady = false;
    }
   
}
