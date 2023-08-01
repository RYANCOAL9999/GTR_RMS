/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gtr_rms;

import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    private final static String restaurntName = "";
    private final static String restaurntAddress = "";
    private final static String restaurntPhone = "";
    
    public static Restaurant restaurant;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        restaurant = new Restaurant(restaurntName, restaurntAddress, restaurntPhone);
        
        javax.swing.SwingUtilities.invokeLater(()->{
//            Table_GUI gui = new Table_GUI(restaurant);
//            gui.setVisible(true);
            Ingredients_GUI gui = new Ingredients_GUI();
            gui.setVisible(true);
        });
    }
    
}
