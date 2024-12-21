package com.siyam.jobListing.Jobs.Service;

import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.JobDTO;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public ResponseEntity<User> updateUser(Long id, User user) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            user.setId(id);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public ResponseEntity<User> findById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public ResponseEntity<List<User>> getALlUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public void updateProfilePicture(Long userId, String filePath) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        user.setProfilePicture(filePath);
        userRepository.save(user); // Save the updated user
    }
}
