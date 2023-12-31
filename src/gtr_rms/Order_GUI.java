/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gtr_rms;

import java.awt.BorderLayout;

import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

import entities.Restaurant;
import entities.Order;
import entities.Menu;
import entities.Food;

/**
 * Order_GUI class
 * @author W22079254
 */
public class Order_GUI extends JFrame{
    
    private Restaurant restaurant;

    private Order order;
    
    private JList<String> orderList;
    
    private DefaultListModel<String> menus;
    
    private DefaultListModel<String> orderItems;
    
    /**
     * Add order item list with String
     * @param name String
     */
    public void addMenu(String name) {
        orderItems.addElement(name);
    }
    
    /**
     * Prepare food on menu
     * @param resMenu Menu with List
     * @return Order 
     */
    public Order prepareFoodOrder(List<Menu> resMenu) {
        Order saveOrder = restaurant.getOrderList().get(restaurant.getOrderNumber()-1);
        for(Object orderSingle: orderItems.toArray()){
            for(Menu item: resMenu){
                if(orderSingle == null ? item.getName() == null : orderSingle.equals(item.getName())){
                    saveOrder.addItem(item);
                }
            }
        }
        return saveOrder;
    }
    
    /**
     * Create receipt by the current menu and sum
     * @param resMenu Menu with list
     * @param sum Double
     */
    public void makeReceipt(List<Menu> resMenu, double sum){
        this.order.setTotal(sum);
        this.order.setSubmitted(true);
        System.out.println(restaurant.getName());
        System.out.println(restaurant.getAddress());
        System.out.println(restaurant.getPhone());
        System.out.println();
        System.out.println("********************************");
        System.out.println("Cash RECEIPT");
        System.out.println("********************************");
        System.out.println("Description              Price");
        for (Menu menu : resMenu) {
            System.out.println(menu.getName() + "      " + menu.getPrice());   
        }
        System.out.println("Total" + "      " + sum);
        System.out.println();
    }
    
    /**
     * Create bill by the order
     * @param order Order
     */
    public void makeBill(Order order){
        List<Menu> resMenus = order.getMenus();
        double sum = 0;
        /*
         * need to think about ingredients have or have not
         */
        for(Menu menu : resMenus){ 
            for(Map.Entry<String, Double> usedIngredient:menu.getUsedIngredients().entrySet()){
                Double value = Double.parseDouble(usedIngredient.getValue().toString());
                Food food = restaurant.getInventory().getIngredientsByKey(usedIngredient.getKey());
                if(!food.getQuantityEqualToZero()){
                    food.minusWeight(value);
                    if(food.getStartingWeightEqualToZero()){
                        food.minusQuantity(1);
                        food.resSetStartingWeight();
                    }
                }
                else{
                    menu.setSumPlus(false);
                }
            }
            if(menu.getSumPlus()){
                sum += menu.getPrice();
            }
        }
        makeReceipt(resMenus, sum);        
    }
    
    /**
     * 
     * Add Menu if the order is saved in the restaurant.
     * 
     */
    public void addMenuWithSaved(){
        if(this.order != null){
            for(Menu menuSingleItem : this.order.getMenus()){
                orderItems.addElement(menuSingleItem.getName());
            }
        }
    }

    /**
     * 
     * clear the order item list with action listeners
     * 
     */
    private void clearOrder() {
        orderItems.clear();
        this.dispose();
    }

    /**
     * 
     * place menu to the order item list with action listeners
     * 
     */
    private void placeOrder() {
        // Logic to process the order and notify the kitchen, etc.
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
        if(order == null){
            order = prepareFoodOrder(restaurant.getMenuList());
        }
        //bill & receipt printing
        makeBill(order);
        clearOrder();
    }

    /**
     * 
     * order paid event with action listeners
     * 
     */
    private void paidEvent(){
        this.order.setTableNumber("paid");
        restaurant.addTodayWage(this.order.getTotal());
        this.dispose();
    }
    
    /**
     * Display the menu List with action listeners
     * @param e ListSelectionEvent
     * @param menuList String with JList
     */
    private void menuListEventList(ListSelectionEvent e, JList<String> menuList){
        if (!e.getValueIsAdjusting()) {
            String selectedMenu = menuList.getSelectedValue();
            if (selectedMenu != null) {
                addMenu(selectedMenu);
            }
        }
    }
    
    /**
     * 
     * Initialize the menu list with the name.
     * 
     */
    private void initializeMenu() {
        menus = new DefaultListModel<>();
        List<Menu> resMenus = restaurant.getMenuList();
        for(Menu menu : resMenus){
            menus.addElement(menu.getName());
        }
    }
    
    /**
     * 
     * Create the order GUI
     * 
     */
    private void initializeGUI() {
        orderItems = new DefaultListModel<>();
        addMenuWithSaved();

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel orderPanel = new JPanel(new BorderLayout());
        JPanel menuPanel = new JPanel(new BorderLayout());

        JButton placeOrderBtn = new JButton("Place Order");
        JButton clearOrderBtn = new JButton("Clear Order");
        JButton paidOrderBtn = new JButton("Paid Order");
        
        // Order List
        orderList = new JList<>(orderItems);
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        orderPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderPanel.add(placeOrderBtn, BorderLayout.SOUTH);
        
        if(this.order != null && this.order.getSubmitted()){
            orderPanel.add(paidOrderBtn, BorderLayout.NORTH);
        }
        else{
            orderPanel.add(clearOrderBtn, BorderLayout.NORTH);
        }
        // Menu List
        JList<String> menuList = new JList<>(menus);
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        menuPanel.add(menuScrollPane, BorderLayout.CENTER);

        // Main Window
        mainPanel.add(orderPanel, BorderLayout.EAST);
        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Action Listeners
        menuList.addListSelectionListener(e -> menuListEventList(e, menuList));
        placeOrderBtn.addActionListener(e -> placeOrder());    
        clearOrderBtn.addActionListener(e -> clearOrder());
        paidOrderBtn.addActionListener(e -> paidEvent());

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    /**
     * Order_GUI constructor
     * @param res Restaurant
     * @param order Order
     */
    public Order_GUI(Restaurant res, Order order) {
        super("Restaurant Management System Order");
        this.restaurant = res;
        if(order != null){
            this.order = order;
        }
        initializeMenu();
        initializeGUI();
    }

}
