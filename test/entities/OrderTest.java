package entities;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class OrderTest {

    private Order order;

    /**
     * 
     * OrderTest constructor
     * 
     */
    public OrderTest() {
        order = new Order(1, "10");
    }

    /**
     * 
     * @return Order
     * 
     */
    public Order getOrder() {
        return this.order;
    }

    @Test
    public void testAddItem() {
        String name = "pizza";
        Menu orderMenu = new Menu(name, "italy", 10.0);
        order.addItem(orderMenu);
        assertEquals(order.getMenusByName(name), orderMenu);
    }

    @Test
    public void testGetMenus() {
        assertEquals(order.getMenus(), null);
    }

    @Test
    public void testGetOrderDate() {
        assertEquals(order.getOrderDate(), new Date());
    }

    @Test
    public void testGetOrderFinishedTime() {
        assertEquals(order.getOrderFinishedTime(), new Date().getTime(), 1L);
    }

    @Test
    public void testGetOrderId() {
        assertEquals(order.getOrderId(), 1);
    }

    @Test
    public void testGetOrderTime() {
        assertEquals(order.getOrderTime(), new Date().getTime(), 1L);
    }

    @Test
    public void testGetSubmitted() {
        assertEquals(order.getSubmitted(), false);
    }

    @Test
    public void testGetTableNumber() {
        assertEquals(order.getTableNumber(), 1);
    }

    @Test
    public void testGetTotal() {
        assertEquals(order.getTotal(), 0, 0.01);
    }

    @Test
    public void testSetOrderFinishedTime() {
        order.setOrderFinishedTime();
        assertEquals(order.getOrderFinishedTime(), 0, 0.01);
    }

    @Test
    public void testSetOrderId() {
        int number = 1;
        order.setOrderId(number);
        assertEquals(order.getOrderId(), number);
    }

    @Test
    public void testSetSubmitted() {
        boolean b = true;
        order.setSubmitted(b);
        assertEquals(order.getSubmitted(), b);
    }

    @Test
    public void testSetTableNumber() {
        String tableName = "10";
        order.setTableNumber(tableName);
        assertEquals(order.getTableNumber(), tableName);
    }

    @Test
    public void testSetTotal() {
        double number = 0;
        order.setTotal(number);
        assertEquals(order.getTotal(), 0, 0.01);
    }
}
