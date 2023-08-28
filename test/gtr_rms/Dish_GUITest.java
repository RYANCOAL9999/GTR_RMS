package gtr_rms;

import static org.junit.Assert.assertEquals;

import javax.swing.DefaultListModel;

import org.junit.Test;

import entities.RestaurantTest;

public class Dish_GUITest {

    private Dish_GUI gui;

    public Dish_GUITest(){
        gui = new Dish_GUI(new RestaurantTest().getRestaurant(), new DefaultListModel<String>());
    }

    @Test
    public void testAddMenuWithReturnName() {
        String name = "pizza";
        assertEquals(gui.addMenuWithReturnName(name, "10.0", ""), name);
    }
}
