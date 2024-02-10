package com.movieapp.UserService.service;

import com.movieapp.UserService.dto.Users;
import com.movieapp.UserService.exception.UserAlreadyExists;

public interface UserService {
    public Users addUser(Users user) throws UserAlreadyExists;



}
