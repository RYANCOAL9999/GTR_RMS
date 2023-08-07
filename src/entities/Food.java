package entities;

public class Food extends MenuItem {

    private int quantity;
    
    private double weight;
    
    private Boolean noEffect;

    /**
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }

    /**
     * 
     * @return
     */
    public int getQuantity() {
       return this.quantity;
    }

    /**
     * 
     * @param weight
     */
    public void setWeight(double weight){
       this.weight = weight;
    }

    /**
     * 
     * @return
     */
    public double getWeight() {
       return this.weight;
    }

    /**
     * 
     * @param noEffect
     */
    public void setNoEffect(Boolean noEffect) {
        this.noEffect = noEffect;
    }

    /**
     * 
     * @return
     */
    public boolean getNoEffect() {
        return this.noEffect;
    }

    /**
     * have Effect with MenuItem
     * @param name
     * @param description
     * @param price
     * @param quantity
     * @param weight
     * @param noEffect
     */
    public Food(
        String name, 
        String description, 
        double price,
        int quantity,
        double weight,
        Boolean noEffect
    ) {
        super(name, description, price);
        this.quantity = quantity;
        this.weight = weight;
        this.noEffect = noEffect;
    }
    
}
