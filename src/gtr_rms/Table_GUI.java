/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gtr_rms;

import entities.Restaurant;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author W22079254
 */
public class Table_GUI extends JFrame{
    
    private Restaurant restaurant;
    
    /**
     * 
     */
    private void showOrderGUIWithSingleTable(){
        Order_GUI gui = new Order_GUI(restaurant);
        gui.setVisible(true);
    }
    
    /**
     * 
     * @param event
     */
    private void placeTable(ActionEvent event) {
        // Logic to process the order and notify the kitchen, etc.
        restaurant.addOrderNumber();
        String[] splited = event.getActionCommand().split(" ");
        //Need to handle save table with Order 1
        restaurant.addOrder(Integer.parseInt(splited[1]));
        showOrderGUIWithSingleTable();
    }

    /**
     * 
     */
    private void initializeGUI() {
        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());

        /*
         * add JButton with forEach with Inventory table to tablePanel
         * need to think about how to make it with 2d array without adding tablePanel
         */  
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        JButton table1 = new JButton("Table 1");
        JButton table2 = new JButton("Table 2");
        JButton table3 = new JButton("Table 3");

        tablePanel_North.add(table1, BorderLayout.WEST);
        tablePanel_North.add(table2, BorderLayout.CENTER);
        tablePanel_North.add(table3, BorderLayout.EAST);
        
        JButton table4 = new JButton("Table 4");
        JButton table5 = new JButton("Table 5");
        JButton table6 = new JButton("Table 6");

        tablePanel_Center.add(table4, BorderLayout.WEST);
        tablePanel_Center.add(table5, BorderLayout.CENTER);
        tablePanel_Center.add(table6, BorderLayout.EAST);
                
        JButton table7 = new JButton("Table 7");
        JButton table8 = new JButton("Table 8");
        JButton table9 = new JButton("Table 9");

        tablePanel_South.add(table7, BorderLayout.WEST);
        tablePanel_South.add(table8, BorderLayout.CENTER);
        tablePanel_South.add(table9, BorderLayout.EAST);
        
        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        table1.addActionListener(e -> placeTable(e));    
        table2.addActionListener(e -> placeTable(e));
        table3.addActionListener(e -> placeTable(e));    
        table4.addActionListener(e -> placeTable(e));
        table5.addActionListener(e -> placeTable(e));    
        table6.addActionListener(e -> placeTable(e));
        table7.addActionListener(e -> placeTable(e));    
        table8.addActionListener(e -> placeTable(e));
        table9.addActionListener(e -> placeTable(e));
        
        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    /**
     * 
     * @param res
     */
    public Table_GUI(Restaurant res){
        super("Restaurant Management System Table");
        this.restaurant = res;
        initializeGUI();
    }
    
}
