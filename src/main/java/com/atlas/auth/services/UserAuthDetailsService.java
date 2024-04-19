package com.atlas.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atlas.auth.entities.User;
import com.atlas.auth.repositories.UserRepository;

@Service
public class UserAuthDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username).orElseThrow(() ->  new RuntimeException("User: "+username+" Not found!"));
		
		return user;
	}

}
