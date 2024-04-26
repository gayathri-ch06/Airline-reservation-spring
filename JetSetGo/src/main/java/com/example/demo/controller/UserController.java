package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;


@RestController
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private TextEncryptor textEncryptor;
	
	
	@PostMapping("/registerUser")
	public Users register(@RequestBody Users user) {
		user.setPassword(textEncryptor.encrypt(user.getPassword()));
		return userService.addUser(user);	
	}
	
	@PostMapping("/updateUser")
	public void update(@RequestBody Users user) {
		userService.updateUser(user.getUserEmail(), user);		
	}
	
	@PostMapping("/verifyUser")
	public Users verify(@RequestBody Users user) {
		Users result = userService.getUserByEmail(user.getUserEmail()).get(0);
	
		return result;
	}
	
	@GetMapping("/getProfile") 
	public Users getProfile(String useremail) {
		Users result = userService.getUserByEmail(useremail).get(0);
		result.setPassword(textEncryptor.decrypt(result.getPassword()));
		return result;
	}

}
