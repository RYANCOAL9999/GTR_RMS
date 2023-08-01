/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gtr_rms;

import entities.Inventory;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author W22079254
 */
public class Ingredients_GUI extends JFrame{
    
//    private List<Inventory> InventroyItems;
    
    private JList<String> InventoryList;
    private DefaultListModel<String> InventoryItems;
    
    private void initializeGUI() {
        InventoryItems = new DefaultListModel<>();
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel TablePanel_North = new JPanel(new BorderLayout());
        JPanel TablePanel_Center = new JPanel(new BorderLayout());
        JPanel TablePanel_South = new JPanel(new BorderLayout());
        
        JLabel labelShowHeader = new JLabel("Ingredients:");
        JButton add_food = new JButton("add food");
        
        
        TablePanel_North.add(labelShowHeader, BorderLayout.WEST);
        TablePanel_North.add(add_food, BorderLayout.EAST);
        
        InventoryList = new JList<>(InventoryItems);
        JScrollPane orderScrollPane = new JScrollPane(InventoryList);
        TablePanel_Center.add(orderScrollPane, BorderLayout.CENTER);
        
        JButton finish = new JButton("finish");
        TablePanel_South.add(finish, BorderLayout.EAST);
        
        
        mainPanel.add(TablePanel_North, BorderLayout.NORTH);
        mainPanel.add(TablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(TablePanel_South, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 400);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }
    
    Ingredients_GUI(){
        super("Restaurant Management System Ingredients");
        initializeGUI();
    }
    
}
