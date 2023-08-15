/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W22079254
 */
@RestController
public class HelloController {
    
    @GetMapping("/")
    public String index() {
	return "Greetings from Spring Boot!";
    }
    
}
