package com.movieapp.UserService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movieapp.UserService.dto.Users;
import com.movieapp.UserService.exception.UserAlreadyExists;

public interface UserService {
    public Users addUser(Users user) throws UserAlreadyExists, JsonProcessingException;



}
