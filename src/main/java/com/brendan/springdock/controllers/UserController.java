package com.brendan.springdock.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * Retrieves all Users from the system.
     * 
     * HTTP GET /users
     * Returns a list of all User entities stored in the database.
     * The response contains HTTP 200 (OK) and the list of users in JSON format.
     * 
     * @return ResponseEntity containing the list of Users and HTTP status
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    
}
