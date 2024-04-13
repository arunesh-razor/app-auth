package com.atlas.auth.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.atlas.auth.model.JWTRequest;
import com.atlas.auth.model.JWTResponse;

public interface IAuthController {
	
	public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request);
	public void signup();
	public void verify();
	public void setup2stepverification();
	public String getLoggedInUser(Principal principal);

}
