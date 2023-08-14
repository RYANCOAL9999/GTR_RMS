package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author W22079254
 */
public class Staff {

    private String username;
    private String password;
    private String role;
    private String contact;
    private HashMap<String, Boolean> workSchedule;
    private List<Date> backTowork;
    private boolean todayFirstTimeLogin;

    /**
     * Get user name
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get role
     * @return String
     */
    public String getRole() {
        return role;
    }

    /**
     * Get contact
     * @return String
     */
    public String getContact() {
        return contact;
    }

    /**
     * Get work schedule
     * @return HashMap
     */
    public HashMap<String, Boolean> getWorkSchedule() {
        return workSchedule;
    }

    /**
     * Get today first time login
     * @return Boolean
     */
    public boolean getTodayFirstTimeLogin() {
        return todayFirstTimeLogin;
    }

    /**
     * Get back to work
     * @return Date with List
     */
    public List<Date> getBackTowork() {
        return this.backTowork;
    }

    /**
     * Staff constructor
     * @param username String
     * @param password String
     * @param role String
     * @param contact String
     * @param workSchedule HashMap 
     */
    public Staff(
        String username,
        String password,
        String role,
        String contact,
        HashMap<String, Boolean> workSchedule
    ){
        this.username = username;
        this.password = password;
        this.role = role;
        this.contact = contact;
        this.workSchedule = workSchedule;
        this.todayFirstTimeLogin = false;
        this.backTowork = new ArrayList<>();
    }
    
}
