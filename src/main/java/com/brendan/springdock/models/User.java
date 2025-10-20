package com.brendan.springdock.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Represents a User in the system, and is mapped to the 'users' table in the database
 * using the Java Persistence API (JPA). Each User has a unique ID, which is used as the 
 * primary key (PK) in the database table. The ID is auto-generated to ensure uniqueness.
 */
@Entity
@Table(name = "users")
public class User {

    // Unique identifier for each User, serves as the primary key in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    
    // Set of Skills associated with the User, where each User can have multiple Skills, and each Skill can belong to multiple Users
    // The JoinTable 'user_skills' defines the join table in the database that maps Users to Skills.
    // The table will have two foreign keys, 'user_id' referencing the User's primary key, and 'skill_id' referencing the Skills primary key
    @ManyToMany
    @JoinTable(
        name = "user_skills",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;
    
    // Required no-arg constructor
    public User() { }

    // All-args constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<Skill> getSkills() { return skills; }
    public void setSkills(Set<Skill> skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }

    // Helpers

    public void addSkill(Skill skill) {
        if (this.skills == null) this.skills = new HashSet<>();
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        if (this.skills != null) this.skills.remove(skill);
    }

}
