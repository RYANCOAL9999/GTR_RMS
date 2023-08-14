/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import entities.Food;

/**
 *
 * @author W22079254
 */
public interface FoodRepository extends MongoRepository<Food, String>{
    
    @Query("{name:'?0'}")
    Food findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Food> findAll(String category);
    
    @Override
    public long count();
   
    
    
}
