package com.brendan.springdock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brendan.springdock.models.User;
import com.brendan.springdock.repository.UserRepository;

/**
 * Defines the Service layer for User-related operations.
 * 
 * This class acts as the intermediary between the Controller layer and the Repository layer,
 * handling business logic and data manipulation for User entities.
 */
@Service
public class UserService {

    // Repository for performing database operations on User entities
    private final UserRepository userRepository;

    /**
     * Constructor-based dependency injection for the UserRepository.
     * Spring automatically injects the repository instance when creating this service.
     * 
     * @param userRepository the UserRepository to be injected
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new User with the provided name and email, and saves it to the database.
     * 
     * @param name The name of the user
     * @param email The email of the user
     * @return The saved User entity
     */
    public User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    /**
     * Retrieves all Users from the database.
     * 
     * @return A list of all User entities
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a User by its ID.
     * 
     * @param id The ID of the user to retrieve
     * @return An Optional containing the User if found, or empty if not found
     */
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }


    public User updateUser(long id, String name, String email) { }

    public void deleteUser(long id) { }
    
}
