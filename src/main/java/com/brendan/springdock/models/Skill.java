package com.brendan.springdock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Represents an individual Skill in the system
// Fields could include: id, name, description, difficulty, category, etc.
// Relationship(s)? to User?


@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // Required no-arg constructor
    public Skill() { }

    // All-args constructor
    public Skill(String name) {
        this.name = name;
    }

    // Getters and Setters

    

    
}
