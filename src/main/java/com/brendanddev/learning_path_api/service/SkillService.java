package com.brendanddev.learning_path_api.service;

import java.util.List;
import java.util.Optional;
import com.brendanddev.learning_path_api.model.Skill;
import com.brendanddev.learning_path_api.repository.SkillRepository;

import jakarta.transaction.Transactional;

/**
 * Defines the Service layer for Skill related operations.
 * 
 * Contains the business logic for managing Skill entities and interacting with the 
 * SkillRepository to perform database operations.
 */
public class SkillService {

    private final SkillRepository skillRepository;

    /**
     * Constructor based dependency injection for SkillService.
     * 
     * @param skillRepository Repository for performing CRUD operations on Skill entities
     */
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * Fetches all skills from the database.
     * 
     * @return List of all Skill entities
     */
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    /**
     * Fetches a skill by its name (primary key).
     * 
     * @param name The name of the skill to fetch
     * @return Optional containing the Skill if found, or empty if not found
     */
    public Optional<Skill> getSkillByName(String name) {
        return skillRepository.findById(name);
    }

    /**
     * Creates and saves a new skill to the database.
     * 
     * The Transactional annotation indicates that this method runs within a database transaction.
     * A Transaction is a unit of works that either fully succeeds or fully fails, ensuring data integrity.
     * 
     * @param skill The Skill entity to create
     * @return The created Skill entity
     */
    @Transactional
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    /**
     * Deletes a skill by its name
     * 
     * @param name The name of the skill to delete
     */
    @Transactional
    public void deleteSkill(String name) {
        skillRepository.deleteById(name);
    }






    
}
