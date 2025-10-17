package com.brendan.springdock.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brendan.springdock.models.User;
import com.brendan.springdock.services.UserService;

/**
 * Defines the REST Controller for managing User entities.
 */
@RestController
public class UserController {

    private final UserService userService;
    
    // Constructor-based dependency injection for the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new User.
     * 
     * HTTP POST /user
     * Accepts a JSON payload with 'name' and 'email' fields.
     * Returns the created User with a HTTP 201 status (Created).
     * 
     * @param user The User object parsed from the request body
     * @return ResponseEntity containing the created User and HTTP status
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user.getName(), user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    
}
