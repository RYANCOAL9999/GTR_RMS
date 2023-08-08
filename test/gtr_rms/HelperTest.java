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
public class HelperTest {
    
    public HelperTest() {
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
     * Test of checkStringIsNumber method, of class Helper.
     */
    @Test
    public void testCheckStringIsNumber() {
        System.out.println("checkStringIsNumber");
        String str = "";
        Boolean expResult = null;
        Boolean result = Helper.checkStringIsNumber(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckBoxConstraints method, of class Helper.
     */
    @Test
    public void testGetCheckBoxConstraints() {
        System.out.println("getCheckBoxConstraints");
        int i = 0;
        int number = 0;
        String expResult = "";
        String result = Helper.getCheckBoxConstraints(i, number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
