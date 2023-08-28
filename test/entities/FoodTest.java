package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodTest{

    private Food food;

    /**
     * 
     * FoodTest constructor
     * 
     */
    public FoodTest() {
        food = new Food(
            "Burger",
            "Delicious burger", 
            10.99, 
            5, 
            0.5, 
            0.5, 
            false, 
            "Fast Food"
        );
    }

    /**
     * 
     * @return Food
     * 
     */
    public Food getFood() {
        return this.food;
    }

    @Test
    public void testGetNoEffect() {
        assertEquals(food.getNoEffect(), false);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(food.getQuantity(), 5);
    }

    @Test
    public void testGetQuantityEqualToZero() {
        assertEquals(food.getQuantityEqualToZero(), false);
    }

    @Test
    public void testGetStartingWeight() {
        assertEquals(food.getStartingWeight(), 0.5, 0.01);
    }

    @Test
    public void testGetStartingWeightEqualToZero() {
        assertEquals(food.getStartingWeightEqualToZero(), false);
    }

    @Test
    public void testGetType() {
        assertEquals(food.getType(), "Fast Food");
    }

    @Test
    public void testGetTypeWithStr() {
        String str = "Fast Food";
        assertEquals(food.getTypeWithStr(str), str);
    }

    @Test
    public void testGetWeight() {
        assertEquals(food.getWeight(), 0.5, 0.01);
    }

    @Test
    public void testMinusQuantity() {
        food.minusQuantity(1);
        assertEquals(food.getQuantity(), 4);
    }

    @Test
    public void testMinusWeight() {
        food.minusWeight(0.1);
        assertEquals(food.getWeight(), 0.4, 0.01);
    }

    @Test
    public void testResSetStartingWeight() {
        food.resSetStartingWeight();
        assertEquals(food.getStartingWeight(), 0.05, 0.01);
    }

    @Test
    public void testSetNoEffect() {
        boolean noEffect = true;
        food.setNoEffect(noEffect);
        assertEquals(food.getNoEffect(), noEffect);
    }

    @Test
    public void testSetQuantity() {
        int quantity = 10;
        food.setQuantity(quantity);
        assertEquals(food.getQuantity(), quantity);
    }

    @Test
    public void testSetStartingWeight() {
        double weight = 1.0;
        food.setStartingWeight(weight);
        assertEquals(food.getStartingWeight(), weight, 0.01);
    }

    @Test
    public void testSetType() {
        String type = "ABC";
        food.setType(type);
        assertEquals(food.getType(), type);
    }

    @Test
    public void testSetWeight() {
        double weight = 1.0;
        food.setWeight(weight);
        assertEquals(food.getWeight(), weight, 0.01);
    }

}
