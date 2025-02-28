package com.example.chatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chatApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}