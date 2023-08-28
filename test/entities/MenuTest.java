package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuTest {

    private Menu menu;

    /**
     * 
     * Menu constructor
     * 
     */
    public MenuTest() {
       menu = new Menu("pizza", "italy", 10.0);
    }

    /**
     * 
     * @return Menu
     * 
     */
    public Menu getMenu(){
        return this.menu;
    }

    @Test
    public void testAddIngredients() {
        double number = 1.0;
        String key = "pi";
        menu.addIngredients(key, number);
        assertEquals(menu.getUsedIngredientsbyKey(key), number, 0.01);
    }

    @Test
    public void testGetDescription() {
        assertEquals(menu.getDescription(), "italy");
    }

    @Test
    public void testGetName() {
        assertEquals(menu.getName(), "pizza");
    }

    @Test
    public void testGetPrice() {
        assertEquals(menu.getPrice(), 10.0, 0.01);
    }

    @Test
    public void testGetSumPlus() {
        assertEquals(menu.getSumPlus(), false);
    }

    @Test
    public void testGetUsedIngredients() {
        assertEquals(menu.getUsedIngredients(), null);
    }

    @Test
    public void testRemoveIngredients() {
        String key = "pi";
        menu.removeIngredients(key);
        assertEquals(menu.getUsedIngredientsbyKey(key), null);
    }

    @Test
    public void testSetDescription() {
        String str = "";
        menu.setDescription(str);
        assertEquals(menu.getDescription(), str);
    }

    @Test
    public void testSetName() {
        String str = "";
        menu.setName(str);
        assertEquals(menu.getName(), str);
    }

    @Test
    public void testSetPrice() {
        double price = 1.0;
        menu.setPrice(price);
        assertEquals(menu.getPrice(), price, 0.01);
    }

    @Test
    public void testSetSumPlus() {
        boolean b = false;
        menu.setSumPlus(false);
        assertEquals(menu.getSumPlus(), b);
    }
}
