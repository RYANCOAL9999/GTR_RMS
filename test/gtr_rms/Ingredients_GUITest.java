/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gtr_rms;

import javax.swing.DefaultListModel;
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
public class Ingredients_GUITest {
    
    public Ingredients_GUITest() {
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
     * Test of finishEvent method, of class Ingredients_GUI.
     */
    @Test
    public void testFinishEvent() {
        System.out.println("finishEvent");
        Ingredients_GUI instance = null;
        instance.finishEvent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFoodEvent method, of class Ingredients_GUI.
     */
    @Test
    public void testAddFoodEvent() {
        System.out.println("addFoodEvent");
        DefaultListModel<String> inventoryItems = null;
        Ingredients_GUI instance = null;
        instance.addFoodEvent(inventoryItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
