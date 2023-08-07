package gtr_rms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import entities.Food;
import entities.Inventory;
import entities.MenuItem;
import entities.Restaurant;
import entities.Staff;


/**
 *
 * @author W22079254
 */
public class Authentication_GUI extends JFrame{

    private static final String filePath = "restaurant.xml";

    private static Restaurant restaurant;

    private JTextField userName;
    private JTextField password;

    private void LoginEvent(){
        // getStaff
        String name = userName.getText();
        Staff user = restaurant.getStaff(name);

        if(user == null || !user.getPassword().equals(password.getText())){
            JOptionPane.showMessageDialog(this, "Authentication Error");
            return;
        }

        if(!user.getTodayFirstTimeLogin()){
            user.setTodayFirstTimeLogin(true);
            user.addBackTowork();
        }

        Restaurant_GUI gui = new Restaurant_GUI(restaurant, user);
        gui.setVisible(true);
        this.dispose();
    }

    /**
     * 
     */
    private void initializeGUI(){

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel tablePanel_North = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Upper = new JPanel(new BorderLayout());
        JPanel tablePanel_North_Down = new JPanel(new BorderLayout());

        JPanel tablePanel_Center = new JPanel(new BorderLayout());
        JPanel tablePanel_Center_Upper = new JPanel(new BorderLayout());
        JPanel tablePanel_Center_Down = new JPanel(new BorderLayout());

        JPanel tablePanel_South = new JPanel(new BorderLayout());
        
        // LoginEvent
        //North
        JLabel labelShowName = new JLabel("UserName:");
        labelShowName.setPreferredSize(new Dimension( 120, 24 ));
        userName = new JTextField();
        userName.setPreferredSize(new Dimension( 120, 24 ));

        //Center
        JLabel labelShowPassword = new JLabel("Password:");
        labelShowPassword.setPreferredSize(new Dimension( 120, 24 ));
        password = new JTextField();
        password.setPreferredSize(new Dimension( 120, 24 ));

        //South
        JButton LoginButton = new JButton("Login");

        tablePanel_North_Upper.add(labelShowName, BorderLayout.CENTER);
        tablePanel_North_Down.add(userName, BorderLayout.CENTER);

        tablePanel_Center_Upper.add(labelShowPassword, BorderLayout.CENTER);
        tablePanel_Center_Down.add(password, BorderLayout.CENTER);

        tablePanel_South.add(LoginButton, BorderLayout.EAST);

        tablePanel_North.add(tablePanel_North_Upper, BorderLayout.NORTH);
        tablePanel_North.add(tablePanel_North_Down, BorderLayout.SOUTH);

        tablePanel_Center.add(tablePanel_Center_Upper, BorderLayout.NORTH);
        tablePanel_Center.add(tablePanel_Center_Down, BorderLayout.SOUTH);

        mainPanel.add(tablePanel_North, BorderLayout.NORTH);
        mainPanel.add(tablePanel_Center, BorderLayout.CENTER);
        mainPanel.add(tablePanel_South, BorderLayout.SOUTH);

        // Action Listeners
        LoginButton.addActionListener(e -> LoginEvent());    

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 150);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    public HashMap<String, Object> getRestaurantBYCSV(){

        HashMap<String, Object> result = new HashMap<String, Object>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filePath));

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            /**
             * first item
             */
            Node restaurntNameNode = root.getElementsByTagName("restaurntName").item(0);
            result.put(restaurntNameNode.getNodeName(), restaurntNameNode.getTextContent());
            Node restaurntAddressNode = root.getElementsByTagName("restaurntAddress").item(0);
            result.put(restaurntAddressNode.getNodeName(), restaurntAddressNode.getTextContent());
            Node restaurntPhoneNode = root.getElementsByTagName("restaurntPhone").item(0);
            result.put(restaurntPhoneNode.getNodeName(), restaurntPhoneNode.getTextContent());

            /**
             * inventory
             */
            Element inventoryElement = (Element) root.getElementsByTagName("inventory").item(0);

            // Get elements within inventory
            Element chairsElement = (Element) inventoryElement.getElementsByTagName("chairs").item(0);
            Element tablesElement = (Element) inventoryElement.getElementsByTagName("tables").item(0);
            Element dishesElement = (Element) inventoryElement.getElementsByTagName("dishes").item(0);
            Element glassesElement = (Element) inventoryElement.getElementsByTagName("glasses").item(0);
            Element chopsticksElement = (Element) inventoryElement.getElementsByTagName("chopsticks").item(0);
            Element spoonsElement = (Element) inventoryElement.getElementsByTagName("spoons").item(0);
            Element tableclothsElement = (Element) inventoryElement.getElementsByTagName("tablecloths").item(0);
            Element napkinsElement = (Element) inventoryElement.getElementsByTagName("napkins").item(0);
            Element kitchenSuppliesElement = (Element) inventoryElement.getElementsByTagName("kitchenSupplies").item(0);

            
            ArrayList<Food> ingredientList = new ArrayList<Food>();
            NodeList ingredientNode = inventoryElement.getElementsByTagName("ingredientList");
            for (int i = 0; i < ingredientNode.getLength(); i++) {
                HashMap<String, Object> ingredient = new HashMap<String, Object>();
                Element ingredientListElement = (Element) ingredientNode.item(i);

                // Get elements within ingredientList
                Element nameElement = (Element) ingredientListElement.getElementsByTagName("name").item(0);
                Element quantityElement = (Element) ingredientListElement.getElementsByTagName("quantity").item(0);
                Element weightElement = (Element) ingredientListElement.getElementsByTagName("weight").item(0);
                Element noEffectElement = (Element) ingredientListElement.getElementsByTagName("noEffect").item(0);

                ingredient.put("name", nameElement.getTextContent());
                ingredient.put("quantity", Integer.parseInt(quantityElement.getTextContent()));
                ingredient.put("weight", Double.parseDouble(weightElement.getTextContent()));
                ingredient.put("noEffect", noEffectElement.getTextContent() == "true"?true:false);

                Food newFood = new Food(
                    (String) ingredient.get("name"),
                    "", 
                    (int) ingredient.get("quantity"),
                    0, 
                    (double) ingredient.get("weight"),
                    (Boolean) ingredient.get("noEffect")
                );
                
                ingredientList.add(newFood);
            }

            Inventory newInventory = new Inventory(
                Integer.parseInt(chairsElement.getTextContent()),
                Integer.parseInt(tablesElement.getTextContent()),
                Integer.parseInt(dishesElement.getTextContent()),
                Integer.parseInt(glassesElement.getTextContent()),
                Integer.parseInt(chopsticksElement.getTextContent()),
                Integer.parseInt(spoonsElement.getTextContent()),
                Integer.parseInt(tableclothsElement.getTextContent()),
                Integer.parseInt(napkinsElement.getTextContent()),
                Integer.parseInt(kitchenSuppliesElement.getTextContent())
            );

            for(Food food : ingredientList){
                newInventory.addIngredients(food.getName(), food);
            }

            result.put("inventory", newInventory);

            /**
             * dishList
             */
            ArrayList<MenuItem> dishList = new ArrayList<MenuItem>();
            NodeList distListNode = root.getElementsByTagName("dishList");

            for (int i = 0; i < distListNode.getLength(); i++) {

                HashMap<String, Object> menu = new HashMap<String, Object>();
                Element staffListElement = (Element) distListNode.item(i);

                // Get elements within staffList
                Element nameElement = (Element) staffListElement.getElementsByTagName("name").item(0);
                Element descriptionElement = (Element) staffListElement.getElementsByTagName("description").item(0);
                Element priceElement = (Element) staffListElement.getElementsByTagName("price").item(0);


                menu.put("name", nameElement.getTextContent());
                menu.put("description", descriptionElement.getTextContent());
                menu.put("price", Double.parseDouble(priceElement.getTextContent()));

                MenuItem menuItem = new MenuItem(
                    (String) menu.get("name"),
                    (String) menu.get("description"),
                    (double) menu.get("price")
                );
                
                dishList.add(menuItem);
            }

            result.put("distList", dishList);

            /**
             * staffList
             */
            ArrayList<Staff> staffList = new ArrayList<Staff>();
            NodeList staffListNode = root.getElementsByTagName("staffList");

            for (int i = 0; i < staffListNode.getLength(); i++) {

                HashMap<String, Object> staff = new HashMap<String, Object>();
                Element staffListElement = (Element) staffListNode.item(i);

                // Get elements within staffList
                Element usernameElement = (Element) staffListElement.getElementsByTagName("username").item(0);
                Element passwordElement = (Element) staffListElement.getElementsByTagName("password").item(0);
                Element roleElement = (Element) staffListElement.getElementsByTagName("role").item(0);
                Element contactElement = (Element) staffListElement.getElementsByTagName("contact").item(0);
                Element workScheduleElement = (Element) staffListElement.getElementsByTagName("workSchedule").item(0);

                // Get workSchedule entries
                HashMap<String, Boolean> workSchedule = new HashMap<String, Boolean>();
                NodeList workScheduleEntries = workScheduleElement.getElementsByTagName("entry");
                for (int j = 0; j < workScheduleEntries.getLength(); j++) {
                    Element entryElement = (Element) workScheduleEntries.item(j);
                    Element dateElement = (Element) entryElement.getElementsByTagName("date").item(0);
                    Element valueElement = (Element) entryElement.getElementsByTagName("value").item(0);
                    workSchedule.put(dateElement.getTextContent(), valueElement.getTextContent() == "true" ? true:false);
                }

                staff.put("username", usernameElement.getTextContent());
                staff.put("password", passwordElement.getTextContent());
                staff.put("role", roleElement.getTextContent());
                staff.put("contact", contactElement.getTextContent());
                staff.put("workSchedule", workSchedule);

                Staff newStaff = new Staff(
                    (String) staff.get("username"),
                    (String) staff.get("password"),
                    (String) staff.get("role"),
                    (String) staff.get("contact"),
                    workSchedule
                );
                
                staffList.add(newStaff);
            }

            result.put("staffList", staffList);

        }
        catch(ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 
     */
    public Authentication_GUI(){
        HashMap<String, Object> data = this.getRestaurantBYCSV();

        if(data == null){
            return;
        }
        
        restaurant = new Restaurant(
            (String) data.get("restaurntName"),
            (String) data.get("restaurntAddress"), 
            (String) data.get("restaurntPhone"),
            (ArrayList<MenuItem>) data.get("distList"),
            (ArrayList<Staff>) data.get("staffList"),
            (Inventory) data.get("inventory")
        );
        this.initializeGUI();
    }

}
