package com.brendanddev.learning_path_api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brendanddev.learning_path_api.model.User;
import com.brendanddev.learning_path_api.service.UserService;

/**
 * Defines the REST controller that handles HTTP requests related to User entities.
 * 
 * This controller provides endpoints for creating, retrieving, updating, and deleting users,
 * aswell as managing their associated skills.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection for UserController
     * 
     * @param userService Service for handling user-related operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Fetches all users from the database
     * 
     * @return List of all User entities
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Fetches a user by their id
     * 
     * @param id The unique identifier of the user to fetch
     * @return ResponseEntity containing the User if found, or HTTP 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        // If user is found, return it with HTTP 200 OK, otherwise return HTTP 404 Not Found
        return user.map(u -> ResponseEntity.ok().body(u))
                   .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new user in the database
     * 
     * @param user The User entity to be created
     * @return ResponseEntity containing the created User entity with HTTP 201 Created status
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        
    }







    
}
