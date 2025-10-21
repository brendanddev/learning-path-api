package com.brendan.springdock.exceptions;

/**
 * Defines a custom exception to be thrown when a bad request is made.
 * 
 * Specifically used when the client provides invalid data or parameters.
 */
public class BadRequestException extends RuntimeException {

    /**
     * Constructs a new BadRequestException with the specified detail message.
     * 
     * @param message The detail message explaining the reason for the exception
     */
    public BadRequestException(String message) {
        super(message);
    }
    
}
