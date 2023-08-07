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
public class Menu_GUI extends JFrame{

    private Restaurant restaurant;

    private JList<String> menuList;
    
    private DefaultListModel<String> menuItems;

    /**
     * 
     */
    private void finishEvent(){
        JOptionPane.showMessageDialog(this, "Menu item action finished!");
        restaurant.setMenuReady(true);
        this.dispose();
    }

    /**
     * 
     * @param inventoryItems
     */
    private void addMenu(DefaultListModel<String> inventoryItems){
        Dish_GUI gui = new Dish_GUI(restaurant, inventoryItems);
        gui.setVisible(true);
    }

    /**
     * 
     */
    private void initializeGUI() {
        menuItems = new DefaultListModel<>();
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        JLabel labelShowHeader = new JLabel("Menus:");
        JButton add_menu = new JButton("add Menu");
        
        tablePanel_North.add(labelShowHeader, BorderLayout.WEST);
        tablePanel_North.add(add_menu, BorderLayout.EAST);

        menuList = new JList<>(menuItems);
        JScrollPane orderScrollPane = new JScrollPane(menuList);
        tablePanel_Center.add(orderScrollPane, BorderLayout.CENTER);
        
        JButton finish = new JButton("finish");
        tablePanel_South.add(finish, BorderLayout.EAST);
        
        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        add_menu.addActionListener(e -> addMenu(menuItems));    
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
    Menu_GUI(Restaurant res){
        super("Restaurant Management System Menu");
        this.restaurant = res;
        initializeGUI();
    }

}
