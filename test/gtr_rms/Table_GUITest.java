package gtr_rms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entities.Order;
import entities.RestaurantTest;

public class Table_GUITest {

    private Table_GUI gui;

    public Table_GUITest() {
        gui = new Table_GUI(new RestaurantTest().getRestaurant());
    }

    @Test
    public void testGenOrder() {
        String tableName = "1";
        Order order = gui.genOrder(tableName);
        assertEquals(order.getTableNumber(), tableName);
    }
}
