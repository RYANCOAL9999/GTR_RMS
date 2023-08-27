/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.List;

/**
 * Order class
 * @author W22079254
 */
public class Order {
    
    private int orderId;
    
    private String tableNumber;
    
    private List<Menu> menus;
    
    private double total;
    
    private Boolean submitted;
    
    private Date orderDate;
    
    private Long orderTime;
    
    private Long orderFinishedTime;
    
    /**
     * Add menu
     * @param item Menu
     */
    public void addItem(Menu item) {
        menus.add(item);
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
     * Get menu
     * @return Menu with List
     */
    public List<Menu> getMenus() {
        return menus;
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
        this.menus = new java.util.ArrayList<>();
        this.total = 0;
        this.orderDate = new Date();
        this.orderTime = this.orderDate.getTime();
        this.orderFinishedTime = 0L;
    }
    
}
