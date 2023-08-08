/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gtr_rms;

import entities.MenuItem;
import entities.Order;
import java.util.List;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
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
public class Order_GUITest {
    
    public Order_GUITest() {
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
     * Test of addMenuItem method, of class Order_GUI.
     */
    @Test
    public void testAddMenuItem() {
        System.out.println("addMenuItem");
        String name = "";
        Order_GUI instance = null;
        instance.addMenuItem(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareFoodOrder method, of class Order_GUI.
     */
    @Test
    public void testPrepareFoodOrder() {
        System.out.println("prepareFoodOrder");
        List<MenuItem> resMenuItem = null;
        Order_GUI instance = null;
        Order expResult = null;
        Order result = instance.prepareFoodOrder(resMenuItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeReceipt method, of class Order_GUI.
     */
    @Test
    public void testMakeReceipt() {
        System.out.println("makeReceipt");
        List<MenuItem> resMenuItem = null;
        double sum = 0.0;
        Order_GUI instance = null;
        instance.makeReceipt(resMenuItem, sum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeBill method, of class Order_GUI.
     */
    @Test
    public void testMakeBill() {
        System.out.println("makeBill");
        Order order = null;
        Order_GUI instance = null;
        instance.makeBill(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearOrder method, of class Order_GUI.
     */
    @Test
    public void testClearOrder() {
        System.out.println("clearOrder");
        Order_GUI instance = null;
        instance.clearOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeOrder method, of class Order_GUI.
     */
    @Test
    public void testPlaceOrder() {
        System.out.println("placeOrder");
        Order_GUI instance = null;
        instance.placeOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paidEvent method, of class Order_GUI.
     */
    @Test
    public void testPaidEvent() {
        System.out.println("paidEvent");
        Order_GUI instance = null;
        instance.paidEvent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuListEventList method, of class Order_GUI.
     */
    @Test
    public void testMenuListEventList() {
        System.out.println("menuListEventList");
        ListSelectionEvent e = null;
        JList<String> menuList = null;
        Order_GUI instance = null;
        instance.menuListEventList(e, menuList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMenuItemWithSaved method, of class Order_GUI.
     */
    @Test
    public void testAddMenuItemWithSaved() {
        System.out.println("addMenuItemWithSaved");
        Order_GUI instance = null;
        instance.addMenuItemWithSaved();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
