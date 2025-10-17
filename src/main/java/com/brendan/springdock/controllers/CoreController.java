package com.brendan.springdock.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines the Core Controller for general, application-wide endpoints not specific to a domain entity.
 * 
 * In Spring Boot applications, Controllers handle HTTP requests and map them to Java methods, and return responses. 
 */
@RestController
public class CoreController {

    /**
     * Default home endpoint.
     * 
     * GET /
     * Returns a simple welcome message.
     * 
     * @return A welcome message
     */
    @GetMapping("/")
    public String home() {
        return "Welcome to SpringDock!";
    }
    
}
