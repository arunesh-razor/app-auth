package com.atlas.auth.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atlas.auth.models.DbOperationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atlas.auth.models.User;
import com.atlas.auth.repositories.UserRepository;
import com.atlas.auth.utils.ObjectConverters;

@Service
public class UserAuthService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ObjectConverters objectConverters;

	private Logger log = LoggerFactory.getLogger(UserAuthService.class);
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
		userRepository.findAll().stream().forEach((user) -> {users.add(objectConverters.mapUserDaoObjectToRequest(user));});
		
		return users;
	}
	
	public DbOperationStatus addUser(User user) {
		DbOperationStatus status = new DbOperationStatus();
		 if (userRepository.findByEmailId(user.getEmailId()).isEmpty()){
			 com.atlas.auth.entities.User userDao = objectConverters.mapUserRequestObjectToDao(user);
			 userDao.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
			 try {
				 userRepository.save(userDao);
				 status.setStatus(true);
				 status.setMessage("Success");
				 return status;
			 } catch(Exception ex){
				 log.error("Error saving new user : "+ex.getMessage());
				 status.setStatus(false);
				 status.setMessage("Error : "+ex.getMessage());
				 return status;
			 }
		 } else {
			 status.setStatus(false);
			 status.setMessage("Duplicate");
			 return status;
		 }
	}

}
