/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gtr_rms;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class Ingredients_GUI extends JFrame{

    private Restaurant restaurant;
    
    private JList<String> inventoryList;
    
    private DefaultListModel<String> inventoryItems;

    /**
     * 
     * @void
     */
    public void finishEvent(){
        JOptionPane.showMessageDialog(this, "Ingredients food action finished!");
        restaurant.getInventory().setIngredientsReady(true);
        this.dispose();
    }

    /**
     * 
     * @param inventoryItems
     */
    public void addFoodEvent(DefaultListModel<String> inventoryItems){
        Food_GUI gui = new Food_GUI(restaurant, inventoryItems);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI() {
        inventoryItems = new DefaultListModel<>();
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        JLabel labelShowHeader = new JLabel("Ingredients:");
        JButton add_food = new JButton("add food");
        
        tablePanel_North.add(labelShowHeader, BorderLayout.WEST);
        tablePanel_North.add(add_food, BorderLayout.EAST);

        inventoryList = new JList<>(inventoryItems);
        JScrollPane orderScrollPane = new JScrollPane(inventoryList);
        tablePanel_Center.add(orderScrollPane, BorderLayout.CENTER);
        
        JButton finish = new JButton("finish");
        tablePanel_South.add(finish, BorderLayout.EAST);
        
        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        add_food.addActionListener(e -> addFoodEvent(inventoryItems));    
        finish.addActionListener(e -> finishEvent());
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(270, 400);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    /**
     * 
     * @param res
     */
    Ingredients_GUI(Restaurant res){
        super("Restaurant Management System Ingredients");
        this.restaurant = res;
        initializeGUI();
    }
    
}
