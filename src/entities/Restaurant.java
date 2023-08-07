/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author W22079254
 */
public class Restaurant {

    private String name;
    private String address;
    private String phone;
    
    private int OrderNumber;

    private Inventory inventory;

    private double todayWage;

    private boolean menuReady;

    private boolean allReady;

    private List<Order> orderList;
    
    private List<MenuItem> menuItemList;

    private List<Staff> staffList;
    
    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @param ready
     */
    public void setMenuReady(Boolean ready) {
        this.menuReady = ready;
    }

    /**
     * 
     * @return
     */
    public boolean getMenuReady(){
        return this.menuReady;
    }

    /**
     * 
     * @param ready
     */
    public void setAllReady(Boolean ready) {
        this.allReady = ready;
    }

    /**
     * 
     * @return
     */
    public boolean getAllReady(){
        return this.allReady;
    }
    
    /**
     * 
     * @return
     */
    public int getOrderNumber() {
        return OrderNumber;
    }

    /**
     * 
     */
    public void addOrderNumber() {
        this.OrderNumber += 1;
    }
    
    /**
     * 
     */
    public void removeOrderNumber() {
        this.OrderNumber -= 1;
    }
    
    /**
     * 
     * @return
     */
    public List<Order> getOrderList() {
        return orderList;
    }
    
    /**
     * 
     * @param tableNumber
     */
    public void addOrder(String tableNumber){
        this.orderList.add(new Order(this.OrderNumber, tableNumber));
    }

    /**
     * 
     * @param orderId
     */
    public void removeOrder(int orderId) {
        for(Order orderItem : this.orderList){
            if(orderItem.getOrderId() == orderId){
                this.orderList.remove(orderItem);
            }
        }
    }

    /**
     * 
     * @return
     */
    public double getTodayWage() {
        return todayWage;
    }
    
    /**
     * 
     * @param todayWage
     */
    public void addTodayWage(double todayWage){
        this.todayWage += todayWage;
    }

    /**
     * 
     * @param todayWage
     */
    public void minusTodayWage(double todayWage){
        this.todayWage -= todayWage;
    }
    
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    /**
     * 
     * @param item
     */
    public void addMenuItem(MenuItem item) {
        this.menuItemList.add(item);
    }
    
    /**
     * 
     * @param name
     */
    public void removeMenuItem(String name) {
        for(MenuItem menu : this.menuItemList){
            if(menu.getName().equals(name)){
                this.menuItemList.remove(menu);
            }
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * 
     * @param foodItem
     */
    public void addInventoryByIngredients(Food foodItem){
        this.inventory.addIngredients(foodItem);
    }

    /**
     * 
     * @param foodItem
     */
    public void deleteInventoryByIngredients(Food foodItem){
        this.inventory.getIngredients().remove(foodItem);
    }

    public List<Staff> getStaffList(){
        return this.staffList;
    }

    public void addStaff(Staff staff){
        this.staffList.add(staff);
    }

    public void deleteStaff(String name){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                this.staffList.remove(staff);
            }
        }
    }

    public Staff getStaff(String name){
        Staff staff = null;
        for(Staff staffSingle : this.staffList){
            if(staffSingle.getUsername().equals(name)){
                staff = staffSingle;
            }
        }
        return staff;
    }

    public HashMap<String, Boolean> getStaffWorkScheduled(String name){
        HashMap<String, Boolean> scheduled = null;
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                scheduled = staff.getWorkSchedule();
            }
        }
        return scheduled;
    }

    public void addStaffWorkScheduled(String name, String date, boolean b){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staff.addWorkSchedule(date, b);
            }
        }
    }

    public void deleteStaffWorkScheduled(String name, String date){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staff.deleteWorkSchedule(date);
            }
        }
    }

    public void setTodayFirstTimeLoginForAllStaff(boolean b){
        for(Staff staff : this.staffList){
            staff.setTodayFirstTimeLogin(b);
        }
    }
    
    /**
     * 
     * @param name
     * @param address
     * @param phone
     * @param menuItemList
     * @param staffList
     * @param inventory
     */
    public Restaurant(
        String name, 
        String address, 
        String phone,
        ArrayList<MenuItem> menuItemList,
        ArrayList<Staff> staffList,
        Inventory inventory
    ){
        this.name = name;
        this.address = address;
        this.phone = phone;
        
        this.menuReady = false;
        this.allReady = false;
        this.OrderNumber = 0;
        this.todayWage = 0;
        this.orderList = new ArrayList<>();
        this.menuItemList = menuItemList;
        this.staffList = staffList;
        this.inventory = inventory;
    }

}
