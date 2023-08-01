/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gtr_rms;

/**
 *
 * @author W22079254
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(()->{
            Restaurant_GUI gui = new Restaurant_GUI();
            gui.setVisible(true);
        });
    }
    
}
