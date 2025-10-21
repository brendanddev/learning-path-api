package com.brendan.springdock.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * The Global exception handler for the app.
 * It intercepts exceptions thrown by controllers and converts them into standardized HTTP responses
 * with appropriate status codes and JSON error bodies.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles a ResourceNotFoundException thrown when a requested resource cannot be found.
     * 
     * Converts the exception into an HTTP 404 Not Found response with a JSON body containing
     * the error details.
     * 
     * @param ex The ResourceNotFoundException instance that was thrown
     * @return ResponseEntity with HTTP 404 status and error details in the body
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, String> body = Map.of(
            "error", "Not Found",
            "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    /**
     * Handles a BadRequestException thrown when the client sends invalid data or parameters.
     * 
     * Converts the exception into a HTTP 400 Bad Request response with a JSON body containing the error 
     * type and descriptive message.
     * 
     * @param ex The BadRequestException instance that was thrown 
     * @return ResponseEntity with HTTP 400 status and error details in the body
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(BadRequestException ex) {
        Map<String, String> body = Map.of(
            "error", "Bad Request",
            "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
}