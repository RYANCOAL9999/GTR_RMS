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
     * Add menuItem
     * @param item
     */
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    /**
     * Get order number
     * @return
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set order number with integer number 
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get table number
     * @return
     */
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * Set table number with integer number
     * @param tableNumber
     */
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Get menuItem
     * @return
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Set total with double number
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get total
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * Set the true or false to know this order has placed to the kitchen
     * @param submitted
     */
    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }

    /**
     * Get submitted to know this order is placed to the kitchen
     * @return
     */
    public Boolean getSubmitted() {
        return this.submitted;
    }

    /**
     * Get order date
     * @return
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Get order time
     * @return
     */
    public Long getOrderTime() {
        return this.orderTime;
    }

    /**
     * Get order finished time
     * @return
     */
    public Long getOrderFinishedTime(){
        return this.orderFinishedTime;
    }

    /**
     * Set order finished time with new Date get time
     * @void
     */
    public void setOrderFinishedTime() {
        this.orderFinishedTime = new Date().getTime();
    }

    /**
     * Order constructor
     * @param orderId
     * @param tableNumber
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
