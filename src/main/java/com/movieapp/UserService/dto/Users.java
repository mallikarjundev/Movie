package com.movieapp.UserService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Users {


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Id
    @NotEmpty(message = "user name cannot be empty")
    private String userName;
    @NotEmpty(message = "full name cannot be empty")
    private String fullName;
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;
    @NotEmpty(message = "password cannot be empty")
    private String password;

}
