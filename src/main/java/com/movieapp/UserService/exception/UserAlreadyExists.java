package com.movieapp.UserService.exception;

public class UserAlreadyExists extends Exception{
    private String message;

    public UserAlreadyExists(String message){
        super(message);
    }
}
