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
     */
    public void clearOrder() {
        orderItems.clear();
    }
    
    /**
     * 
     * @param resMenuItem
     * @return
     */
    public Order prepareFoodOrder(List<MenuItem> resMenuItem) {
        // Order newOrder = new Order(restaurant.getOrderNumber(), 0);        
        // for(int i = 0; i < orderItems.getSize();i++){
        //     for(int j = 0; j < resMenuItem.size();j++){
        //         if(orderItems.get(i) == null ? resMenuItem.get(j).getName() == null : orderItems.get(i).equals(resMenuItem.get(j).getName())){
        //             newOrder.addItem(resMenuItem.get(j));
        //         }
        //     }
        // }
        Order saveOrder = restaurant.getOrder().get(restaurant.getOrderNumber()-1);
        for(int i = 0; i < orderItems.getSize();i++){
            for(int j = 0; j < resMenuItem.size();j++){
                if(orderItems.get(i) == null ? resMenuItem.get(j).getName() == null : orderItems.get(i).equals(resMenuItem.get(j).getName())){
                    saveOrder.addItem(resMenuItem.get(j));
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
    public void makeReceipt(List<MenuItem> resMenuItem, int sum){
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
        int sum = 0;
        for(int i = 0 ; i < resMenuItem.size();i++){
            sum += resMenuItem.get(i).getPrice();
        }
        makeReceipt(resMenuItem, sum);        
    }

    /**
     * 
     */
    public void placeOrder() {
        // Logic to process the order and notify the kitchen, etc.
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
        if(order == null){
            order = prepareFoodOrder(restaurant.getMenuItem());
        }
        System.out.println("Hello" + order.getMenuItems().size());
        //bill & receipt printing
        makeBill(order);
        clearOrder();
    }
    
    /**
     * 
     */
    private void initializeMenu() {
        menuItems = new DefaultListModel<>();
        List<MenuItem> resMenuItem = restaurant.getMenuItem();
        System.out.println("Hello 222" + resMenuItem.size());
        for (int i = 0; i < resMenuItem.size(); i++){
            menuItems.addElement(resMenuItem.get(i).getName());
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
            List<MenuItem> menuItems = this.order.getMenuItems();
            System.out.println(menuItems.size());
            for(MenuItem menuSingleItem : menuItems){
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
        
        // Order List
        orderList = new JList<>(orderItems);
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        orderPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderPanel.add(placeOrderBtn, BorderLayout.SOUTH);
        orderPanel.add(clearOrderBtn, BorderLayout.NORTH);

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
