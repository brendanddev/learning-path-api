package com.brendan.springdock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brendan.springdock.models.Skill;
import com.brendan.springdock.models.Skill.Difficulty;
import com.brendan.springdock.repository.SkillRepository;

/**
 * Defines the Service layer for Skill-related operations.
 * 
 * Acts as the intermediary between the Controller layer and the Repository layer,
 * handling business logic and data manipulation for Skill entities.
 */
@Service
public class SkillService {

    // Repository for performing database operations on Skill entities
    private final SkillRepository skillRepository;

    /**
     * Constructor-based dependency injection for the SkillRepository.
     * Spring automatically injects the repository instance when creating this service.
     * 
     * @param skillRepository the SkillRepository to be injected
     */
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * Creates a new Skill with the provided details, and saves it to the database.
     * 
     * @param name The name of the skill
     * @param description The description of the skill
     * @param category The category of the skill
     * @param difficulty The difficulty level of the skill
     * @return The saved Skill entity
     */
    public Skill createSkill(String name, String description, String category, Difficulty difficulty) {
        Skill skill = new Skill(name, description, category, difficulty);
        return skillRepository.save(skill);
    }

    /**
     * Retrieves all Skills from the database.
     * 
     * @return A list of all Skill entities
     */
    public List<Skill> getAllSkills() { 
        return skillRepository.findAll();
    }

    /**
     * Retrieves a Skill by its ID.
     * 
     * @param id The ID of the skill to retrieve
     * @return The Skill entity if found, otherwise throws RuntimeException
     * @throws RuntimeException if the Skill is not found
     */
    public Skill getSkillById(long id) { 
        return skillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
    }

    /**
     * Updates an existing Skill with the provided details.
     * 
     * @param name The new name of the skill
     * @param description The new description of the skill
     * @param category The new category of the skill
     * @param difficulty The new difficulty level of the skill
     * @return The updated Skill entity
     */
    public Skill updateSkill(long id, String name, String description, String category, Difficulty difficulty) {
        Skill skill = getSkillById(id);
        skill.setName(name);
        skill.setDescription(description);
        skill.setCategory(category);
        skill.setDifficulty(difficulty);
        return skillRepository.save(skill);
    }

    /**
     * Deletes a Skill by its ID.
     * 
     * @param id The ID of the skill to delete
     */
    public void deleteSkill(long id) { 
        Skill skill = getSkillById(id);
        skillRepository.delete(skill);
    }


}
