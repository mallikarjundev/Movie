package com.movieapp.UserService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movieapp.UserService.dto.UserAuth;
import com.movieapp.UserService.dto.Users;
import com.movieapp.UserService.exception.UserAlreadyExists;
import com.movieapp.UserService.producer.Producer;
import com.movieapp.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    UserAuth userAuth = new UserAuth();

    private final Producer producer;

    @Autowired
    public UserServiceImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public Users addUser(Users user) throws UserAlreadyExists, JsonProcessingException {
        Optional<Users> checkUserName = userRepository.findById(user.getUserName());
        if (checkUserName.isPresent()) {
            throw new UserAlreadyExists("user already exists with name "+user.getUserName());
        }
        userAuth.setUserName(user.getUserName());
        userAuth.setPassword(user.getPassword());
        producer.sendData(userAuth);

        return userRepository.save(user);
    }

}
