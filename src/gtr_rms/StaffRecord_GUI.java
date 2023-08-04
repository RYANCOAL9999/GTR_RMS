package gtr_rms;

import javax.swing.JFrame;

import entities.Restaurant;

/**
 *
 * @author W22079254
 */
public class StaffRecord_GUI extends JFrame{

    private Restaurant restaurant;

    /**
     * 
     */
    private void initializeGUI() {
        /**
         * List out All staff such as chef and waiters
         * add Personal Details, contact information, roles, and work schedules
         */
        
    }

    /**
     * 
     * @param res
     */
    public StaffRecord_GUI(Restaurant res){
        this.restaurant = res;
        this.initializeGUI();
    }


}
