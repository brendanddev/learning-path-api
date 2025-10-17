package com.brendan.springdock.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.brendan.springdock.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    
}
