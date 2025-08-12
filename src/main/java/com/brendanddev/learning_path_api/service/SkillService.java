package com.brendanddev.learning_path_api.service;

import java.util.List;
import java.util.Optional;
import com.brendanddev.learning_path_api.model.Skill;
import com.brendanddev.learning_path_api.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Defines the Service layer for Skill related operations.
 * 
 * Contains the business logic for managing Skill entities and interacting with the 
 * SkillRepository to perform database operations.
 */
@Service
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
     * Fetches a skill by its id (primary key).
     * 
     * @param id The unique identifier of the skill to fetch
     * @return Optional containing the Skill if found, or empty if not found
     */
    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    /**
     * Fetches a skill by its name
     * 
     * @param name The name of the skill to fetch
     * @return Optional containing the Skill if found, or empty if not found
     */
    public Optional<Skill> getSkillByName(String name) {
        return skillRepository.findByName(name);
    }

    /**
     * Creates and saves a new skill to the database.
     * If a skill with the same name already exists, it returns that skill instead of creating a new one.
     * 
     * The Transactional annotation indicates that this method runs within a database transaction.
     * A Transaction is a unit of works that either fully succeeds or fully fails, ensuring data integrity.
     * 
     * @param skill The Skill entity to create
     * @return The created Skill entity
     */
    @Transactional
    public Skill createSkill(Skill skill) {
        return skillRepository.findByName(skill.getName())
            .orElseGet(() -> skillRepository.save(skill));
    }

    /**
     * Deletes a skill by its id.
     * 
     * @param id The unique identifier of the skill to delete
     */
    @Transactional
    public void deleteSkillById(Long id) {
        skillRepository.deleteById(id);
    }

    /**
     * Deletes a skill by its name.
     * 
     * @param name The name of the skill to delete
     */
    @Transactional
    public void deleteSkillByName(String name) {
        skillRepository.findByName(name).ifPresent(skill -> skillRepository.delete(skill));
    }

    /**
     * Udates an existing Skill's details in the database.
     * 
     * @param id The unique identifier of the skill to update
     * @param updatedSkill A skill object containing the updated details
     * @return The updated Skill entity
     * @throws RuntimeException if the skill with the specified id does not exist
     */
    @Transactional
    public Skill updateSkill(Long id, Skill updatedSkill) {
        return skillRepository.findById(id)
            .map(skill -> {
                skill.setName(updatedSkill.getName());
                return skillRepository.save(skill);
            })
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
    }






    
}
