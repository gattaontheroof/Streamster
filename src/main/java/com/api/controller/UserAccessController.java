package com.api.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.exception.UserNotFoundException;
import com.api.model.User;
import com.api.service.UserAccessService;
import com.api.service.UserService;

public class UserAccessController {
	
	@Autowired
	private UserAccessService userAccessService;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
	    // Call the login method in  userAccessService, passing the user object
	    // The login method should handle the authentication logic
	    // For example, it might return a JWT token upon successful login
	    // or throw an exception for authentication failure
	    try {
	        String token = userAccessService.login(user.getUsername(), user.getPassword());
	        // Return the token and a success status code
	        return ResponseEntity.ok(token);
	    } catch (AuthenticationException e) {
	        // Return an error status code for authentication failure
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	    }
	}


	

}


