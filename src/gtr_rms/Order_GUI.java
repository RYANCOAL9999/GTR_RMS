/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gtr_rms;

import java.awt.BorderLayout;

import java.util.List;
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
import entities.MenuItem;

/**
 *
 * @author W22079254
 */
public class Order_GUI extends JFrame{
    
    private Restaurant restaurant;

    private Order order;
    
    private JList<String> orderList;
    
    private DefaultListModel<String> menuItems;
    
    private DefaultListModel<String> orderItems;
    
    /**
     * 
     * @param name
     */
    public void addMenuItem(String name) {
        orderItems.addElement(name);
    }
    
    /**
     * 
     * @param resMenuItem
     * @return
     */
    public Order prepareFoodOrder(List<MenuItem> resMenuItem) {
        Order saveOrder = restaurant.getOrderList().get(restaurant.getOrderNumber()-1);
        for(Object orderSingle: orderItems.toArray()){
            for(MenuItem item: resMenuItem){
                if(orderSingle == null ? item.getName() == null : orderSingle.equals(item.getName())){
                    saveOrder.addItem(item);
                }
            }
        }
        return saveOrder;
    }
    
    /**
     * 
     * @param resMenuItem
     * @param sum
     */
    public void makeReceipt(List<MenuItem> resMenuItem, double sum){
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
        for (MenuItem menu : resMenuItem) {
            System.out.println(menu.getName()+ "      " +menu.getPrice());   
        }
        System.out.println("Total"+ "      "+sum);    
    }
    
    /**
     * 
     * @param order
     */
    public void makeBill(Order order){
        List<MenuItem> resMenuItem = order.getMenuItems();
        double sum = 0;
        for(MenuItem menu : resMenuItem){
            sum += menu.getPrice();
        }
        makeReceipt(resMenuItem, sum);        
    }

    /**
     * 
     */
    public void clearOrder() {
        orderItems.clear();
        this.dispose();
    }

    /**
     * 
     */
    public void placeOrder() {
        // Logic to process the order and notify the kitchen, etc.
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
        if(order == null){
            order = prepareFoodOrder(restaurant.getMenuItemList());
        }
        //bill & receipt printing
        makeBill(order);
        clearOrder();
    }

    /**
     * 
     */
    public void paidEvent(){
        this.order.setTableNumber("paid");
        restaurant.addTodayWage(this.order.getTotal());
        this.dispose();
    }
    
    /**
     * 
     */
    private void initializeMenu() {
        menuItems = new DefaultListModel<>();
        List<MenuItem> resMenuItem = restaurant.getMenuItemList();
        for(MenuItem menu : resMenuItem){
            menuItems.addElement(menu.getName());
        }
    }
    
    /**
     * 
     * @param e
     * @param menuList
     */
    private void menuListEventList(ListSelectionEvent e, JList<String> menuList){
        if (!e.getValueIsAdjusting()) {
            String selectedMenuItem = menuList.getSelectedValue();
            if (selectedMenuItem != null) {
                addMenuItem(selectedMenuItem);
            }
        }
    }

    private void addMenuItemWithSaved(){
        if(this.order != null){
            for(MenuItem menuSingleItem : this.order.getMenuItems()){
                orderItems.addElement(menuSingleItem.getName());
            }
        }
    }
    
    /**
     * 
     */
    private void initializeGUI() {
        orderItems = new DefaultListModel<>();
        addMenuItemWithSaved();

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
        JList<String> menuList = new JList<>(menuItems);
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
     * 
     * @param res
     * @param order
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
