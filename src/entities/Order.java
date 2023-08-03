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
    private String tableNumber;
    private List<MenuItem> menuItems;
    
    /**
     * 
     * @param item
     */
    public void addItem(MenuItem item) {
        menuItems.add(item);
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
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * 
     * @param tableNumber
     */
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * 
     * @return
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * 
     * @param orderId
     * @param tableNumber
     */
    public Order(int orderId, String tableNumber) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.menuItems = new java.util.ArrayList<>();
    }
    
}
