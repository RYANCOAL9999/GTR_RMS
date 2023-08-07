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
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * 
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * 
     * @param submitted
     */
    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }

    /**
     * 
     * @return
     */
    public Boolean getSubmitted() {
        return this.submitted;
    }

    /**
     * 
     * @return
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 
     * @return
     */
    public Long getOrderTime() {
        return this.orderTime;
    }

    public Long getOrderFinishedTime(){
        return this.orderFinishedTime;
    }

    public void setOrderFinishedTime() {
        this.orderFinishedTime = new Date().getTime();
    }

    /**
     * 
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
