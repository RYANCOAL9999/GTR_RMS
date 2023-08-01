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
import entities.Restaurant;
import entities.Order;
import entities.MenuItem;
import java.awt.event.ActionEvent;

/**
 *
 * @author W22079254
 */
public class Restaurant_GUI extends JFrame{
    
    private Restaurant restaurant;
    
    private JList<String> orderList;
    private DefaultListModel<String> menuItems;
    private DefaultListModel<String> orderItems;
    
    private final String restaurntName = "";
    private final String restaurntAddress = "";
    private final String restaurntPhone = "";
    
    
    public void addMenuItem(String name) {
        orderItems.addElement(name);
    }
    
    public void clearOrder() {
        orderItems.clear();
    }
    
    public Order prepareFoodOrder(List<MenuItem> resMenuItem) {
        Order newOrder = new Order(restaurant.getOrderNumber(), 0);        
        for(int i = 0; i < orderItems.getSize();i++){
            for(int j = 0; j < resMenuItem.size();j++){
                if(orderItems.get(i) == null ? resMenuItem.get(j).getName() == null : orderItems.get(i).equals(resMenuItem.get(j).getName())){
                    newOrder.addItem(resMenuItem.get(j));
                }
            }
        }
        return newOrder;
    }
    
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
    
    public void makeBill(Order order){
        List<MenuItem> resMenuItem = order.getOrderItems();
        int sum = 0;
        for(int i = 0 ; i < resMenuItem.size();i++){
            sum += resMenuItem.get(i).getPrice();
        }
        makeReceipt(resMenuItem, sum);        
    }

    public void placeOrder() {
        // Logic to process the order and notify the kitchen, etc.
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
        Order order = prepareFoodOrder(restaurant.getMenuItem());
        //bill & receipt printing
        makeBill(order);
        clearOrder();
    }
    
    public void placeTable(ActionEvent event) {
        // Logic to process the order and notify the kitchen, etc.
        restaurant.addOrderNumber();
        String[] splited = event.getActionCommand().split(" ");
        //Need to handle save table with Order 1
        restaurant.addOrder(Integer.parseInt(splited[1]));
    }
    
    private void initializeMenu() {
        
        restaurant = new Restaurant(restaurntName, restaurntAddress, restaurntPhone);
    
        menuItems = new DefaultListModel<>();
        
        
        List<MenuItem> resMenuItem = restaurant.getMenuItem();
        
        for (int i = 0; i < resMenuItem.size(); i++){
            menuItems.addElement(resMenuItem.get(i).getName());
        }
    }

    private void initializeGUI() {
        orderItems = new DefaultListModel<>();

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel orderPanel = new JPanel(new BorderLayout());
        JPanel menuPanel = new JPanel(new BorderLayout());
        JButton placeOrderBtn = new JButton("Place Order");
        
//        JButton Table1 = new JButton("Table 1");
//        JButton Table2 = new JButton("Table 2");
//        JButton Table3 = new JButton("Table 3");
//        JButton Table4 = new JButton("Table 4");
//        JButton Table5 = new JButton("Table 5");
//        JButton Table6 = new JButton("Table 6");
//        JButton Table7 = new JButton("Table 7");
//        JButton Table8 = new JButton("Table 8");
//        JButton Table9 = new JButton("Table 9");
        
        JButton clearOrderBtn = new JButton("Clear Order");
        
        // Order List
        orderList = new JList<>(orderItems);
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        orderPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderPanel.add(placeOrderBtn, BorderLayout.SOUTH);
        
//        orderPanel.add(Table1, BorderLayout.WEST);
//        orderPanel.add(Table2, BorderLayout.CENTER);
//        orderPanel.add(Table3, BorderLayout.EAST);
//        orderPanel.add(Table4, BorderLayout.WEST);
//        orderPanel.add(Table5, BorderLayout.WEST);
//        orderPanel.add(Table6, BorderLayout.WEST);
//        orderPanel.add(Table7, BorderLayout.WEST);
//        orderPanel.add(Table8, BorderLayout.WEST);
//        orderPanel.add(Table9, BorderLayout.WEST);
        orderPanel.add(clearOrderBtn, BorderLayout.NORTH);

        // Menu List
        JList<String> menuList = new JList<>(menuItems);
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        menuPanel.add(menuScrollPane, BorderLayout.CENTER);

        // Main Window
        mainPanel.add(orderPanel, BorderLayout.EAST);
        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Action Listeners
        menuList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedMenuItem = menuList.getSelectedValue();
                if (selectedMenuItem != null) {
                    addMenuItem(selectedMenuItem);
                }
            }
        });

        placeOrderBtn.addActionListener(e -> placeOrder());
//        Table1.addActionListener(e -> placeTable(e));
//        Table2.addActionListener(e -> placeTable(e));
//        Table3.addActionListener(e -> placeTable(e));
//        Table4.addActionListener(e -> placeTable(e));
//        Table5.addActionListener(e -> placeTable(e));
//        Table6.addActionListener(e -> placeTable(e));
//        Table7.addActionListener(e -> placeTable(e));
//        Table8.addActionListener(e -> placeTable(e));
//        Table9.addActionListener(e -> placeTable(e));
        
        clearOrderBtn.addActionListener(e -> clearOrder());

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    public Restaurant_GUI(){
        super("Restaurant Management System");
        initializeMenu();
        initializeGUI();
    }

}
