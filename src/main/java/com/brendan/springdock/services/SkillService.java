package com.brendan.springdock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brendan.springdock.models.Skill;
import com.brendan.springdock.models.Skill.Difficulty;
import com.brendan.springdock.repository.SkillRepository;

/**
 * Defines the Service layer for Skill-related operations.
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
    };

    /**
     * Retrieves a Skill by its ID.
     * 
     * @param id The ID of the skill to retrieve
     * @return The Skill entity if found, otherwise null
     */
    public Skill getSkillById(long id) { 
        return skillRepository.findById(id).orElse(null);
    };

    public Skill updateSkill() { };

    public void deleteSkill(long id) { }





}
