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
import static org.junit.Assert.fail;

/**
 *
 * @author W22079254
 */
public class Menu_GUITest {
    
    public Menu_GUITest() {
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
     * Test of finishEvent method, of class Menu_GUI.
     */
    @Test
    public void testFinishEvent() {
        System.out.println("finishEvent");
        Menu_GUI instance = null;
        instance.finishEvent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMenu method, of class Menu_GUI.
     */
    @Test
    public void testAddMenu() {
        System.out.println("addMenu");
        DefaultListModel<String> inventoryItems = null;
        Menu_GUI instance = null;
        instance.addMenu(inventoryItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
