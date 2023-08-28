package gtr_rms;

import static org.junit.Assert.assertEquals;

import javax.swing.DefaultListModel;

import org.junit.Test;

import entities.RestaurantTest;

public class Food_GUITest {

    private Food_GUI gui;

    public Food_GUITest() {
        gui = new Food_GUI(new RestaurantTest().getRestaurant(), new DefaultListModel<String>());
    }

    @Test
    public void testAddIngredientsWithReturnName() {
        String name = "pizza";
        assertEquals(gui.addIngredientsWithReturnName(name, "10.0", "", "", "", "", ""), name);
    }
}
