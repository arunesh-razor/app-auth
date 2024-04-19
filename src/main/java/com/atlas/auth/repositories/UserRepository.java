package com.atlas.auth.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atlas.auth.entities.User;


public interface UserRepository extends JpaRepository<User, UUID>{
	
	public Optional<User> findByUserName(String userName);
	
	public Optional<User> findByEmailId(String emailId);
}
