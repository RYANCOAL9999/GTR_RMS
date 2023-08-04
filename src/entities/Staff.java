package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Staff {

    private String username;
    private String password;
    private String role;
    private String contact;
    private List<Date> workSchedule;
    private List<Date> backTowork;
    private boolean todayFirstTimeLogin;

    /**
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param name
     */
    public void setUserName(String name) {
        this.username = name;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param name
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * 
     * @param name
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 
     * @return
     */
    public String getContact() {
        return contact;
    }

    /**
     * 
     * @param name
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 
     * @return
     */
    public List<Date> getWorkSchedule() {
        return workSchedule;
    }

    /**
     * 
     * @param name
     */
    public void addWorkSchedule(Date date) {
        this.workSchedule.add(date);
    }

    /**
     * 
     * @param name
     */
    public void deleteWorkSchedule(Date date) {
        this.workSchedule.remove(date);
    }

    /**
     * 
     * @return
     */
    public boolean getTodayFirstTimeLogin() {
        return todayFirstTimeLogin;
    }

    /**
     * 
     * @param b
     */
    public void setTodayFirstTimeLogin(boolean b) {
        this.todayFirstTimeLogin = b;
    }

    /**
     * 
     */
    public void addBackTowork() {
        this.backTowork.add(new Date());
    }

    /**
     * 
     * @return
     */
    public List<Date> getBackTowork() {
        return this.backTowork;
    }

    /**
     * 
     * @param date
     */
    public void deleteBackTowork(Date date) {
        this.backTowork.remove(date);
    }

    public Staff(
        String username,
        String password,
        String role,
        String contact
    ){
        this.username = username;
        this.password = password;
        this.role = role;
        this.contact = contact;
        this.workSchedule = new ArrayList<Date>();
        this.todayFirstTimeLogin = false;
        this.backTowork = new ArrayList<Date>();
    }
    
}
