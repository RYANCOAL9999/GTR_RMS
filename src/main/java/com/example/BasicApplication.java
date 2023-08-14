package com.example;

/**
 *
 * https://www.mongodb.com/compatibility/spring-boot
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import entities.Food;
import java.util.List;

import respository.FoodRepository;

@SpringBootApplication
@EnableMongoRepositories
public class BasicApplication implements CommandLineRunner{
    
    @Autowired
    FoodRepository foodRepo; 
    
    /**
     * 
     * get Food
     * 
     */
    private String getFoodDetails(Food item) {
        System.out.println(
            "Item Name: " + item.getName() + 
            ", \nQuantity: " + item.getQuantity() +
            ", \nItem Category: " + item.getType()
        );
        
        return "";
    }
    
    /**
     * 
     * createFood
     * 
     */
    public void createFood(){
        System.out.println("Data creation started...");
        foodRepo.save(
            new Food(
                "rice",
                "",
                0.0,
                10,
                10,
                10,
                true,
                "plant"
            )   
        );
        
        System.out.println("Data creation complete...");
    }
    
    /**
     * 
     * 1. Show all the data
     * 
     */
    public void showAllFood() {
        foodRepo.findAll().forEach(item -> System.out.println(getFoodDetails(item)));
    }
    
    /**
     * 
     * 2.Get item by name
     * @param name
     */
    public void getFoodByName(String name) {
        System.out.println("Getting item by name: " + name);
        Food item = foodRepo.findItemByName(name);
        System.out.println(getFoodDetails(item));
    }
    
    /**
     * 
     *  3.Get name and quantity of a all items of a particular category
     * @param category
     */
    public void getFoodByType(String category) {
        System.out.println("Getting items for the category " + category);
        List<Food> list = foodRepo.findAll(category);
        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }
    
    /**
     * 
     * 4. Get count of documents in the collection
     * 
     */
    public void findCountOfFood() {
        long count = foodRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }
    
    /**
     * 
     * update Type with name
     * @param type
     */
    public void updateTypeName(String type) {
         
        // Change to this new value
        // String newCategory = "munchies";
         
        // Find all the items with the category snacks
        List<Food> list = foodRepo.findAll(type);
         
        list.forEach(item -> {
            // Update the category in each document
            item.setType(type);
        });
         
         // Save all the items in database
        List<Food> itemsUpdated = foodRepo.saveAll(list);
         
        if(itemsUpdated != null){
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
        }
    }
    
    public void deleteFood(String id){
        foodRepo.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
         
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------CREATE Food -------------------------------\n");
        
        createFood();
        
        System.out.println("\n----------------SHOW ALL Food---------------------------\n");
        
        showAllFood();
        
        System.out.println("\n--------------GET Food BY NAME-----------------------------------\n");
        
        getFoodByName("Whole Wheat Biscuit");
        
        System.out.println("\n-----------GET Food BY TYPE---------------------------------\n");
        
        getFoodByType("millets");
    
        System.out.println("\n-----------UPDATE TYPE NAME OF SNACKS FOOD----------------\n");
        
        updateTypeName("snacks");    
                
        System.out.println("\n----------DELETE A FOOD----------------------------------\n");
        
        deleteFood("Kodo Millet");
        
        System.out.println("\n------------FINAL COUNT OF FOOD-------------------------\n");
        
        findCountOfFood();
        
        System.out.println("\n-------------------THANK YOU---------------------------");
    }
    

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
    
}
