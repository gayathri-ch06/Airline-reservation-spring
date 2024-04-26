package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	// Method to add a new user
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    // Method to retrieve all users
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to retrieve a user by email
    public List<Users> getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    // Method to update an existing user
    public void updateUser(String email, Users updatedUser) {
        List<Users> existingUserOptional = userRepository.findByUserEmail(email);
        if (!existingUserOptional.isEmpty()) {
            Users existingUser = existingUserOptional.get(0);
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setMobileNumber(updatedUser.getMobileNumber());
            existingUser.setAddressLine(updatedUser.getAddressLine());
            existingUser.setCity(updatedUser.getCity());
            existingUser.setState(updatedUser.getState());
            existingUser.setZipcode(updatedUser.getZipcode());
            userRepository.save(existingUser);
        } else {
            // Handle user not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete a user by email
    public void deleteUser(String email) {
        userRepository.deleteByUserEmail(email);
    }
}