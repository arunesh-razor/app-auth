package com.atlas.auth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IAuthConfig {
	
	/*@Bean
	public UserDetailsService userDetailsService();*/
	@Bean
	public PasswordEncoder passwordEncoder();
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception;
	
}
