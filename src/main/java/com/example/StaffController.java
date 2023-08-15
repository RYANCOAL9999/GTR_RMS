/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import respository.StaffRepository;

/**
 *
 * @author W22079254
 */
@EnableMongoRepositories
public class StaffController implements CommandLineRunner{
    
    @Autowired
    StaffRepository staffRepo;
    
    public void UpdateStaffContact(String name, String newContact){
        System.out.println("Updating contact for " + name);
        staffRepo.updateStaffContact(name, newContact);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n-----------UPDATE CONTACT OF A STAFF------------------------\n");
        UpdateStaffContact("Bonny Cheese Crackers Plain", "96547236");
    }
    
}
