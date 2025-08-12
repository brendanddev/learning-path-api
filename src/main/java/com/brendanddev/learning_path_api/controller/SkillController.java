package com.brendanddev.learning_path_api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.brendanddev.learning_path_api.model.Skill;
import com.brendanddev.learning_path_api.service.SkillService;

/**
 * Defines the REST controller that handles HTTP requests related to Skill entities.
 * 
 * This controller provides endpoints for creating, retrieving, updating, and deleting skills,
 * as well as managing their associations with users.
 */
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    // Service for handling skill related operations
    private final SkillService skillService;

    /**
     * Constructor injection for SkillController
     * 
     * @param skillService Service for handling skill-related operations
     */
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    /**
     * Fetches all skills from the database
     * 
     * @return List of all Skill entities
     */
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    /**
     * Fetches a skill by its id
     * 
     * @param id The id of the skill to fetch
     * @return ResponseEntity containing the Skill if found, or HTTP 404 Not Found if not found 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Optional<Skill> skill = skillService.getSkillById(id);
        return skill.map(s -> ResponseEntity.ok().body(s))
                    .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new skill in the database
     * 
     * @param skill The Skill entity to be created
     * @return ResponseEntity containing the created Skill entity with HTTP 201 Created status
     */
    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill createdSkill = skillService.createSkill(skill);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdSkill.getId())
            .toUri();
        return ResponseEntity.created(location).body(createdSkill);
    }

    /**
     * Updates an existing skill in the database
     * 
     * @param id The id of the skill to update
     * @param updatedSkill The Skill entity with updated information
     * @return ResponseEntity containing the updated Skill entity with HTTP 200 OK status,
     *         or HTTP 404 Not Found if the skill with the given id does not exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill updatedSkill) {
        try {
            Skill skill = skillService.updateSkill(id, updatedSkill);
            return ResponseEntity.ok(skill);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a skill from the database by its id
     * 
     * @param id The id of the skill to delete
     * @return ResponseEntity with HTTP 204 No Content status if deletion was successful,
     *         or HTTP 404 Not Found if the skill with the given id does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        Optional<Skill> existingSkill = skillService.getSkillById(id);
        if (existingSkill.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        skillService.deleteSkillById(id);
        return ResponseEntity.noContent().build();
    }
    
}
