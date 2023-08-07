package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Food;
import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class Food_GUI extends JFrame {

    private Restaurant restaurant;
    private DefaultListModel<String> inventoryItems;

    private JTextField foodName;
    private JTextField foodQuantity;
    private JTextField foodWeight;

    /**
     * 
     */
    private void cancelEvent() {
        JOptionPane.showMessageDialog(this, "add Food Event Cancel!");
        this.dispose();
    }

    /**
     * 
     * @param inventoryItems
     */
    private void confirmEvent(DefaultListModel<String> inventoryItems) {

        String name = foodName.getText();
        String quantity = foodQuantity.getText();
        String weight = foodWeight.getText();

        if(
            !Helper.checkStringIsNumber(quantity) ||
            !Helper.checkStringIsNumber(weight)
        ){
            JOptionPane.showMessageDialog(this, "Your food is setting error");
            return;
        }
        
        /* add to inventory */
        restaurant.addInventoryByIngredients(
            new Food(
                name,
                "",
                Integer.parseInt(quantity),
                0,
                Double.parseDouble(weight),
                Double.parseDouble(weight),
                false
            )   
        );
        inventoryItems.addElement(name);
        this.dispose();
    }

    /**
     * 
     */
    private void initializeGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

        /**
         * North 
         */
        JLabel labelShowName = new JLabel("Name:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));
        JLabel labelShowQuantity = new JLabel("Quantity:");
        labelShowQuantity.setPreferredSize(new Dimension( 80, 24 ));
        JLabel labelShowWeight = new JLabel("Weight:");
        labelShowWeight.setPreferredSize(new Dimension( 80, 24 ));
        /*
         * Center
         */
        foodName = new JTextField();
        foodName.setPreferredSize(new Dimension( 120, 24 ));
        foodQuantity = new JTextField();
        foodQuantity.setPreferredSize(new Dimension( 80, 24 ));
        foodWeight = new JTextField();
        foodWeight.setPreferredSize(new Dimension( 80, 24 ));

        /**
         * South
         */
        JButton confirmButton = new JButton("confirm Button");
        JButton cancelButton = new JButton("cancel Button");

        tablePanel_North.add(labelShowName, BorderLayout.WEST);
        tablePanel_North.add(labelShowQuantity, BorderLayout.CENTER);
        tablePanel_North.add(labelShowWeight, BorderLayout.EAST);

        tablePanel_Center.add(foodName, BorderLayout.WEST);
        tablePanel_Center.add(foodQuantity, BorderLayout.CENTER);
        tablePanel_Center.add(foodWeight, BorderLayout.EAST);

        tablePanel_South.add(confirmButton, BorderLayout.CENTER);
        tablePanel_South.add(cancelButton, BorderLayout.EAST);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        confirmButton.addActionListener(e -> confirmEvent(inventoryItems));    
        cancelButton.addActionListener(e -> cancelEvent());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * @param res
     * @param inventoryItems
     */
    Food_GUI(Restaurant res, DefaultListModel<String> inventoryItems){
        super("Restaurant Management System Food");
        this.restaurant = res;
        this.inventoryItems = inventoryItems;
        initializeGUI();
    }

}
