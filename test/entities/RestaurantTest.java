/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entities;

import java.util.HashMap;
import java.util.List;
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
public class RestaurantTest {
    
    public RestaurantTest() {
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
     * Test of getName method, of class Restaurant.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Restaurant.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Restaurant instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Restaurant.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Restaurant.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Restaurant instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Restaurant.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Restaurant.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Restaurant instance = null;
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMenuReady method, of class Restaurant.
     */
    @Test
    public void testSetMenuReady() {
        System.out.println("setMenuReady");
        Boolean ready = null;
        Restaurant instance = null;
        instance.setMenuReady(ready);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuReady method, of class Restaurant.
     */
    @Test
    public void testGetMenuReady() {
        System.out.println("getMenuReady");
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.getMenuReady();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAllReady method, of class Restaurant.
     */
    @Test
    public void testSetAllReady() {
        System.out.println("setAllReady");
        Boolean ready = null;
        Restaurant instance = null;
        instance.setAllReady(ready);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllReady method, of class Restaurant.
     */
    @Test
    public void testGetAllReady() {
        System.out.println("getAllReady");
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.getAllReady();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderNumber method, of class Restaurant.
     */
    @Test
    public void testGetOrderNumber() {
        System.out.println("getOrderNumber");
        Restaurant instance = null;
        int expResult = 0;
        int result = instance.getOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrderNumber method, of class Restaurant.
     */
    @Test
    public void testAddOrderNumber() {
        System.out.println("addOrderNumber");
        Restaurant instance = null;
        instance.addOrderNumber();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrderNumber method, of class Restaurant.
     */
    @Test
    public void testRemoveOrderNumber() {
        System.out.println("removeOrderNumber");
        Restaurant instance = null;
        instance.removeOrderNumber();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderList method, of class Restaurant.
     */
    @Test
    public void testGetOrderList() {
        System.out.println("getOrderList");
        Restaurant instance = null;
        List<Order> expResult = null;
        List<Order> result = instance.getOrderList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrder method, of class Restaurant.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        String tableNumber = "";
        Restaurant instance = null;
        instance.addOrder(tableNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class Restaurant.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        int orderId = 0;
        Restaurant instance = null;
        instance.removeOrder(orderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodayWage method, of class Restaurant.
     */
    @Test
    public void testGetTodayWage() {
        System.out.println("getTodayWage");
        Restaurant instance = null;
        double expResult = 0.0;
        double result = instance.getTodayWage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTodayWage method, of class Restaurant.
     */
    @Test
    public void testAddTodayWage() {
        System.out.println("addTodayWage");
        double todayWage = 0.0;
        Restaurant instance = null;
        instance.addTodayWage(todayWage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minusTodayWage method, of class Restaurant.
     */
    @Test
    public void testMinusTodayWage() {
        System.out.println("minusTodayWage");
        double todayWage = 0.0;
        Restaurant instance = null;
        instance.minusTodayWage(todayWage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuItemList method, of class Restaurant.
     */
    @Test
    public void testGetMenuItemList() {
        System.out.println("getMenuItemList");
        Restaurant instance = null;
        List<MenuItem> expResult = null;
        List<MenuItem> result = instance.getMenuItemList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuItem method, of class Restaurant.
     */
    @Test
    public void testGetMenuItem() {
        System.out.println("getMenuItem");
        int number = 0;
        Restaurant instance = null;
        MenuItem expResult = null;
        MenuItem result = instance.getMenuItem(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMenuItem method, of class Restaurant.
     */
    @Test
    public void testAddMenuItem() {
        System.out.println("addMenuItem");
        MenuItem item = null;
        Restaurant instance = null;
        instance.addMenuItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMenuItem method, of class Restaurant.
     */
    @Test
    public void testRemoveMenuItem() {
        System.out.println("removeMenuItem");
        String name = "";
        Restaurant instance = null;
        instance.removeMenuItem(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventory method, of class Restaurant.
     */
    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        Restaurant instance = null;
        Inventory expResult = null;
        Inventory result = instance.getInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventoryByIngredients method, of class Restaurant.
     */
    @Test
    public void testGetInventoryByIngredients() {
        System.out.println("getInventoryByIngredients");
        Restaurant instance = null;
        List<Food> expResult = null;
        List<Food> result = instance.getInventoryByIngredients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInventoryByIngredients method, of class Restaurant.
     */
    @Test
    public void testAddInventoryByIngredients() {
        System.out.println("addInventoryByIngredients");
        Food foodItem = null;
        Restaurant instance = null;
        instance.addInventoryByIngredients(foodItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteInventoryByIngredients method, of class Restaurant.
     */
    @Test
    public void testDeleteInventoryByIngredients() {
        System.out.println("deleteInventoryByIngredients");
        Food foodItem = null;
        Restaurant instance = null;
        instance.deleteInventoryByIngredients(foodItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffList method, of class Restaurant.
     */
    @Test
    public void testGetStaffList() {
        System.out.println("getStaffList");
        Restaurant instance = null;
        List<Staff> expResult = null;
        List<Staff> result = instance.getStaffList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStaff method, of class Restaurant.
     */
    @Test
    public void testAddStaff() {
        System.out.println("addStaff");
        Staff staff = null;
        Restaurant instance = null;
        instance.addStaff(staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStaff method, of class Restaurant.
     */
    @Test
    public void testDeleteStaff() {
        System.out.println("deleteStaff");
        String name = "";
        Restaurant instance = null;
        instance.deleteStaff(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaff method, of class Restaurant.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        String name = "";
        Restaurant instance = null;
        Staff expResult = null;
        Staff result = instance.getStaff(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffWorkScheduled method, of class Restaurant.
     */
    @Test
    public void testGetStaffWorkScheduled() {
        System.out.println("getStaffWorkScheduled");
        String name = "";
        Restaurant instance = null;
        HashMap<String, Boolean> expResult = null;
        HashMap<String, Boolean> result = instance.getStaffWorkScheduled(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStaffWorkScheduled method, of class Restaurant.
     */
    @Test
    public void testAddStaffWorkScheduled() {
        System.out.println("addStaffWorkScheduled");
        String name = "";
        String date = "";
        boolean b = false;
        Restaurant instance = null;
        instance.addStaffWorkScheduled(name, date, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStaffWorkScheduled method, of class Restaurant.
     */
    @Test
    public void testDeleteStaffWorkScheduled() {
        System.out.println("deleteStaffWorkScheduled");
        String name = "";
        String date = "";
        Restaurant instance = null;
        instance.deleteStaffWorkScheduled(name, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTodayFirstTimeLoginForAllStaff method, of class Restaurant.
     */
    @Test
    public void testSetTodayFirstTimeLoginForAllStaff() {
        System.out.println("setTodayFirstTimeLoginForAllStaff");
        boolean b = false;
        Restaurant instance = null;
        instance.setTodayFirstTimeLoginForAllStaff(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExportPath method, of class Restaurant.
     */
    @Test
    public void testGetExportPath() {
        System.out.println("getExportPath");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getExportPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
