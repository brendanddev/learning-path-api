package com.brendan.springdock.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brendan.springdock.models.Skill;
import com.brendan.springdock.services.SkillService;

/**
 * Defines the REST Controller for managing Skill entities.
 * 
 * This controller defines HTTP endpoints for creating and retrieving Skills.
 * It acts as the entry point for client requests related to Skill data, and
 * delegates business logic to the SkillService.
 */
@RestController
public class SkillController {

    private final SkillService skillService;

    // Constructor-based dependency injection for the SkillService
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    /**
     * Retrieves all Skills from the system.
     * 
     * HTTP GET /skills
     * Returns a list of all Skill entities stored in the database.
     * The response contains HTTP 200 (OK) and the list of skills in JSON format.
     * 
     * @return ResponseEntity containing the list of Skills and HTTP status
     */
    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return ResponseEntity.ok(skills);
    }

    /**
     * Retrieves a Skill by its ID.
     * 
     * HTTP GET /skill/{id}
     * Returns the Skill entity with the specified ID.
     * If found, the response contains HTTP 200 (OK) and the Skill in JSON format.
     * If not found, the response contains HTTP 404 (Not Found).
     * 
     * @param id The ID of the skill to retrieve
     * @return ResponseEntity containing the Skill and HTTP status
     */
    @GetMapping("/skill/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable long id) {
        Skill skill = skillService.getSkillById(id);
        return ResponseEntity.ok(skill);
    }

    /**
     * Creates a new Skill.
     * 
     * HTTP POST /skill
     * Accepts a JSON payload with 'name', 'description', 'category', and 'difficulty' fields.
     * Returns the created Skill with a HTTP 201 status (Created).
     * 
     * @param skill The Skill object parsed from the request body
     * @return ResponseEntity containing the created Skill and HTTP status
     */
    @PostMapping("/skill")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.createSkill(skill.getName(), skill.getDescription(), skill.getCategory(), skill.getDifficulty());
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkill);
    }

    /**
     * Updates an existing Skill.
     * 
     * HTTP PUT /skill/{id}
     * Accepts a JSON payload with updated 'name', 'description', 'category', and 'difficulty' fields.
     * Returns the updated Skill with a HTTP 200 status (OK).
     * 
     * @param id The ID of the skill to update
     * @param skill The Skill object parsed from the request body
     * @return ResponseEntity containing the updated Skill and HTTP status
     */
    @PutMapping("/skill/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable long id, @RequestBody Skill skill) {
        Skill updatedSkill = skillService.updateSkill(id, skill.getName(), skill.getDescription(), skill.getCategory(), skill.getDifficulty());
        return ResponseEntity.ok(updatedSkill);
    }

    /**
     * Deletes a Skill by its ID.
     * 
     * HTTP DELETE /skill/{id}
     * Deletes the Skill entity with the specified ID.
     * Returns HTTP 204 (No Content) upon successful deletion.
     * 
     * @param id The ID of the skill to delete
     * @return ResponseEntity with HTTP status
     */
    @DeleteMapping("/skill/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
    
}
