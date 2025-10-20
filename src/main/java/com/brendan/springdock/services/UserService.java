package com.brendan.springdock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brendan.springdock.models.Skill;
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

    // Service for performing operations related to Skills
    // Injected here so UserService can coordinate actions involving both Users and their associated Skills
    private final SkillService skillService;

    /**
     * Constructor-based dependency injection for the UserRepository.
     * Spring automatically injects the repository instance when creating this service.
     * 
     * @param userRepository the UserRepository to be injected
     */
    public UserService(UserRepository userRepository, SkillService skillService) {
        this.userRepository = userRepository;
        this.skillService = skillService;
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
     * @return The User entity if found, otherwise throws RuntimeException
     * @throws RuntimeException if the User is not found
     */
    public User getUserById(long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    /**
     * Updates an existing User with the provided details.
     * 
     * @param id The ID of the user to update
     * @param updatedUser The User object containing updated details
     * @return The updated User entity
     */
    public User updateUser(long id, User updatedUser) { 
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    /**
     * Deletes a User by its ID.
     * 
     * @param id The ID of the user to delete
     */
    public void deleteUser(long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    /**
     * Adds a Skill to a User's set of Skills.
     * 
     * @param userId The ID of the User to whom the Skill will be added
     * @param skillId The ID of the Skill to be added to the User
     */
    public void addSkillToUser(long userId, long skillId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        Skill skill = skillService.getSkillById(skillId)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + skillId));
        
        user.addSkill(skill);
        userRepository.save(user);
    }

    /**
     * Removes a Skill from a User's set of Skills.
     * 
     * @param userId The ID of the User from whom the Skill will be removed
     * @param skillId The ID of the Skill to be removed from the User
     */
    public void removeSkillFromUser(long userId, long skillId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        Skill skill = skillService.getSkillById(skillId)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + skillId));
        
        user.removeSkill(skill);
        userRepository.save(user);
    }
    
}
