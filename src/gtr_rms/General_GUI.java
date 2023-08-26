package gtr_rms;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Restaurant;

/**
 * General_GUI class 
 * @author W22079254
 */
public class General_GUI extends JFrame{

    private Restaurant restaurant;

    /**
     * 
     * call the date GeneralAuthenication Event
     * 
     */
    private void generalEvent(){
        Authentication_GUI gui = new Authentication_GUI(restaurant);
        gui.setVisible(true);
    }

    /**
     * 
     * Create the General_GUI
     * 
     */
    private void initializeGUI(){

        // GUI Components
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel tablePanel_Center = new JPanel(new BorderLayout());

        //Center
        JButton GeneralButton = new JButton("General");

        tablePanel_Center.add(GeneralButton, BorderLayout.CENTER);

        // Action Listeners
        GeneralButton.addActionListener(e -> generalEvent());    

        // Set up the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    /**
     * 
     * General_GUI constructor
     * 
     */
    public General_GUI(Restaurant res){
        super("Restaurant Management System General");
        this.restaurant = res;
        this.initializeGUI();
    }
    
}
