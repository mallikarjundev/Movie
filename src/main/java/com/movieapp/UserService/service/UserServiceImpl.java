package com.movieapp.UserService.service;

import com.movieapp.UserService.dto.Users;
import com.movieapp.UserService.exception.UserAlreadyExists;
import com.movieapp.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Users addUser(Users user) throws UserAlreadyExists {
        Optional<Users> checkUserName = userRepository.findById(user.getUserName());
        if (checkUserName.isPresent()) {
            throw new UserAlreadyExists("user already exists with name "+user.getUserName());
        }
        return userRepository.save(user);
    }

}
