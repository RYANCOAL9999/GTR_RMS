/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gtr_rms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author W22079254
 */
public class Dish_GUITest {
    
    public Dish_GUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMenuItemWithReturnName method, of class Dish_GUI.
     */
    @Test
    public void testAddMenuItemWithReturnName() {
        System.out.println("addMenuItemWithReturnName");
        String name = "";
        String price = "";
        String dishDescription = "";
        Dish_GUI instance = null;
        String expResult = "";
        String result = instance.addMenuItemWithReturnName(name, price, dishDescription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
