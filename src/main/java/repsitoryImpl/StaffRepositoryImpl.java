/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repsitoryImpl;

import com.mongodb.client.result.UpdateResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import respository.StaffRepository;

import entities.Staff;

/**
 *
 * @author W22079254
 */

@Component
public class StaffRepositoryImpl implements StaffRepository{

    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public void updateStaffContact(String name, String newContact) {
        
        Query query = new Query(Criteria.where("username").is(name));
        
        Update update = new Update();
        update.set("contact", newContact);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Staff.class);
        
        if(result == null){
            System.out.println("No documents updated");
        }
        else{
            System.out.println(result.getModifiedCount() + " document(s) updated..");
        }
    }
    
}
