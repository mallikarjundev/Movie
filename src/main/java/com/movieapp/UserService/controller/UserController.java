package com.movieapp.UserService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movieapp.UserService.dto.Users;
import com.movieapp.UserService.exception.UserAlreadyExists;
import com.movieapp.UserService.service.UserService;
import com.movieapp.UserService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movieapp")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody Users users) {
        Users userDetails = null;
        try {
            userDetails = userService.addUser(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
        } catch (UserAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
