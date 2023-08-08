/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
public class StaffTest {
    
    public StaffTest() {
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
     * Test of getUsername method, of class Staff.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Staff instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Staff.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String name = "";
        Staff instance = null;
        instance.setUserName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Staff.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Staff instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Staff.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Staff instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Staff.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Staff instance = null;
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Staff.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        Staff instance = null;
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class Staff.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        Staff instance = null;
        String expResult = "";
        String result = instance.getContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContact method, of class Staff.
     */
    @Test
    public void testSetContact() {
        System.out.println("setContact");
        String contact = "";
        Staff instance = null;
        instance.setContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorkSchedule method, of class Staff.
     */
    @Test
    public void testGetWorkSchedule() {
        System.out.println("getWorkSchedule");
        Staff instance = null;
        HashMap<String, Boolean> expResult = null;
        HashMap<String, Boolean> result = instance.getWorkSchedule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWorkSchedule method, of class Staff.
     */
    @Test
    public void testAddWorkSchedule() {
        System.out.println("addWorkSchedule");
        String date = "";
        Boolean b = null;
        Staff instance = null;
        instance.addWorkSchedule(date, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteWorkSchedule method, of class Staff.
     */
    @Test
    public void testDeleteWorkSchedule() {
        System.out.println("deleteWorkSchedule");
        String date = "";
        Staff instance = null;
        instance.deleteWorkSchedule(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodayFirstTimeLogin method, of class Staff.
     */
    @Test
    public void testGetTodayFirstTimeLogin() {
        System.out.println("getTodayFirstTimeLogin");
        Staff instance = null;
        boolean expResult = false;
        boolean result = instance.getTodayFirstTimeLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTodayFirstTimeLogin method, of class Staff.
     */
    @Test
    public void testSetTodayFirstTimeLogin() {
        System.out.println("setTodayFirstTimeLogin");
        boolean b = false;
        Staff instance = null;
        instance.setTodayFirstTimeLogin(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBackTowork method, of class Staff.
     */
    @Test
    public void testAddBackTowork() {
        System.out.println("addBackTowork");
        Staff instance = null;
        instance.addBackTowork();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBackTowork method, of class Staff.
     */
    @Test
    public void testGetBackTowork() {
        System.out.println("getBackTowork");
        Staff instance = null;
        List<Date> expResult = null;
        List<Date> result = instance.getBackTowork();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBackTowork method, of class Staff.
     */
    @Test
    public void testDeleteBackTowork() {
        System.out.println("deleteBackTowork");
        Date date = null;
        Staff instance = null;
        instance.deleteBackTowork(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
