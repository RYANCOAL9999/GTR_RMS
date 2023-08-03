package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Order;
import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class OrderList_GUI extends JFrame{

    private Restaurant restaurant;

    private List<JButton> orderItem;

    private void orderSingleItemClick(int number) {

       Order order = restaurant.getOrder().get(number-1);
       Order_GUI gui = new Order_GUI(restaurant, order);
       gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI() {
        orderItem = new ArrayList<JButton>();

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

        JLabel labelShowName = new JLabel("Order List:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        List<Order> orderList = restaurant.getOrder();
        for(Order order : orderList) {
            JButton orderButton = new JButton(String.valueOf(order.getOrderId()));
            orderItem.add(orderButton);
        }

        JButton confirmButton = new JButton("confirm Button");
        JButton cancelButton = new JButton("cancel Button");

        tablePanel_North.add(labelShowName, BorderLayout.WEST);

        // /*
        //  * Center
        //  * add item with forEach with orderItem to tablePanel_Center
        //  * need to think about how to make it with 2d array without adding tablePanel
        //  */  
        for(int i=0; i<orderItem.size(); i++){
            JButton item = orderItem.get(i);
            tablePanel_Center.add(item, BorderLayout.CENTER);
        }

        tablePanel_South.add(confirmButton, BorderLayout.CENTER);
        tablePanel_South.add(cancelButton, BorderLayout.EAST);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        // confirmButton.addActionListener(e -> confirmEvent(inventoryItems));    
        // cancelButton.addActionListener(e -> cancelEvent());
        for(JButton item: orderItem){
            item.addActionListener(e -> orderSingleItemClick(Integer.parseInt(item.getText())));
        }

        // confirmButton.addActionListener(e -> confirmEvent(inventoryItems));    
        // cancelButton.addActionListener(e -> cancelEvent());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(270, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     */
    public OrderList_GUI(Restaurant res){
        this.restaurant = res;
        this.initializeGUI();
    }

    
}
