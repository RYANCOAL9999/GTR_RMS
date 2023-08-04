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
     * @param tableNumber
     */
    public void addTodayWage(double todayWage){
        this.todayWage += todayWage;
    }

    /**
     * 
     * @param tableNumber
     */
    public void minusTodayWage(double todayWage){
        this.todayWage -= todayWage;
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
        this.inventory.addIngredients(foodItem.getName(), foodItem);
    }

    /**
     * 
     * @param key
     */
    public void deleteInventoryByIngredients(String key){
        this.inventory.getIngredients().remove(key);
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
     */
    private void addDefaultIngredients(){
        /**
         * need to using json file with import
         */
        this.addInventoryByIngredients(new Food("rice", 10, 10, true));
        this.addInventoryByIngredients(new Food("salt", 10, 10, true));
        this.addInventoryByIngredients(new Food("sugar", 10, 10, true));
        this.addInventoryByIngredients(new Food("garlic", 10, 10, true));
        this.addInventoryByIngredients(new Food("ginger", 10, 10, true));
        this.addInventoryByIngredients(new Food("mustard", 10, 10, true));
        this.addInventoryByIngredients(new Food("wasabi", 10, 10, true));
        this.addInventoryByIngredients(new Food("sesame oil", 10, 10, true));
        this.addInventoryByIngredients(new Food("ponzu sauce", 10, 10, true));
        this.addInventoryByIngredients(new Food("tabasco", 10, 10, true));
        this.addInventoryByIngredients(new Food("soy sauce", 10, 10, true));
        this.addInventoryByIngredients(new Food("worcester sauce", 10, 10, true));
        this.addInventoryByIngredients(new Food("cooking wine", 10, 10, true));
        this.addInventoryByIngredients(new Food("ketchup", 10, 10, true));
        this.addInventoryByIngredients(new Food("sweet sake", 10, 10, true));
        this.addInventoryByIngredients(new Food("vinegar", 10, 10, true));
        this.addInventoryByIngredients(new Food("mayonnaise", 10, 10, true));
        this.addInventoryByIngredients(new Food("pepper", 10, 10, true));
        this.addInventoryByIngredients(new Food("flour", 10, 10, true));
        this.addInventoryByIngredients(new Food("potato starch", 10, 10, true));
        this.addInventoryByIngredients(new Food("miso", 10, 10, true));
        this.addInventoryByIngredients(new Food("oil", 10, 10, true));
        this.addInventoryByIngredients(new Food("a Japanese soup base", 10, 10, true));
    }

    /**
     * 
     */
    private void addDefaultMenuItems(){
        this.addMenuItem(new MenuItem("rice", "white rice", 1.0));
    }

    private void addDefaultStaff(){
        /**
         * need to using json file with import
         */
        this.addStaff(
            new Staff(
                "staff123", 
                "123", 
                "staff", 
                "987654321", 
                new HashMap<String, Boolean>(){{
                    put("04/08/2023", false);
                    put("05/08/2023", false);
                    put("06/08/2023", false);
                    put("07/08/2023", false);
                    put("08/08/2023", false);
                    put("09/08/2023", false);
                    put("10/08/2023", false);
                    put("11/08/2023", false);
                    put("12/08/2023", false);
                    put("13/08/2023", false);
                    put("14/08/2023", false);
                    put("15/08/2023", false);
                    put("16/08/2023", false);
                    put("17/08/2023", false);
                    put("18/08/2023", false);
                    put("19/08/2023", false);
                    put("20/08/2023", false);
                    put("21/08/2023", false);
                    put("22/08/2023", false);
                    put("23/08/2023", false);
                    put("24/08/2023", false);
                    put("25/08/2023", false);
                    put("26/08/2023", false);
                    put("27/08/2023", false);
                    put("28/08/2023", false);
                    put("29/08/2023", false);
                    put("30/08/2023", false);
                    put("31/08/2023", false);
                }}
            )
        );
        this.addStaff(
            new Staff(
                "staff456", 
                "456", 
                "staff", 
                "987654321", 
                new HashMap<String, Boolean>(){{
                    put("04/08/2023", false);
                    put("05/08/2023", false);
                    put("06/08/2023", false);
                    put("07/08/2023", false);
                    put("08/08/2023", false);
                    put("09/08/2023", false);
                    put("10/08/2023", false);
                    put("11/08/2023", false);
                    put("12/08/2023", false);
                    put("13/08/2023", false);
                    put("14/08/2023", false);
                    put("15/08/2023", false);
                    put("16/08/2023", false);
                    put("17/08/2023", false);
                    put("18/08/2023", false);
                    put("19/08/2023", false);
                    put("20/08/2023", false);
                    put("21/08/2023", false);
                    put("22/08/2023", false);
                    put("23/08/2023", false);
                    put("24/08/2023", false);
                    put("25/08/2023", false);
                    put("26/08/2023", false);
                    put("27/08/2023", false);
                    put("28/08/2023", false);
                    put("29/08/2023", false);
                    put("30/08/2023", false);
                    put("31/08/2023", false);
                }}
            )
        );
        this.addStaff(
            new Staff(
                "chef123", 
                "123", 
                "chef", 
                "987654321", 
                new HashMap<String, Boolean>(){{
                    put("04/08/2023", false);
                    put("05/08/2023", false);
                    put("06/08/2023", false);
                    put("07/08/2023", false);
                    put("08/08/2023", false);
                    put("09/08/2023", false);
                    put("10/08/2023", false);
                    put("11/08/2023", false);
                    put("12/08/2023", false);
                    put("13/08/2023", false);
                    put("14/08/2023", false);
                    put("15/08/2023", false);
                    put("16/08/2023", false);
                    put("17/08/2023", false);
                    put("18/08/2023", false);
                    put("19/08/2023", false);
                    put("20/08/2023", false);
                    put("21/08/2023", false);
                    put("22/08/2023", false);
                    put("23/08/2023", false);
                    put("24/08/2023", false);
                    put("25/08/2023", false);
                    put("26/08/2023", false);
                    put("27/08/2023", false);
                    put("28/08/2023", false);
                    put("29/08/2023", false);
                    put("30/08/2023", false);
                    put("31/08/2023", false);
                }}
            )
        );
        this.addStaff(
            new Staff(
                "chef456", 
                "456", 
                "chef", 
                "987654321", 
                new HashMap<String, Boolean>(){{
                    put("04/08/2023", false);
                    put("05/08/2023", false);
                    put("06/08/2023", false);
                    put("07/08/2023", false);
                    put("08/08/2023", false);
                    put("09/08/2023", false);
                    put("10/08/2023", false);
                    put("11/08/2023", false);
                    put("12/08/2023", false);
                    put("13/08/2023", false);
                    put("14/08/2023", false);
                    put("15/08/2023", false);
                    put("16/08/2023", false);
                    put("17/08/2023", false);
                    put("18/08/2023", false);
                    put("19/08/2023", false);
                    put("20/08/2023", false);
                    put("21/08/2023", false);
                    put("22/08/2023", false);
                    put("23/08/2023", false);
                    put("24/08/2023", false);
                    put("25/08/2023", false);
                    put("26/08/2023", false);
                    put("27/08/2023", false);
                    put("28/08/2023", false);
                    put("29/08/2023", false);
                    put("30/08/2023", false);
                    put("31/08/2023", false);
                }}
            )
        );
        this.addStaff(
            new Staff(
                "manager123", 
                "123", 
                "manager", 
                "987654321", 
                new HashMap<String, Boolean>(){{
                    put("04/08/2023", false);
                    put("05/08/2023", false);
                    put("06/08/2023", false);
                    put("07/08/2023", false);
                    put("08/08/2023", false);
                    put("09/08/2023", false);
                    put("10/08/2023", false);
                    put("11/08/2023", false);
                    put("12/08/2023", false);
                    put("13/08/2023", false);
                    put("14/08/2023", false);
                    put("15/08/2023", false);
                    put("16/08/2023", false);
                    put("17/08/2023", false);
                    put("18/08/2023", false);
                    put("19/08/2023", false);
                    put("20/08/2023", false);
                    put("21/08/2023", false);
                    put("22/08/2023", false);
                    put("23/08/2023", false);
                    put("24/08/2023", false);
                    put("25/08/2023", false);
                    put("26/08/2023", false);
                    put("27/08/2023", false);
                    put("28/08/2023", false);
                    put("29/08/2023", false);
                    put("30/08/2023", false);
                    put("31/08/2023", false);
                }}
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
