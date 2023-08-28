package gtr_rms;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import entities.RestaurantTest;
import entities.Staff;

public class Authentication_GUITest {

    private Authentication_GUI gui;

    public Authentication_GUITest(){
        gui = new Authentication_GUI(new RestaurantTest().getRestaurant());
    }

    @Test
    public void testGetUser() {
        String username = "john_doe";
        String password = "password123";
        Staff staff = gui.getUser(username, password);
        assertEquals(staff.getUsername(), username);
        assertEquals(staff.getPassword(), password);
    }
}
