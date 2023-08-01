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
    
    private void showMenuGUI(){
        Order_GUI gui = new Order_GUI(restaurant);
        gui.setVisible(true);
    }
    
    private void placeTable(ActionEvent event) {
        // Logic to process the order and notify the kitchen, etc.
        restaurant.addOrderNumber();
        String[] splited = event.getActionCommand().split(" ");
        //Need to handle save table with Order 1
        restaurant.addOrder(Integer.parseInt(splited[1]));
        showMenuGUI();
    }

    private void initializeGUI() {
        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel TablePanel_North = new JPanel(new BorderLayout());
        JPanel TablePanel_Center = new JPanel(new BorderLayout());
        JPanel TablePanel_South = new JPanel(new BorderLayout());
        
        JButton Table1 = new JButton("Table 1");
        JButton Table2 = new JButton("Table 2");
        JButton Table3 = new JButton("Table 3");

        TablePanel_North.add(Table1, BorderLayout.WEST);
        TablePanel_North.add(Table2, BorderLayout.CENTER);
        TablePanel_North.add(Table3, BorderLayout.EAST);
        
        JButton Table4 = new JButton("Table 4");
        JButton Table5 = new JButton("Table 5");
        JButton Table6 = new JButton("Table 6");

        TablePanel_Center.add(Table4, BorderLayout.WEST);
        TablePanel_Center.add(Table5, BorderLayout.CENTER);
        TablePanel_Center.add(Table6, BorderLayout.EAST);
                
        JButton Table7 = new JButton("Table 7");
        JButton Table8 = new JButton("Table 8");
        JButton Table9 = new JButton("Table 9");

        TablePanel_South.add(Table7, BorderLayout.WEST);
        TablePanel_South.add(Table8, BorderLayout.CENTER);
        TablePanel_South.add(Table9, BorderLayout.EAST);
        
        mainPanel.add(TablePanel_North, BorderLayout.NORTH);
        mainPanel.add(TablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(TablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        Table1.addActionListener(e -> placeTable(e));    
        Table2.addActionListener(e -> placeTable(e));
        Table3.addActionListener(e -> placeTable(e));    
        Table4.addActionListener(e -> placeTable(e));
        Table5.addActionListener(e -> placeTable(e));    
        Table6.addActionListener(e -> placeTable(e));
        Table7.addActionListener(e -> placeTable(e));    
        Table8.addActionListener(e -> placeTable(e));
        Table9.addActionListener(e -> placeTable(e));
        
        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 120);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    public Table_GUI(Restaurant res){
        super("Restaurant Management System Table");
        this.restaurant = res;
        initializeGUI();
    }
    
}
