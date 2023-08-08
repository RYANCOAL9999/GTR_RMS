/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testEntities;

import junit.framework.TestCase;

import entities.Food;

/**
 *
 * @author W22079254
 */
public class FoodUnitTest extends TestCase {

    /**
     *
     * @return 
     */
    public Food foodUnitTest() {
        return new Food(
            "name",
            "",
            0.0,
            10,
            10.0,
            10.0,
            true,
            "raw"
        );
    }
    
    /**
     * 
     */
    public void testEqual() {
        
    }
    
    /**
     * 
     */
    public void testEntities(){
        
    }
    
}
