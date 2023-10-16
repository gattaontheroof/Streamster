package com.api.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name ="id") Integer id) {
		try {
			Optional<?> userOptional = userService.findById(id);

			return ResponseEntity.status(HttpStatus.OK).body(userOptional);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@GetMapping("/search-user-by-lastname-firstname/{lastName}/{firstName}")
	public ResponseEntity<List<User>> findByLastNameAndfirstName(@PathVariable String lastName,
			@PathVariable String firstName) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByLastNameAndFirstName(lastName, firstName));
	}

	@PostMapping("/add-user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		// return new ResponseEntity<> (userService.save(user), HttpStatus.CREATED);
	}

//	@PostMapping("/add-user")
//	public ResponseEntity<?> saveUser(@RequestBody User user) {
//		try {
//			User savedUser = userService.save(user);
//			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//		} catch (Exception ex) {
//			return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		if (userService.deleteUser(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
