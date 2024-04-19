package com.atlas.auth.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.atlas.auth.services.UserAuthDetailsService;

@Configuration
public class SecurityConfig {

	@Autowired
    private JWTAuthentication jwtAuth;
    @Autowired
    private JWTAuthenticationFilter filter;
    @Autowired
    private UserAuthDetailsService userAuthDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
        		.cors(cors->cors.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/auth/login","/auth/signup","/auth/verify/**").permitAll().anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuth))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	
    	daoAuthenticationProvider.setUserDetailsService(userAuthDetailsService);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    	
    	return daoAuthenticationProvider;
    }
    
}
