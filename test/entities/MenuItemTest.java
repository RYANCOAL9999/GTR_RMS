/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entities;

import java.util.HashMap;
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
public class MenuItemTest {
    
    public MenuItemTest() {
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
     * Test of getName method, of class MenuItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class MenuItem.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        MenuItem instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class MenuItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class MenuItem.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        MenuItem instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class MenuItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        MenuItem instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class MenuItem.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        MenuItem instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsedIngredients method, of class MenuItem.
     */
    @Test
    public void testGetUsedIngredients() {
        System.out.println("getUsedIngredients");
        MenuItem instance = null;
        HashMap<String, Double> expResult = null;
        HashMap<String, Double> result = instance.getUsedIngredients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addIngredients method, of class MenuItem.
     */
    @Test
    public void testAddIngredients() {
        System.out.println("addIngredients");
        String key = "";
        Double value = null;
        MenuItem instance = null;
        instance.addIngredients(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeIngredients method, of class MenuItem.
     */
    @Test
    public void testRemoveIngredients() {
        System.out.println("removeIngredients");
        String key = "";
        MenuItem instance = null;
        instance.removeIngredients(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumPlus method, of class MenuItem.
     */
    @Test
    public void testGetSumPlus() {
        System.out.println("getSumPlus");
        MenuItem instance = null;
        Boolean expResult = null;
        Boolean result = instance.getSumPlus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSumPlus method, of class MenuItem.
     */
    @Test
    public void testSetSumPlus() {
        System.out.println("setSumPlus");
        Boolean sumPlus = null;
        MenuItem instance = null;
        instance.setSumPlus(sumPlus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
