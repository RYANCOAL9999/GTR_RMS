/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Restaurant class
 * @author W22079254
 */
public class Restaurant {

    private String name;
    
    private String address;
    
    private String phone;
    
    private Inventory inventory;
    
    private List<Order> orderList;
    
    private List<MenuItem> menuItemList;

    private List<Staff> staffList;
    
    private String exportPath;
    
    private int OrderNumber;

    private double todayWage;

    private boolean menuReady;

    private boolean allReady;
    
    /**
     * Get name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name with string
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address with string
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get phone 
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone with string
     * @param phone String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set menuItem is ready or not
     * @param ready Boolean
     */
    public void setMenuReady(Boolean ready) {
        this.menuReady = ready;
    }

    /**
     * Get menuItem is ready
     * @return Boolean
     */
    public boolean getMenuReady(){
        return this.menuReady;
    }

    /**
     * Set restaurant is ready for today
     * @param ready Boolean
     */
    public void setAllReady(Boolean ready) {
        this.allReady = ready;
    }

    /**
     * Get restaurant is ready or not
     * @return Boolean
     */
    public boolean getAllReady(){
        return this.allReady;
    }
    
    /**
     * Get order number
     * @return Integer
     */
    public int getOrderNumber() {
        return OrderNumber;
    }

    /**
     * 
     * Add order number
     * 
     */
    public void addOrderNumber() {
        this.OrderNumber += 1;
    }
    
    /**
     * 
     * Minus order number
     * 
     */
    public void removeOrderNumber() {
        this.OrderNumber -= 1;
    }
    
    /**
     * Get order list
     * @return Order with List
     */
    public List<Order> getOrderList() {
        return orderList;
    }
    
    /**
     * Add order
     * @param tableNumber String
     */
    public void addOrder(String tableNumber){
        this.orderList.add(new Order(this.OrderNumber, tableNumber));
    }

    /**
     * Remove order with order number
     * @param orderId Integer
     */
    public void removeOrder(int orderId) {
        for(Order orderItem : this.orderList){
            if(orderItem.getOrderId() == orderId){
                this.orderList.remove(orderItem);
            }
        }
    }

    /**
     * Get today Wage
     * @return Double
     */
    public double getTodayWage() {
        return todayWage;
    }
    
    /**
     * Add today Wage with double value
     * @param todayWage Double
     */
    public void addTodayWage(double todayWage){
        this.todayWage += todayWage;
    }

    /**
     * Minus today Wage with double value
     * @param todayWage Double
     */
    public void minusTodayWage(double todayWage){
        this.todayWage -= todayWage;
    }
    
    /**
     * Get menuItem List with today 
     * @return MenuItem with List 
     */
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    /**
     * Get menuItem with integer number ID
     * @param number Integer
     * @return MenuItem
     */
    public MenuItem getMenuItem(int number) {
        return this.menuItemList.get(number);
    }

    /**
     * Add menuItem on menuItem list
     * @param item MenuItem
     */
    public void addMenuItem(MenuItem item) {
        this.menuItemList.add(item);
    }
    
    /**
     * Remove menuItem on menuItem list
     * @param name String
     */
    public void removeMenuItem(String name) {
        for(MenuItem menu : this.menuItemList){
            if(menu.getName().equals(name)){
                this.menuItemList.remove(menu);
            }
        }
    }
    
    /**
     * Get inventory
     * @return Inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }
    
    /**
     * Get ingredient list
     * @return Food with List
     */
    public List<Food> getInventoryByIngredients(){
        return this.inventory.getIngredients();
    }

    /**
     * Add food to ingredient list
     * @param foodItem Food
     */
    public void addInventoryByIngredients(Food foodItem){
        this.inventory.addIngredients(foodItem);
    }
    
    /**
     * Delete food on ingredient list
     * @param foodItem Food
     */
    public void deleteInventoryByIngredients(Food foodItem){
        this.inventory.getIngredients().remove(foodItem);
    }

    /**
     * Get staff list
     * @return Staff with List
     */
    public List<Staff> getStaffList(){
        return this.staffList;
    }

    /**
     * Add staff to staff list
     * @param staff Staff
     */
    public void addStaff(Staff staff){
        this.staffList.add(staff);
    }

    /**
     * Remove staff on staff list
     * @param name String
     */
    public void deleteStaff(String name){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                this.staffList.remove(staff);
            }
        }
    }

    /**
     * Get staff on staff list by the string
     * @param name String
     * @return Staff
     */
    public Staff getStaff(String name){
        Staff staff = null;
        for(Staff staffSingle : this.staffList){
            if(staffSingle.getUsername().equals(name)){
                staff = staffSingle;
            }
        }
        return staff;
    }

    /**
     * Get staff work scheduled by String
     * @param name String
     * @return HashMap
     */
    public HashMap<String, Boolean> getStaffWorkScheduled(String name){
        HashMap<String, Boolean> scheduled = null;
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                scheduled = staff.getWorkSchedule();
            }
        }
        return scheduled;
    }

    /**
     * Add staff work scheduled by name, date, and true or false
     * @param name String
     * @param date String
     * @param b Boolean
     */
    public void addStaffWorkScheduled(String name, String date, boolean b){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staff.addWorkSchedule(date, b);
            }
        }
    }

    /**
     * Delete staff work scheduled by name and date
     * @param name String
     * @param date String
     */
    public void deleteStaffWorkScheduled(String name, String date){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staff.deleteWorkSchedule(date);
            }
        }
    }

    /**
     * Set TodayFirstTimeLoginForAllStaff with true or false
     * @param b Boolean
     */
    public void setTodayFirstTimeLoginForAllStaff(boolean b){
        for(Staff staff : this.staffList){
            staff.setTodayFirstTimeLogin(b);
        }
    }
    
    /**
     * Get export path for export file
     * @return String
     */
    public String getExportPath() {
        return exportPath;
    }
    
    /**
     * Restaurant constructor
     * @param name String
     * @param address String
     * @param phone String
     * @param menuItemList MenuItem with ArrayList
     * @param staffList  Staff with ArrayList
     * @param inventory Inventory
     * @param exportPath String
     */
    public Restaurant(
        String name, 
        String address, 
        String phone,
        ArrayList<MenuItem> menuItemList,
        ArrayList<Staff> staffList,
        Inventory inventory,
        String exportPath
    ){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.menuItemList = menuItemList;
        this.staffList = staffList;
        this.inventory = inventory;
        this.exportPath = exportPath;
        
        this.menuReady = false;
        this.allReady = false;
        this.OrderNumber = 0;
        this.todayWage = 0;
        this.orderList = new ArrayList<>();
    }

}
