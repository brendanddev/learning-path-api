package com.brendanddev.learning_path_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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






    
}
