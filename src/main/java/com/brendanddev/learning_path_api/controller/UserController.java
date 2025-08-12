package com.brendanddev.learning_path_api.controller;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import com.brendanddev.learning_path_api.model.User;
import com.brendanddev.learning_path_api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
     * @param user The User entity to create
     * @return ResponseEntity containing the created User entity with HTTP 201 Created status,
     *         and a Location header pointing to the newly created resource
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.getId())
            .toUri();
        return ResponseEntity.created(location).body(createdUser);
    }

    /**
     * Updates an existing user in the database
     * 
     * @param id The id of the user to update
     * @param updatedUser The User entity with updated information
     * @return ResponseEntity containing the updated User entity with HTTP 200 OK status,
     *         or HTTP 404 Not Found if the user with the given id does not exist
     * @throws RuntimeException if the user with the given id does not exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

   /**
    * Deletes a user by their id
    *
    * @param id The id of the user to delete
    * @return ResponseEntity with HTTP 204 No Content status if the user was deleted,
    *         or HTTP 404 Not Found if the user with the given id does not exist
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> existingUser = userService.getUserById(id);
        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Adds a skill to an existing user 
     * 
     * @param userId The id of the user to update
     * @param skillName The name of the skill to add
     * @return ResponseEntity containing the updated User entity with HTTP 200 OK status,
     *         or HTTP 404 Not Found if the user with the given id does not exist
     * @throws RuntimeException if the user with the given id does not exist
     */
    @PostMapping("/{userId}/skills")
    public ResponseEntity<User> addSkillToUser(@PathVariable Long userId, @RequestBody String skillName) {
        try {
            User updatedUser = userService.addSkillToUser(userId, skillName);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Removes a skill from an existing user
     * 
     * @param userId The id of the user to remove the skill from
     * @param skillName The name of the skill to remove
     * @return ResponseEntity containing the updated User entity with HTTP 200 OK status,
     *         or HTTP 404 Not Found if the user with the given id does not exist
     * @throws RuntimeException if the user with the specified id does not exist
     */
    @DeleteMapping("/{userId}/skills/{skillName}")
    public ResponseEntity<User> removeSkillFromUser(@PathVariable Long userId, @PathVariable String skillName) {
        try {
            User updatedUser = userService.removeSkillFromUser(userId, skillName);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }




    
}
