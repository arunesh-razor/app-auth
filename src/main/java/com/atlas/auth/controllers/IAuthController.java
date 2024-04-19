package com.atlas.auth.controllers;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.atlas.auth.models.JWTRequest;
import com.atlas.auth.models.JWTResponse;
import com.atlas.auth.models.User;
import com.atlas.auth.models.UserResponse;

public interface IAuthController {
	
	public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request);
	public ResponseEntity<UserResponse> signup(@RequestBody User user);
	public void verify();
	public void setup2stepverification();
	public String getLoggedInUser(Principal principal);

}
