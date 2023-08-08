/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entities;

import java.util.Date;
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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of addItem method, of class Order.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        MenuItem item = null;
        Order instance = null;
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderId method, of class Order.
     */
    @Test
    public void testGetOrderId() {
        System.out.println("getOrderId");
        Order instance = null;
        int expResult = 0;
        int result = instance.getOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderId method, of class Order.
     */
    @Test
    public void testSetOrderId() {
        System.out.println("setOrderId");
        int orderId = 0;
        Order instance = null;
        instance.setOrderId(orderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableNumber method, of class Order.
     */
    @Test
    public void testGetTableNumber() {
        System.out.println("getTableNumber");
        Order instance = null;
        String expResult = "";
        String result = instance.getTableNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTableNumber method, of class Order.
     */
    @Test
    public void testSetTableNumber() {
        System.out.println("setTableNumber");
        String tableNumber = "";
        Order instance = null;
        instance.setTableNumber(tableNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuItems method, of class Order.
     */
    @Test
    public void testGetMenuItems() {
        System.out.println("getMenuItems");
        Order instance = null;
        List<MenuItem> expResult = null;
        List<MenuItem> result = instance.getMenuItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class Order.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        Order instance = null;
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Order.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Order instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubmitted method, of class Order.
     */
    @Test
    public void testSetSubmitted() {
        System.out.println("setSubmitted");
        Boolean submitted = null;
        Order instance = null;
        instance.setSubmitted(submitted);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubmitted method, of class Order.
     */
    @Test
    public void testGetSubmitted() {
        System.out.println("getSubmitted");
        Order instance = null;
        Boolean expResult = null;
        Boolean result = instance.getSubmitted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDate method, of class Order.
     */
    @Test
    public void testGetOrderDate() {
        System.out.println("getOrderDate");
        Order instance = null;
        Date expResult = null;
        Date result = instance.getOrderDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderTime method, of class Order.
     */
    @Test
    public void testGetOrderTime() {
        System.out.println("getOrderTime");
        Order instance = null;
        Long expResult = null;
        Long result = instance.getOrderTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderFinishedTime method, of class Order.
     */
    @Test
    public void testGetOrderFinishedTime() {
        System.out.println("getOrderFinishedTime");
        Order instance = null;
        Long expResult = null;
        Long result = instance.getOrderFinishedTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderFinishedTime method, of class Order.
     */
    @Test
    public void testSetOrderFinishedTime() {
        System.out.println("setOrderFinishedTime");
        Order instance = null;
        instance.setOrderFinishedTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
