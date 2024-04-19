package com.atlas.auth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.atlas.auth.constants.Role;

@Configuration
public class AuthConfig implements IAuthConfig {

	/*@Override
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder().
                username("razor")
                .password(passwordEncoder().encode("3068805306@Arun")).roles(Role.Admin.toString()).
                build();
        return new InMemoryUserDetailsManager(userDetails);
	} */

	
	@Override
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

}
