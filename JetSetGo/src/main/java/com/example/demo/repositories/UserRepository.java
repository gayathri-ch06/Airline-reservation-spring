package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Users;



public interface UserRepository extends JpaRepository<Users, String> {

	List<Users> findByUserEmail(String userEmail);

	void deleteByUserEmail(String email);
	
	
}