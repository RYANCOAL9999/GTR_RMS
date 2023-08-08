package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Date;

import entities.Order;
import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class SalesRecord_GUI extends JFrame{

    private Restaurant restaurant;

    private Date date;

    private List<JButton> orderItem;

    private final int constantsNumber = 3;

    /**
     * 
     * @void
     */
    public void cancelEvent(){
        JOptionPane.showMessageDialog(this, "Cancel Order Show");
        this.dispose();
    }

    /**
     * 
     * @param number
     */
    public void orderSingleItemClick(int number) {
       Order order = restaurant.getOrderList().get(number-1);
       Order_GUI gui = new Order_GUI(restaurant, order);
       gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI(String header) {
        /**
         * List out sales Records
         * record all sales transactions, including the date, time, table number, ordered items, and total amount.
         * generate reports summarizing daily, weekly, monthly, or custom periods of sales to analyze revenue performance.
         */
        orderItem = new ArrayList<>();

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

        JLabel labelShowName = new JLabel(header);
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));

        List<Order> orderList = restaurant.getOrderList();

        if(date != null) {
            for(Order order : orderList) {
                if(order.getOrderDate() == date){
                    JButton orderButton = new JButton(String.valueOf(order.getOrderId()));
                    orderItem.add(orderButton);
                }
            }
        }
        else{
            for(Order order : orderList) {
                JButton orderButton = new JButton(String.valueOf(order.getOrderId()));
                orderItem.add(orderButton);
            }
        }

        JButton cancelButton = new JButton("cancel Button");

        tablePanel_North.add(labelShowName, BorderLayout.WEST);

        // /*
        //  * Center
        //  * add item with forEach with orderItem to tablePanel_Center
        //  * need to think about how to make it with 2d array without adding tablePanel
        //  */  
        for(int i=0; i<orderItem.size(); i++){
            JButton item = orderItem.get(i);
            tablePanel_Center.add(item, Helper.getCheckBoxConstraints(i, constantsNumber));
        }

        // tablePanel_South.add(confirmButton, BorderLayout.CENTER);
        tablePanel_South.add(cancelButton, BorderLayout.EAST);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        for(JButton item: orderItem){
            item.addActionListener(e -> orderSingleItemClick(Integer.parseInt(item.getText())));
        }

        cancelButton.addActionListener(e -> cancelEvent());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(270, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * @param res
     * @param date
     * @param header
     */
    public SalesRecord_GUI(Restaurant res, Date date, String header){
        this.restaurant = res;
        if(date != null){
            this.date = date;
        }
        this.initializeGUI(header);
    }

    
}
