package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class RestaurantTest {

    private Restaurant restaurant;

    /**
     * 
     * RestaurantTest constructor
     * 
     */
    public RestaurantTest(){

        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu = new MenuTest().getMenu();
        menuList.add(menu);

        ArrayList<Staff> staffList = new ArrayList<>();
        Staff staff = new StaffTest().getStaff();
        staffList.add(staff);

        restaurant = new Restaurant(
            "",
            "",
            "",
            menuList,
            staffList,
            new InventoryTest().getInventory(),
            ""
        );
    }

    /**
     * 
     * @return Restaurant
     * 
     */
    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    @Test
    public void testAddInventoryByIngredients() {
        Food food = new FoodTest().getFood();
        restaurant.addInventoryByIngredients(food);
        assertEquals(restaurant.getInventoryByIngredientsByName(food.getName()), food); 
    }

    @Test
    public void testAddMenu() {
        Menu menu = new MenuTest().getMenu();
        restaurant.addMenu(menu);
        assertEquals(restaurant.getMenu(menu.getName()), menu); 
    }

    @Test
    public void testAddOrder() {
        Order order = new OrderTest().getOrder();
        restaurant.addOrder(order.getTableNumber());
        assertEquals(restaurant.getOrder(restaurant.getOrderNumber()), order);
    }

    @Test
    public void testAddOrderNumber() {
        restaurant.addOrderNumber();
        assertEquals(restaurant.getOrderNumber(), 1);
    }

    @Test
    public void testAddStaff() {
        Staff staff = new StaffTest().getStaff();
        restaurant.addStaff(staff);
        assertEquals(restaurant.getStaff(staff.getUsername()), staff);
    }

    @Test
    public void testAddStaffWorkScheduled() {
        Staff staff = new StaffTest().getStaff();
        String name = staff.getUsername();
        String date = "25-08-2023";
        boolean b = false;
        restaurant.addStaffWorkScheduled(name, date, b);
        assertEquals(restaurant.getStaffWorkScheduled(name).get(date), b);
    }

    @Test
    public void testAddTodayWage() {
        double number = 10.0;
        restaurant.addTodayWage(10.0);
        assertEquals(restaurant.getTodayWage(), number, 0.01);
    }

    @Test
    public void testDeleteInventoryByIngredients() {
        Food food = new FoodTest().getFood();
        restaurant.deleteInventoryByIngredients(food);
        assertEquals(restaurant.getInventoryByIngredientsByName(food.getName()), null);
    }

    @Test
    public void testDeleteStaff() {
        Staff staff = new StaffTest().getStaff();
        restaurant.deleteStaff(staff.getUsername());
        assertEquals(restaurant.getStaff(staff.getUsername()), null);
    }

    @Test
    public void testDeleteStaffWorkScheduled() {
        Staff staff = new StaffTest().getStaff();
        String name = staff.getUsername();
        String date = "25-08-2023";
        restaurant.deleteStaffWorkScheduled(name, date);
        assertEquals(restaurant.getStaffWorkScheduled(name).get(date), null);
    }

    @Test
    public void testGetAddress() {
        assertEquals(restaurant.getAddress(), "");
    }

    @Test
    public void testGetAllReady() {
        assertEquals(restaurant.getAllReady(), false);
    }

    @Test
    public void testGetExportPath() {
        assertEquals(restaurant.getExportPath(), "");
    }

    @Test
    public void testGetInventory() {
        assertEquals(restaurant.getInventory(), new InventoryTest().getInventory());
    }

    @Test
    public void testGetInventoryByIngredients() {
        assertEquals(restaurant.getInventoryByIngredients(), new InventoryTest().getInventory().getIngredients());
    }

    @Test
    public void testGetMenu() {
        Menu menu = new MenuTest().getMenu();
        assertEquals(restaurant.getMenu(menu.getName()), menu);
    }

    @Test
    public void testGetMenuList() {
        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu = new MenuTest().getMenu();
        menuList.add(menu);
        assertEquals(restaurant.getMenuList(), menuList);
    }

    @Test
    public void testGetMenuReady() {
        assertEquals(restaurant.getMenuReady(), false);
    }

    @Test
    public void testGetName() {
        assertEquals(restaurant.getName(), "");
    }

    @Test
    public void testGetOrderList() {
        ArrayList<Order> orderList = new ArrayList<>();
        Order order = new OrderTest().getOrder();
        orderList.add(order);
        assertEquals(restaurant.getOrderList(), orderList);
    }

    @Test
    public void testGetOrderNumber() {
        Order order = new OrderTest().getOrder();
        assertEquals(restaurant.getOrder(order.getOrderId()), order.getOrderId());
    }

    @Test
    public void testGetPhone() {
        assertEquals(restaurant.getPhone(), "");
    }

    @Test
    public void testGetStaff() {
        Staff staff = new StaffTest().getStaff();
        assertEquals(restaurant.getStaff(staff.getUsername()), staff);
    }

    @Test
    public void testGetStaffList() {
        ArrayList<Staff> staffList = new ArrayList<>();
        Staff staff = new StaffTest().getStaff();
        staffList.add(staff);
        assertEquals(restaurant.getStaffList(), staffList);
    }

    @Test
    public void testGetStaffWorkScheduled() {
        Staff staff = new StaffTest().getStaff();
        assertEquals(restaurant.getStaffWorkScheduled(staff.getUsername()), staff.getWorkSchedule());
    }

    @Test
    public void testGetTodayWage() {
        assertEquals(restaurant.getTodayWage(), 0, 0.01);
    }

    @Test
    public void testMinusTodayWage() {
        restaurant.minusTodayWage(0);
        assertEquals(restaurant.getTodayWage(), 0, 0.01);
    }

    @Test
    public void testRemoveMenu() {
        Menu menu = new MenuTest().getMenu();
        String name = menu.getName();
        restaurant.removeMenu(name);
        assertEquals(restaurant.getMenu(name), null);
    }

    @Test
    public void testRemoveOrder() {
        Order order = new OrderTest().getOrder();
        int number = order.getOrderId();
        restaurant.removeOrder(number);
        assertEquals(restaurant.getOrder(number), null);
    }

    @Test
    public void testRemoveOrderNumber() {
        restaurant.removeOrderNumber();
        assertEquals(restaurant.getOrderNumber(), 0);
    }

    @Test
    public void testSetAddress() {
        String address = "";
        restaurant.setAddress(address);
        assertEquals(restaurant.getAddress(), address);
    }

    @Test
    public void testSetAllReady() {
        boolean b = true;
        restaurant.setAllReady(b);
        assertEquals(restaurant.getAllReady(), b);
    }

    @Test
    public void testSetMenuReady() {
        boolean b = true;
        restaurant.setMenuReady(b);
        assertEquals(restaurant.getMenuReady(), b);
    }

    @Test
    public void testSetName() {
        String name = "";
        restaurant.setName(name);
        assertEquals(restaurant.getName(), name);
    }

    @Test
    public void testSetPhone() {
        String phone = "";
        restaurant.setPhone(phone);
        assertEquals(restaurant.getPhone(), phone);
    }

    @Test
    public void testSetTodayFirstTimeLoginForAllStaff() {
        boolean b = true;
        restaurant.setTodayFirstTimeLoginForAllStaff(true);
        for(Staff staff : this.restaurant.getStaffList()){
            assertEquals(staff.getTodayFirstTimeLogin(), b);
        }
    }
}
