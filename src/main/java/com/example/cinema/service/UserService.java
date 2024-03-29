package com.example.cinema.service;

import com.example.cinema.dto.RegistrationDto;
import com.example.cinema.models.UserEntity;

public interface UserService {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    void saveUser(RegistrationDto user);
}
