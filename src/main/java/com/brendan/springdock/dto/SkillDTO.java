package com.brendan.springdock.dto;

import com.brendan.springdock.models.Skill.Difficulty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Defines a Data Transfer Object (DTO) for Skill entities.
 */
public class SkillDTO {

    @NotBlank(message = "Skill name cannot be empty.")
    private String name;

    @NotBlank(message = "Skill description cannot be empty.")
    private String description;

    @NotBlank(message = "Skill category cannot be empty.")
    private String category;

    @NotNull(message = "Skill difficulty cannot be null.")
    private Difficulty difficulty;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    
}