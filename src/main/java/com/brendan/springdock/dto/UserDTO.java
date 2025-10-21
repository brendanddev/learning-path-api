package com.brendan.springdock.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Defines a Data Transfer Object (DTO) for User entities.
 * 
 * Represents the data required to create or update a User through the API.
 * It is separate from the actual User entity to prevent exposing any internal database
 * structure or relationships directly to API clients, and to allow for input validation.
 * 
 * Fields in this DTO correspond to the essential information needed for creating/updating a user.
 */
public class UserDTO {

    // Name of the user, validated to be non blank
    @NotBlank(message = "User name cannot be empty.")
    private String name;

    // Email of the user, validated to be non blank and in proper email format
    @NotBlank(message = "User email cannot be empty.")
    @Email(message = "Invalid email format.")
    private String email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    
}
    