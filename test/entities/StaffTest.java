package entities;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

public class StaffTest {

    private Staff staff;

    /**
     * 
     * StaffTest constructor
     * 
     */
    public StaffTest() {
        staff = new Staff(
            "john_doe", 
            "password123", 
            "Waiter", 
            "john@example.com", 
            new HashMap<>()
        );
    }

    /**
     * 
     * @return Staff
     * 
     */
    public Staff getStaff() {
        return this.staff;
    }

    @Test
    public void testAddBackTowork() {
        staff.addBackTowork();
        assertEquals(staff.getBackTowork().get(0), new Date());
    }

    @Test
    public void testAddWorkSchedule() {
        boolean b = false;
        String date = "25-08-2023";
        staff.addWorkSchedule(date, b);
        assertEquals(staff.getWorkSchedule().get(date), b);
    }

    @Test
    public void testDeleteBackTowork() {
        staff.deleteBackTowork(new Date());
        assertEquals(staff.getBackTowork().get(0), null);
    }

    @Test
    public void testDeleteWorkSchedule() {
        String date = "25-08-2023";
        staff.deleteWorkSchedule(date);
        assertEquals(staff.getWorkSchedule().get(date), null);
    }

    @Test
    public void testGetBackTowork() {
        assertEquals(staff.getBackTowork().get(0), new Date());
    }

    @Test
    public void testGetContact() {
        assertEquals(staff.getContact(), "john@example.com");
    }

    @Test
    public void testGetPassword() {
        assertEquals(staff.getPassword(), "password123");
    }

    @Test
    public void testGetRole() {
        assertEquals(staff.getRole(), "Waiter");
    }

    @Test
    public void testGetTodayFirstTimeLogin() {
        assertEquals(staff.getTodayFirstTimeLogin(), false);
    }

    @Test
    public void testGetUsername() {
        assertEquals(staff.getUsername(), "john_doe");
    }

    @Test
    public void testGetWorkSchedule() {
        assertEquals(staff.getWorkSchedule(), null);
    }

    @Test
    public void testSetContact() {
        String str = "john@example.com";
        staff.setContact(str);
        assertEquals(staff.getContact(), str);
    }

    @Test
    public void testSetPassword() {
        String str = "john@example.com";
        staff.setPassword(str);
        assertEquals(staff.getContact(), str);
    }

    @Test
    public void testSetRole() {
        String str = "john@example.com";
        staff.setRole(str);
        assertEquals(staff.getContact(), str);
    }

    @Test
    public void testSetTodayFirstTimeLogin() {
        boolean b = true;
        staff.setTodayFirstTimeLogin(b);
        assertEquals(staff.getTodayFirstTimeLogin(), b);
    }

    @Test
    public void testSetUserName() {
        String str = "john@example.com";
        staff.setUserName(str);
        assertEquals(staff.getContact(), str);
    }
}
