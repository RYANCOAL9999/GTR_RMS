/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author W22079254
 */
public class FoodTest {
    
    public FoodTest() {
        
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
     * Test of setQuantity method, of class Food.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        Food instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Food.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Food instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minusQuantity method, of class Food.
     */
    @Test
    public void testMinusQuantity() {
        System.out.println("minusQuantity");
        int number = 0;
        Food instance = null;
        instance.minusQuantity(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantityEqualTooZero method, of class Food.
     */
    @Test
    public void testGetQuantityEqualTooZero() {
        System.out.println("getQuantityEqualTooZero");
        Food instance = null;
        Boolean expResult = null;
        Boolean result = instance.getQuantityEqualToZero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class Food.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        double weight = 0.0;
        Food instance = null;
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Food.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Food instance = null;
        double expResult = 0.0;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minusWeight method, of class Food.
     */
    @Test
    public void testMinusWeight() {
        System.out.println("minusWeight");
        double number = 0.0;
        Food instance = null;
        instance.minusWeight(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoEffect method, of class Food.
     */
    @Test
    public void testSetNoEffect() {
        System.out.println("setNoEffect");
        Boolean noEffect = null;
        Food instance = null;
        instance.setNoEffect(noEffect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoEffect method, of class Food.
     */
    @Test
    public void testGetNoEffect() {
        System.out.println("getNoEffect");
        Food instance = null;
        boolean expResult = false;
        boolean result = instance.getNoEffect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartingWeightEqualTooZero method, of class Food.
     */
    @Test
    public void testGetStartingWeightEqualTooZero() {
        System.out.println("getStartingWeightEqualTooZero");
        Food instance = null;
        Boolean expResult = null;
        Boolean result = instance.getStartingWeightEqualToZero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartingWeight method, of class Food.
     */
    @Test
    public void testGetStartingWeight() {
        System.out.println("getStartingWeight");
        Food instance = null;
        double expResult = 0.0;
        double result = instance.getStartingWeight();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartingWeight method, of class Food.
     */
    @Test
    public void testSetStartingWeight() {
        System.out.println("setStartingWeight");
        double startingWeight = 0.0;
        Food instance = null;
        instance.setStartingWeight(startingWeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resSetStartingWeight method, of class Food.
     */
    @Test
    public void testResSetStartingWeight() {
        System.out.println("resSetStartingWeight");
        Food instance = null;
        instance.resSetStartingWeight();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Food.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Food instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Food.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Food instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeWithStr method, of class Food.
     */
    @Test
    public void testGetTypeWithStr() {
        System.out.println("getTypeWithStr");
        Food instance = null;
        Boolean expResult = null;
        String type = "";
        Boolean result = instance.getTypeWithStr(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
