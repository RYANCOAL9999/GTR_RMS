package entities;

public class Food extends MenuItem {

    private int quantity;
    private double weight;

    public Food(
        String name, 
        String description, 
        double price,
        int quantity,
        double weight
    ) {
        super(name, description, price);
        this.quantity = quantity;
        this.weight = weight;
    }

    public Food(
        String name, 
        int quantity,
        double weight
    ) {
        super(name, "", 0);
        this.quantity = quantity;
        this.weight = weight;
    }
    
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }

    public int getQuantity() {
       return this.quantity;
    }

    public void setWeight(double weight){
       this.weight = weight;
    }

    public double getWeight() {
       return this.weight;
    }








    
}
