package com.brendan.springdock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }


    
}
