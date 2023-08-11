package gtr_rms;

import java.awt.BorderLayout;

/**
 *
 * @author W22079254
 */
public class Helper {

    /**
     * Check string is number 
     * @param str
     * @return
     */
    public static Boolean checkStringIsNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * Get box constraints is west, center, or east.
     * @param i
     * @param number
     * @return
     */
    public static String getCheckBoxConstraints(int i, int number){
        return i % number == 0 ? BorderLayout.WEST : i % number == 1 ? BorderLayout.CENTER : BorderLayout.EAST;
    }

}
