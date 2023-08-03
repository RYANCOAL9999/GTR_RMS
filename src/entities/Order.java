/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;
/**
 *
 * @author W22079254
 */
public class Order {
    
    private int orderId;
    private int tableNumber;
    private List<MenuItem> orderItems;
    
    /**
     * 
     * @param item
     */
    public void addItem(MenuItem item) {
        orderItems.add(item);
    }

    /**
     * 
     * @return
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * @return
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * 
     * @param tableNumber
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * 
     * @return
     */
    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    /**
     * 
     * @param orderId
     * @param tableNumber
     */
    public Order(int orderId, int tableNumber) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.orderItems = new java.util.ArrayList<>();
    }
    
}
