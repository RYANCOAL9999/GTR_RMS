/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gtr_rms;

import java.awt.event.ActionEvent;
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
public class Table_GUITest {
    
    public Table_GUITest() {
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
     * Test of placeTable method, of class Table_GUI.
     */
    @Test
    public void testPlaceTable() {
        System.out.println("placeTable");
        ActionEvent event = null;
        Table_GUI instance = null;
        instance.placeTable(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showOrderGUIWithSingleTable method, of class Table_GUI.
     */
    @Test
    public void testShowOrderGUIWithSingleTable() {
        System.out.println("showOrderGUIWithSingleTable");
        String tableSeat = "";
        Table_GUI instance = null;
        instance.showOrderGUIWithSingleTable(tableSeat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
