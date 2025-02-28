package com.example.chatApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatApp.model.User;
import com.example.chatApp.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User findOrCreateUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            user = new User(userName);
            user = userRepository.save(user);
        }
        return user;
    }
}
