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
    
    private JTextField foodStartWeight;
    
    private JTextField foodDescription;
    
    private JTextField foodPrice;
    
    private JTextField foodType;

    /**
     * Cancel add food with action listeners
     * @void
     */
    public void cancelEvent() {
        JOptionPane.showMessageDialog(this, "add Food Event Cancel!");
        this.dispose();
    }

    /**
     * Add food with action listeners
     * @param inventoryItems
     */
    public void confirmEvent(DefaultListModel<String> inventoryItems) {

        String name = foodName.getText();
        String quantity = foodQuantity.getText();
        String weight = foodWeight.getText();
        
        String startWeight = foodStartWeight.getText();
        String description = foodDescription.getText();
        String price = foodPrice.getText();
        String type = foodType.getText() == null ? "raw" : foodType.getText();

        if(
            !Helper.checkStringIsNumber(quantity) ||
            !Helper.checkStringIsNumber(weight) ||
            !Helper.checkStringIsNumber(startWeight) ||
            !Helper.checkStringIsNumber(price)
        ){
            JOptionPane.showMessageDialog(this, "Your food is setting error");
            return;
        }
        
        /* add to inventory */
        restaurant.addInventoryByIngredients(
            new Food(
                name,
                description,
                Double.parseDouble(price),
                Integer.parseInt(quantity),
                Double.parseDouble(weight),
                Double.parseDouble(startWeight),
                false,
                type
            )   
        );
        inventoryItems.addElement(name);
        this.dispose();
    }

    /**
     * Create the food GUI
     */
    private void initializeGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_NorthUpper = new JPanel(new BorderLayout());
        JPanel tablePanel_NorthDown = new JPanel(new BorderLayout());
        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_CenterUpper = new JPanel(new BorderLayout());
        JPanel tablePanel_CenterDown = new JPanel(new BorderLayout());
        JPanel tablePanel_South = new JPanel(new BorderLayout());

        /**
         * NorthUpper
         */
        JLabel labelShowName = new JLabel("Name:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));
        JLabel labelShowQuantity = new JLabel("Quantity:");
        labelShowQuantity.setPreferredSize(new Dimension( 80, 24 ));
        JLabel labelShowWeight = new JLabel("Weight:");
        labelShowWeight.setPreferredSize(new Dimension( 80, 24 ));
        
        /*
         * NorthDowner
         */
        foodName = new JTextField();
        foodName.setPreferredSize(new Dimension( 120, 24 ));
        foodQuantity = new JTextField();
        foodQuantity.setPreferredSize(new Dimension( 80, 24 ));
        foodWeight = new JTextField();
        foodWeight.setPreferredSize(new Dimension( 80, 24 ));
        
        /**
         * CenterUpper
         */
        JLabel labelShowStartWeight = new JLabel("Start Weight:");
        labelShowStartWeight.setPreferredSize(new Dimension( 120, 24 ));
        JLabel labelShowDescription = new JLabel("Description:");
        labelShowDescription.setPreferredSize(new Dimension( 80, 24 ));
        JLabel labelShowPrice = new JLabel("Price:");
        labelShowPrice.setPreferredSize(new Dimension( 80, 24 ));
        
        /*
         * CenterDown
         */
        foodStartWeight = new JTextField();
        foodStartWeight.setPreferredSize(new Dimension( 120, 24 ));
        foodDescription = new JTextField();
        foodDescription.setPreferredSize(new Dimension( 80, 24 ));
        foodPrice = new JTextField();
        foodPrice.setPreferredSize(new Dimension( 80, 24 ));
        
        /**
         * South
         */
        foodType = new JTextField("Type");
        foodType.setPreferredSize(new Dimension( 80, 24 ));
        JButton confirmButton = new JButton("confirm Button");
        JButton cancelButton = new JButton("cancel Button");

        tablePanel_NorthUpper.add(labelShowName, BorderLayout.WEST);
        tablePanel_NorthUpper.add(labelShowQuantity, BorderLayout.CENTER);
        tablePanel_NorthUpper.add(labelShowWeight, BorderLayout.EAST);

        tablePanel_NorthDown.add(foodName, BorderLayout.WEST);
        tablePanel_NorthDown.add(foodQuantity, BorderLayout.CENTER);
        tablePanel_NorthDown.add(foodWeight, BorderLayout.EAST);
        
        tablePanel_CenterUpper.add(labelShowStartWeight, BorderLayout.WEST);
        tablePanel_CenterUpper.add(labelShowDescription, BorderLayout.CENTER);
        tablePanel_CenterUpper.add(labelShowPrice, BorderLayout.EAST);

        tablePanel_CenterDown.add(foodStartWeight, BorderLayout.WEST);
        tablePanel_CenterDown.add(foodDescription, BorderLayout.CENTER);
        tablePanel_CenterDown.add(foodPrice, BorderLayout.EAST);
        
        tablePanel_North.add(tablePanel_NorthUpper, BorderLayout.NORTH);
        tablePanel_North.add(tablePanel_NorthDown, BorderLayout.SOUTH);
        tablePanel_Center.add(tablePanel_CenterUpper, BorderLayout.NORTH);
        tablePanel_Center.add(tablePanel_CenterDown, BorderLayout.SOUTH);
        
        tablePanel_South.add(foodType, BorderLayout.WEST);
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
     * Food_GUI constructor
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
