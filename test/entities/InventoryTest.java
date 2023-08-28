package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class InventoryTest {

    private Inventory inventory;

    /**
     * 
     * InventoryTest constructor
     * 
     */
    public InventoryTest() {
        inventory = new Inventory(
            20, 
            10, 
            30, 
            40, 
            100, 
            200, 
            15, 
            25, 
            50, 
            new ArrayList<>()
        );
    }

    /**
     * 
     * @return Inventory
     * 
     */
    public Inventory getInventory() {
        return this.inventory;
    }



    @Test
    public void testAddIngredients() {
        String name = "Tomato";
        Food original = new Food(name, "Fresh tomato", 1.5, 10, 0.1, 0.1, false, "Vegetable");
        inventory.addIngredients(original);
        assertEquals(inventory.getIngredientsByKey(name), original);
    }

    @Test
    public void testGetChairs() {
        assertEquals(inventory.getChairs(), 20);
    }

    @Test
    public void testGetChopsticks() {
        assertEquals(inventory.getChopsticks(), 100);
    }

    @Test
    public void testGetDishes() {
        assertEquals(inventory.getDishes(), 30);
    }

    @Test
    public void testGetGlasses() {
        assertEquals(inventory.getGlasses(), 40);
    }

    @Test
    public void testGetIngredients() {
        assertEquals(inventory.getIngredients(), null);
    }

    @Test
    public void testGetIngredientsByKey() {
        String name = "Tomato";
        Food original = new Food(name, "Fresh tomato", 1.5, 10, 0.1, 0.1, false, "Vegetable");
        assertEquals(inventory.getIngredientsByKey(name), original);
    }

    @Test
    public void testGetIngredientsReady() {
        assertEquals(inventory.getIngredientsReady(), false);
    }

    @Test
    public void testGetKitchenSupplies() {
        assertEquals(inventory.getKitchenSupplies(), 50);
    }

    @Test
    public void testGetNapkins() {
        assertEquals(inventory.getNapkins(), 25);
    }

    @Test
    public void testGetSpoons() {
        assertEquals(inventory.getSpoons(), 200);
    }

    @Test
    public void testGetTablecloths() {
        assertEquals(inventory.getTablecloths(), 15);
    }

    @Test
    public void testGetTables() {
        assertEquals(inventory.getTables(), 10);
    }

    @Test
    public void testRemoveIngredients() {
        Food original = new Food("Tomato", "Fresh tomato", 1.5, 10, 0.1, 0.1, false, "Vegetable");
        inventory.removeIngredients(original);
        assertEquals(inventory.getIngredients(), null);
    }

    @Test
    public void testSetChairs() {
        int number = 10;
        inventory.setChairs(number);
        assertEquals(inventory.getChairs(), number);
    }

    @Test
    public void testSetChopsticks() {
        int number = 10;
        inventory.setChopsticks(number);
        assertEquals(inventory.getChairs(), number);
    }

    @Test
    public void testSetDishes() {
        int number = 10;
        inventory.setDishes(number);
        assertEquals(inventory.getDishes(), number);
    }

    @Test
    public void testSetGlasses() {
        int number = 10;
        inventory.setGlasses(number);
        assertEquals(inventory.getGlasses(), number);
    }

    @Test
    public void testSetIngredientsReady() {
        boolean b = true;
        inventory.setIngredientsReady(b);
        assertEquals(inventory.getIngredientsReady(), b);
    }

    @Test
    public void testSetKitchenSupplies() {
        int number = 10;
        inventory.setKitchenSupplies(number);
        assertEquals(inventory.getKitchenSupplies(), number);
    }

    @Test
    public void testSetNapkin() {
        int number = 10;
        inventory.setNapkin(number);
        assertEquals(inventory.getNapkins(), number);
    }

    @Test
    public void testSetSpoons() {
        int number = 10;
        inventory.setSpoons(number);
        assertEquals(inventory.getSpoons(), number);
    }

    @Test
    public void testSetTablecloths() {
        int number = 10;
        inventory.setTablecloths(number);
        assertEquals(inventory.getTablecloths(), number);
    }

    @Test
    public void testSetTables() {
        int number = 10;
        inventory.setTables(number);
        assertEquals(inventory.getTables(), number);
    }
}
