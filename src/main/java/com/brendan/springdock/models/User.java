package com.brendan.springdock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "users")
public class User {

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


    
}
