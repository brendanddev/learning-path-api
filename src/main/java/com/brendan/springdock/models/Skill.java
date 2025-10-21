package com.brendan.springdock.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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

    // Set of Users associated with the Skill
    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private Set<User> users;


    // Required no-arg constructor
    public Skill() { }

    // All-args constructor
    public Skill(String name, String description, String category, Difficulty difficulty) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }

    @Override
    public String toString() {
        return "Skill{id=" + id + ", name='" + name + "', description='" + description + 
               "', difficulty=" + difficulty + ", category='" + category + "'}";
    }

    // Enum for difficulty levels
    public enum Difficulty {
        NOVICE,
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    /**
     * Checks if two Skill objects are considered equal based on their IDs.
     * 
     * @param o The other object to compare with
     * @return true if both Skill objects have the same non-zero ID, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return id != 0 && id == skill.id;
    }

    /**
     * Generates a hash code for the Skill object based on its ID.
     * 
     * @return The hash code derived from the Skill's ID
     */
    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

}
