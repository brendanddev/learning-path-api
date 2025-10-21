package com.brendan.springdock.exceptions;

/**
 * Defines a custom exception to be thrown when a requested resource is not found.
 * 
 * Specifically used when a User or Skill entity cannot be found.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     * 
     * @param message The detail message explaining the reason for the exception
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
}
