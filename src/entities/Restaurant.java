/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gtr_rms.Helper;

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

    private int[] weekends;

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
     * @return
     */
    public double getTodayWage() {
        return todayWage;
    }
    
    /**
     * 
     * @param tableNumber
     */
    public void addTodayWage(double todayWage){
        this.todayWage += todayWage;
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
    
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    /**
     * 
     * @param name
     * @param description
     * @param price
     */
    public void addMenuItem(String name, String description, double price) {
        this.menuItemList.add(new MenuItem(name, description, price));
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
        this.inventory.addIngredients(foodItem.getName(), foodItem);
    }

    /**
     * 
     * @param key
     */
    public void deleteInventoryByIngredients(String key){
        this.inventory.getIngredients().remove(key);
    }

    public Staff getStaff(String name){
        Staff staffSingle = null;
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staffSingle = staff;
            }
        }
        return staffSingle;
    }

    public void addStaff(String userName, String password, String role, String contact){
        this.staffList.add(new Staff(userName, password, role, contact));
    }

    public void deleteStaff(String name){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                this.staffList.remove(staff);
            }
        }
    }

    public List<Date> getStaffWorkScheduled(String name){
        List<Date> scheduled = null;
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                scheduled = staff.getWorkSchedule();
            }
        }
        return scheduled;
    }

    public void addStaffWorkScheduled(String name, Date date){
        for(Staff staff : this.staffList){
            if(staff.getUsername().equals(name)){
                staff.addWorkSchedule(date);
            }
        }
    }

    public void deleteStaffWorkScheduled(String name, Date date){
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
     * @param quantity
     * @param weight
     * @param noEffect
     * @return
     */
    private Food createFood(String name,int quantity, double weight, Boolean noEffect){
        return new Food(name, quantity, weight, noEffect);
    }

    /**
     * 
     * @param staff
     * @param schedules
     */
    private void addDefaultStaffSchedule(Staff staff, List<Date> schedules){
        for(Date date: schedules){
            if(Helper.checkDateIsWeekDay(date, this.weekends)){
                staff.deleteWorkSchedule(date);
            }
        }
    }

    /**
     * 
     * @param schedules
     */
    private void addDefaultStaffListSchedule(List<Date> schedules){
        for(Staff staffSingle : this.staffList){
            addDefaultStaffSchedule(staffSingle, schedules);
        }
    }

    /**
     * 
     */
    private void addDefaultIngredients(){
        /**
         * need to using json file with import
         */
        this.addInventoryByIngredients(createFood("rice", 10, 10, true));
        this.addInventoryByIngredients(createFood("salt", 10, 10, true));
        this.addInventoryByIngredients(createFood("sugar", 10, 10, true));
        this.addInventoryByIngredients(createFood("garlic", 10, 10, true));
        this.addInventoryByIngredients(createFood("ginger", 10, 10, true));
        this.addInventoryByIngredients(createFood("mustard", 10, 10, true));
        this.addInventoryByIngredients(createFood("wasabi", 10, 10, true));
        this.addInventoryByIngredients(createFood("sesame oil", 10, 10, true));
        this.addInventoryByIngredients(createFood("ponzu sauce", 10, 10, true));
        this.addInventoryByIngredients(createFood("tabasco", 10, 10, true));
        this.addInventoryByIngredients(createFood("soy sauce", 10, 10, true));
        this.addInventoryByIngredients(createFood("worcester sauce", 10, 10, true));
        this.addInventoryByIngredients(createFood("cooking wine", 10, 10, true));
        this.addInventoryByIngredients(createFood("ketchup", 10, 10, true));
        this.addInventoryByIngredients(createFood("sweet sake", 10, 10, true));
        this.addInventoryByIngredients(createFood("vinegar", 10, 10, true));
        this.addInventoryByIngredients(createFood("mayonnaise", 10, 10, true));
        this.addInventoryByIngredients(createFood("pepper", 10, 10, true));
        this.addInventoryByIngredients(createFood("flour", 10, 10, true));
        this.addInventoryByIngredients(createFood("potato starch", 10, 10, true));
        this.addInventoryByIngredients(createFood("miso", 10, 10, true));
        this.addInventoryByIngredients(createFood("oil", 10, 10, true));
        this.addInventoryByIngredients(createFood("a Japanese soup base", 10, 10, true));
    }

    /**
     * 
     */
    private void addDefaultMenuItems(){

    }

    private void addDefaultStaff(){
        /**
         * need to using json file with import
         */
        this.addStaff("staff123", "123", "staff", "987654321");
        this.addStaff("staff456", "456", "staff", "987654321");
        this.addStaff("chef123", "123", "chef", "987654321");
        this.addStaff("chef456", "456", "chef", "987654321");
        this.addStaff("manager123", "123", "Manager", "987654321");

        /**
         * need to using json file with import
         * need to search the first object Date = today for the user
         */
        LocalDate currentDate = LocalDate.now();
        /**
         * need to using json file with import
         */
        this.addDefaultStaffListSchedule(
            Helper.getMonthList(
                Helper.generalDateStr(currentDate), 
                Helper.generalDateStr(
                    currentDate.plusDays(
                        currentDate.lengthOfYear() - currentDate.getDayOfYear()
                    )
                )
            )
        );
    }

    /**
     * 
     * @param name
     * @param address
     * @param phone
     */
    public Restaurant(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        
        this.weekends = new int[]{6, 7};
        this.menuReady = false;
        this.allReady = false;
        this.OrderNumber = 0;
        this.todayWage = 0;
        this.orderList = new ArrayList<Order>();
        this.menuItemList = new ArrayList<MenuItem>();
        this.staffList = new ArrayList<Staff>();
        this.inventory = new Inventory();

        /**
         * add Default items with staff, food, and Menu
         */
        this.addDefaultStaff();
        this.addDefaultIngredients();
        this.addDefaultMenuItems();

    }

}
