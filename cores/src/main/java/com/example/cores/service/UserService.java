package com.example.cores.service;

import com.example.cores.model.User;
import com.example.cores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Find a user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // Delete a user by id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
