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
public class Staff_GUITest {
    
    public Staff_GUITest() {
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
     * Test of addStaffWithText method, of class Staff_GUI.
     */
    @Test
    public void testAddStaffWithText() {
        System.out.println("addStaffWithText");
        String userNameText = "";
        String roleText = "";
        String contactText = "";
        Boolean staffIsNull = null;
        Staff_GUI instance = null;
        instance.addStaffWithText(userNameText, roleText, contactText, staffIsNull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
