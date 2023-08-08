/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gtr_rms;

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
public class Authentication_GUITest {
    
    public Authentication_GUITest() {
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
     * Test of getRestaurantBYJson method, of class Authentication_GUI.
     */
    @Test
    public void testGetRestaurantBYJson() {
        System.out.println("getRestaurantBYJson");
        Authentication_GUI instance = new Authentication_GUI();
        HashMap<String, Object> expResult = null;
        HashMap<String, Object> result = instance.getRestaurantBYJson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoginEvent method, of class Authentication_GUI.
     */
    @Test
    public void testLoginEvent() {
        System.out.println("LoginEvent");
        Authentication_GUI instance = new Authentication_GUI();
        instance.LoginEvent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
