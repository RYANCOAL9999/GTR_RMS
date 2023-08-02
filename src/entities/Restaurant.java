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

    private List<Order> order;
    
    private List<MenuItem> menuItem;
    
    public Restaurant(){
    }
    
    public Restaurant(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        
        this.OrderNumber = 0;
        this.order = new ArrayList<Order>();
        
        this.menuItem = new ArrayList<MenuItem>();

        this.inventory = new Inventory();

        // this.addMenuItem();

    }
    
    // private void addMenuItem(){
    //     this.menuItem.add(new MenuItem("Pasta", "", 0));
    //     this.menuItem.add(new MenuItem("Pizza", "", 0));
    //     this.menuItem.add(new MenuItem("Salad", "", 0));
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getOrderNumber() {
        return OrderNumber;
    }

    public void addOrderNumber() {
        this.OrderNumber += 1;
    }
    
    public void removeOrderNumber() {
        this.OrderNumber -= 1;
    }
    
    public List<Order> getOrder() {
        return order;
    }
    
    public void addOrder(int tableNumber){
        this.order.add(new Order(this.OrderNumber, tableNumber));
    }
    
    public void removeOrder(int orderId) {
        for (int i = 0; i < this.order.size(); i++){
            if(this.order.get(i).getOrderId() == orderId){
                this.order.remove(i);
            }
        }
    }
    
    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void addMenuItem(String name, String description, double price) {
        this.menuItem.add(new MenuItem(name, description, price));
    }
    
    public void removeMenuItem(String name) {
        for (int i = 0; i < this.menuItem.size(); i++){
            if(this.menuItem.get(i).getName() == null ? name == null : this.menuItem.get(i).getName().equals(name)){
                this.menuItem.remove(i);
            }
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void addInventoryByIngredients(String key, int number){
        this.inventory.addIngredients(key, number);
    }

    public void deleteInventoryByIngredients(String key){
        this.inventory.getIngredients().remove(key);
    }



}
