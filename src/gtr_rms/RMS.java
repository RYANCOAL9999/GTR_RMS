/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gtr_rms;

import entities.Restaurant;

/**
 * GTR_RMS start Project
 * @author W22079254
 */
public class RMS {
    
    private static final String filePath = "restaurant.json";

    private static Restaurant restaurant;

    /**
     * Project starting
     * @param args String with array
     */
    public static void main(String[] args) {
        // TODO code application logic here
        restaurant = Helper.loadRestaurantData(filePath);

        if(restaurant == null){
            System.out.println("Error Loading Cache data");
            return;
        }

        javax.swing.SwingUtilities.invokeLater(()->{
            General_GUI gui = new General_GUI(restaurant);
            gui.setVisible(true);
        });
    }    
}
