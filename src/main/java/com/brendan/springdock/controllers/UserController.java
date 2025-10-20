package com.brendan.springdock.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    /**
     * Retrieves a User by its ID.
     * 
     * HTTP GET /user/{id}
     * Returns the User entity with the specified ID.
     * If found, the response contains HTTP 200 (OK) and the User in JSON format.
     * If not found, the response contains HTTP 404 (Not Found).
     * 
     * @param id The ID of the User to retrieve
     * @return ResponseEntity containing the User and HTTP status
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
     * Updates an existing User.
     * 
     * HTTP PUT /user/{id}
     * Accepts a JSON payload with 'name' and 'email' fields.
     * Returns the updated User with a HTTP 200 status (OK).
     * 
     * @param id The ID of the User to update
     * @param user The User object parsed from the request body
     * @return ResponseEntity containing the updated User and HTTP status
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(user.getName(), user.getEmail());
        return ResponseEntity.ok(updatedUser);

    }


    
}
