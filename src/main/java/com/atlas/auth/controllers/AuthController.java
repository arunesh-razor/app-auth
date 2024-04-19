package com.atlas.auth.controllers;

import java.security.Principal;

import com.atlas.auth.models.*;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlas.auth.configs.JWTHelper;
import com.atlas.auth.services.UserAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController implements IAuthController {
	
	Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTHelper helper;
    
    @Autowired
    private UserAuthService userAuthService;

	@Override
	@PostMapping("/login")
	public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {
		doAuthenticate(request.getUsername(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = helper.generateToken(userDetails);

        JWTResponse response = new JWTResponse.Builder()
                .setJwtToken(token)
                .setUserName(userDetails.getUsername()).build();
        log.info("Generated jwt token : "+token);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signup(@RequestBody User user) {
		ResponseEntity<UserResponse> rsp = null;
		UserResponse response = new UserResponse();
		DbOperationStatus res = userAuthService.addUser(user);
		if (res.isStatus()) {
			log.info("Signup Sucessfull.");
			response.setMessage("User Registered Sucessfully");
			response.setData("{\"status\": true}");
			rsp = new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		} else if(res.getMessage().toLowerCase().contains("duplicate")){
			log.info("Duplicate User : "+user.getEmailId());
			response.setMessage("User Registration failed!");
			response.setData("Duplicate User : "+user.getEmailId());
			
			rsp = new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
		} else {
			log.info("Signup Failed!");
			response.setMessage("User Registration failed!");
			response.setData(res.getMessage());

			rsp = new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		return rsp;
	}

	@Override
	@GetMapping("/verify")
	public void verify() {
		log.info("Verify Sucessfull.");

	}

	@Override
	@GetMapping("/setup2step")
	public void setup2stepverification() {
		log.info("Setup 2 Step Sucessfull.");

	}

	@Override
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
		
	}
	
	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
