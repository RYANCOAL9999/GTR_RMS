/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.List;
/**
 *
 * @author W22079254
 */
public class Order {
    
    private int orderId;
    
    private String tableNumber;
    
    private List<MenuItem> menuItems;
    
    private double total;
    
    private Boolean submitted;
    
    private Date orderDate;
    
    private Long orderTime;
    
    private Long orderFinishedTime;
    

    /**
     * Get order number
     * @return Integer
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Get table number
     * @return String
     */
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * Get menuItem
     * @return MenuItem with List
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * get total
     * @return Double
     */
    public double getTotal() {
        return total;
    }

    /**
     * Get submitted to know this order is placed to the kitchen
     * @return Boolean
     */
    public boolean getSubmitted() {
        return this.submitted;
    }

    /**
     * Get order date
     * @return Date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Get order time
     * @return Long
     */
    public Long getOrderTime() {
        return this.orderTime;
    }

    /**
     * Get order finished time
     * @return Long
     */
    public Long getOrderFinishedTime(){
        return this.orderFinishedTime;
    }

    /**
     * Order constructor
     * @param orderId Integer
     * @param tableNumber String
     */
    public Order(int orderId, String tableNumber) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.submitted = false;
        this.menuItems = new java.util.ArrayList<>();
        this.total = 0;
        this.orderDate = new Date();
        this.orderTime = this.orderDate.getTime();
        this.orderFinishedTime = 0L;
    }
    
}
