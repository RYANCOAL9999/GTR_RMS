/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Order class
 * @author W22079254
 */
@Document("Order")
public class Order {
    
    @Id
    private String id;
    
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
     * @param item MenuItem
     */
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    /**
     * Get order number
     * @return Integer
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set order number with integer number 
     * @param orderId Integer
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get table number
     * @return String
     */
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * Set table number with integer number
     * @param tableNumber String
     */
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Get menuItem
     * @return MenuItem with List
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Set total with double number
     * @param total Double
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get total
     * @return Double
     */
    public double getTotal() {
        return total;
    }

    /**
     * Set the true or false to know this order has placed to the kitchen
     * @param submitted Boolean
     */
    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
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
     * 
     * Set order finished time with new Date get time
     * 
     */
    public void setOrderFinishedTime() {
        this.orderFinishedTime = new Date().getTime();
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