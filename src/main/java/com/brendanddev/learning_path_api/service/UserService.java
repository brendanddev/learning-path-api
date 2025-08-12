package com.brendanddev.learning_path_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.brendanddev.learning_path_api.model.User;
import com.brendanddev.learning_path_api.repository.SkillRepository;
import com.brendanddev.learning_path_api.repository.UserRepository;


/**
 * Defines the Service layer for User related operations
 * 
 * This layer sits between the controller and repository layers, and contains
 * the buisness related logic for User entities.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    /**
     * Constructs a new UserService with the requored repositories.
     * Uses Springs constructor based dependency injection to ensure that the service
     * always has access to the data layer components it needs.
     * 
     * @param userRepository Repository for performing CRUD operations on User entities
     * @param skillRepository Repository for performing CRUD operations on Skill entities
     */
    public UserService(UserRepository userRepository, SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    /**
     * Fetches all users from the database.
     * 
     * @return List of all User entities
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Fetches a user by their id
     * 
     * @param id The unique identifier of the user to fetch
     * @return Optional containing the User if found, or empty if not found
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Creates a new user in the database
     * 
     * @param user The User entity to create
     * @return The created User entity
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user from the database by their id
     * 
     * @param id The id of the user to delete
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Updates an existing users details in the database
     * 
     * @param id The unique identifier of the user to update
     * @param updatedUser A user object containing the updated details
     * @return The updated User entity
     * @throws RuntimeException if the user with the specified id does not exist
     */
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
            .map(user -> {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setSkills(updatedUser.getSkills());
                return userRepository.save(user);
            })
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
}
