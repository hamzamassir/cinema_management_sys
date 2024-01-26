package com.example.cinema.repository;

import com.example.cinema.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findFirstByUsername(String username);

    UserEntity findByEmail(String email);
}
