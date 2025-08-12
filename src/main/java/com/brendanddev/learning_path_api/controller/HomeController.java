package com.brendanddev.learning_path_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines the HomeController that provides a simple endpoint to check if the API is running
 */
@RestController
public class HomeController {

    /**
     * Endpoint to check if the API is up and running
     * 
     * @return A simple message indicating the API status
     */
    @GetMapping("/")
    public String home() {
        return "API up and running!";
    }
    
}
