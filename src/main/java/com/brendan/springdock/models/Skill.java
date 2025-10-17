package com.brendan.springdock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Notes:
// Represents an individual Skill in the system a User can have
// Fields could include: id, name, description, difficulty, category, etc.
// Relationship(s)? to User?

/**
 * Represents an individual Skill in the system that a User can have.
 * 
 * Mapped to the 'skills' table in the database, where each Skill has a unique ID as the
 * primary key (PK). The ID is auto-generated to ensure uniqueness. Each Skill can have 
 * a difficulty level represented by an enumerated type.
 */
@Entity
@Table(name = "skills")
public class Skill {

    // Unique identifier for each Skill
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String category;
    
    // Difficulty level of the skill
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;


    // Required no-arg constructor
    public Skill() { }

    // All-args constructor
    public Skill(String name, String description, String category, Difficulty difficulty) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
    }


    // Enum for difficulty levels
    public enum Difficulty {
        NOVICE,
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }


}
