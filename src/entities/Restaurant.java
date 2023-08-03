/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
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

    private List<Order> order;
    
    private List<MenuItem> menuItem;
    
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
    public List<Order> getOrder() {
        return order;
    }
    
    /**
     * 
     * @param tableNumber
     */
    public void addOrder(String tableNumber){
        this.order.add(new Order(this.OrderNumber, tableNumber));
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
        for(Order orderItem : this.order){
            if(orderItem.getOrderId() == orderId){
                this.order.remove(orderItem);
            }
        }
    }
    
    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    /**
     * 
     * @param name
     * @param description
     * @param price
     */
    public void addMenuItem(String name, String description, double price) {
        this.menuItem.add(new MenuItem(name, description, price));
    }
    
    /**
     * 
     * @param name
     */
    public void removeMenuItem(String name) {
        for(MenuItem menu : this.menuItem){
            if(menu.getName().equals(name)){
                this.menuItem.remove(menu);
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
     */
    private void addDefaultIngredients(){
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
        this.order = new ArrayList<Order>();
        this.menuItem = new ArrayList<MenuItem>();
        this.inventory = new Inventory();

        /**
         * add Default items with food and Menu
         */
        this.addDefaultIngredients();
        this.addDefaultMenuItems();

    }

}
