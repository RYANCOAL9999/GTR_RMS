/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gtr_rms;

/**
 * GTR_RMS start Project
 * @author W22079254
 */
public class RMS {
    
    /**
     * Project starting
     * @param args String with array
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(()->{
            Authentication_GUI gui = new Authentication_GUI();
            gui.setVisible(true);
        });
    }    
}
