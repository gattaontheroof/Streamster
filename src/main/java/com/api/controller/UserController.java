package com.api.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.exception.UserNotFoundException;
import com.api.model.User;
import com.api.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all-users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getId(@PathVariable Integer id) {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
//	    } catch (UserNotFoundException e) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//	    }
//	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
	    try {
	        Optional<?> user = userService.findById(id);
	        return ResponseEntity.status(HttpStatus.OK).body(user);
	    } catch (UserNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
	}

	@GetMapping("/searchUserByName/{lastName}/{firstName}")
	public ResponseEntity<List<User>> findByFirstNameAndLastName(@PathVariable String lastName,
			@PathVariable String firstName){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByFirstNameAndLastName(firstName, lastName));		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
	    // Call the login method in your userService, passing the user object
	    // The login method should handle the authentication logic
	    // For example, it might return a JWT token upon successful login
	    // or throw an exception for authentication failure
	    try {
	        String token = userService.login(user.getUsername(), user.getPassword());
	        // Return the token and a success status code
	        return ResponseEntity.ok(token);
	    } catch (AuthenticationException e) {
	        // Return an error status code for authentication failure
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	    }
	}

	@PostMapping("/add-user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return new ResponseEntity<> (userService.save(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.updateUser(user));
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
