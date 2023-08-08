package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Food;
import entities.MenuItem;
import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class Dish_GUI extends JFrame{

    private Restaurant restaurant;
    
    private DefaultListModel<String> inventoryItems;

    private JTextField dishName;
    
    private JTextField dishDescription;
    
    private JTextField dishPrice;
    
    private List<JCheckBox> foodItems;

    private final int constantsNumber = 3;

    /**
     * 
     */
    public void cancelEvent() {
        JOptionPane.showMessageDialog(this, "add Food Event Cancel!");
        this.dispose();
    }

    /**
     * 
     * @param inventoryItems
     */
    public void confirmEvent(DefaultListModel<String> inventoryItems) {

        String price = dishPrice.getText();

        if(!Helper.checkStringIsNumber(price)){
            JOptionPane.showMessageDialog(this, "Your Dish is setting error");
            return;
        }

        String name = dishName.getText();

        restaurant.addMenuItem(
            new MenuItem(
                name, 
                dishDescription.getText(), 
                Double.parseDouble(price)
            )
        );

        inventoryItems.addElement(name);
        this.dispose();
    }

    /**
     * 
     */
    private void initializeGUI() {

        foodItems = new ArrayList<>();

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
        List<Food> ingredients = restaurant.getInventory().getIngredients();
        for(Food food: ingredients){
            if(!food.getNoEffect()){
                JCheckBox box = new JCheckBox(food.getName());
                foodItems.add(box);
            }
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
         * need to think about how to make it with 2d array without adding tablePanel
         */  
        for(int i=0; i<foodItems.size(); i++){
            JCheckBox item = foodItems.get(i);
            item.setPreferredSize(new Dimension( 20, 24 ));
            tablePanel_Center.add(item, Helper.getCheckBoxConstraints(i, constantsNumber));
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

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * @param res
     * @param inventoryItems
     */
    Dish_GUI(Restaurant res, DefaultListModel<String> inventoryItems){
        super("Restaurant Management System Food");
        this.restaurant = res;
        this.inventoryItems = inventoryItems;
        initializeGUI();
    }
    
}
