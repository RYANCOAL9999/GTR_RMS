package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Staff class
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
     * Set user name with string
     * @param name String
     */
    public void setUserName(String name) {
        this.username = name;
    }

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password with string
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get role
     * @return String
     */
    public String getRole() {
        return role;
    }

    /**
     * Set role with string
     * @param role String
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get contact
     * @return String
     */
    public String getContact() {
        return contact;
    }

    /**
     * Set contact with string
     * @param contact String
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Get work schedule
     * @return HashMap
     */
    public HashMap<String, Boolean> getWorkSchedule() {
        return workSchedule;
    }

    /**
     * Add work schedule by date, and true or false
     * @param date String
     * @param b Boolean
     */
    public void addWorkSchedule(String date, Boolean b) {
        this.workSchedule.put(date, b);
    }

    /**
     * Delete work schedule by date
     * @param date String
     */
    public void deleteWorkSchedule(String date) {
        this.workSchedule.remove(date);
    }

    /**
     * Get today first time login
     * @return Boolean
     */
    public boolean getTodayFirstTimeLogin() {
        return todayFirstTimeLogin;
    }

    /**
     * Set today first time login by true or false
     * @param b Boolean
     */
    public void setTodayFirstTimeLogin(boolean b) {
        this.todayFirstTimeLogin = b;
    }

    /**
     * 
     * Add back to work by today 
     *
     */
    public void addBackTowork() {
        this.backTowork.add(new Date());
    }

    /**
     * Get back to work
     * @return Date with List
     */
    public List<Date> getBackTowork() {
        return this.backTowork;
    }

    /**
     * Delete back to work by date
     * @param date Date
     */
    public void deleteBackTowork(Date date) {
        this.backTowork.remove(date);
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
