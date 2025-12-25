package com.example.app.service;

import com.example.app.domain.model.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByID(UUID id) {
        return userRepository.findById(id).get();
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User updateUser(UUID id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();

            if(updatedUser.getUsername() != null) {
                userToUpdate.setUsername(updatedUser.getUsername());
            }

            if(updatedUser.getMasterPassword() != null) {
                userToUpdate.setMasterPassword(updatedUser.getMasterPassword());
            }

            if(updatedUser.getEmail() != null) {
                userToUpdate.setEmail(updatedUser.getEmail());
            }

            if(updatedUser.getCellphone() != null) {
                userToUpdate.setCellphone(updatedUser.getCellphone());
            }

            return userRepository.save(userToUpdate);
        }
        return null;
    }

    public void removeUser(UUID id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
