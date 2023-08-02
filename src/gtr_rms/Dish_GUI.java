package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Restaurant;

public class Dish_GUI extends JFrame{

    private Restaurant restaurant;
    private DefaultListModel<String> inventoryItems;

    private JTextField dishName;
    private JTextField dishDescription;
    private JTextField dishPrice;
    private List<JCheckBox> foodItems;

    private final int constantsNumber = 3;

    private void cancelEvent() {
        JOptionPane.showMessageDialog(this, "add Food Event Cancel!");
        this.dispose();
    }

    private void confirmEvent(DefaultListModel<String> inventoryItems) {
        restaurant.addMenuItem(
            dishName.getText(), 
            dishDescription.getText(), 
            Double.parseDouble(dishPrice.getText())
        );
        inventoryItems.addElement(dishName.getText());
        this.dispose();
    }

    private String getCheckBoxConstraints(int i, int number){
        return i % number == 0 ? BorderLayout.WEST : i % number == 1 ? BorderLayout.CENTER : BorderLayout.EAST;
    }

    private void initializeGUI() {

        foodItems = new ArrayList<JCheckBox>();

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Upper = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Down = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());
        /**
         * North 
         */
        JLabel labelShowName = new JLabel("Name:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));
        JLabel labelShowDescription = new JLabel("Description:");
        labelShowDescription.setPreferredSize(new Dimension( 80, 24 ));
        JLabel labelShowPrice = new JLabel("Price:");
        labelShowPrice.setPreferredSize(new Dimension( 80, 24 ));
        dishName = new JTextField();
        dishName.setPreferredSize(new Dimension( 120, 24 ));
        dishDescription = new JTextField();
        dishDescription.setPreferredSize(new Dimension( 80, 24 ));
        dishPrice = new JTextField();
        dishPrice.setPreferredSize(new Dimension( 80, 24 ));

        /*
         * Center
         * Generate the coding with forEach with food items
         */
        HashMap<String, Integer> ingredients = restaurant.getInventory().getIngredients();
        for(Entry<String, Integer> ingredientItem: ingredients.entrySet()){
            JCheckBox box = new JCheckBox(ingredientItem.getKey());
            foodItems.add(box);
        }
        /**
         * South
         */
        JButton confirmButton = new JButton("confirm Button");
        JButton cancelButton = new JButton("cancel Button");

        tablePanel_North_Upper.add(labelShowName, BorderLayout.WEST);
        tablePanel_North_Upper.add(labelShowDescription, BorderLayout.CENTER);
        tablePanel_North_Upper.add(labelShowPrice, BorderLayout.EAST);

        tablePanel_North_Down.add(dishName, BorderLayout.WEST);
        tablePanel_North_Down.add(dishDescription, BorderLayout.CENTER);
        tablePanel_North_Down.add(dishPrice, BorderLayout.EAST);

        /*
         * Center
         * add tictBox with forEach with food items to tablePanel_Center
         * need to thing about how to make it with 2d array without adding tablePanel
         */  
        for(int i=0; i<foodItems.size(); i++){
            JCheckBox item = foodItems.get(i);
            item.setPreferredSize(new Dimension( 20, 24 ));
            tablePanel_Center.add(item, getCheckBoxConstraints(i, constantsNumber));
        }

        tablePanel_South.add(confirmButton, BorderLayout.CENTER);
        tablePanel_South.add(cancelButton, BorderLayout.EAST);

        tablePanel_North.add(tablePanel_North_Upper, BorderLayout.NORTH);
        tablePanel_North.add(tablePanel_North_Down, BorderLayout.SOUTH);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        confirmButton.addActionListener(e -> confirmEvent(inventoryItems));    
        cancelButton.addActionListener(e -> cancelEvent());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }


    Dish_GUI(Restaurant res, DefaultListModel<String> inventoryItems){
        super("Restaurant Management System Food");
        this.restaurant = res;
        this.inventoryItems = inventoryItems;
        initializeGUI();
    }
    
}
