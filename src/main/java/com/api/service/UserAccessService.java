package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.exception.AuthenticationException;
import com.api.model.User;
import com.api.repository.UserRepository;

public class UserAccessService {

	@Autowired
	private final UserRepository userRepository;

	public List<User> login(String username, String password) throws AuthenticationException {
		// Retrieve the user by username
		User user = userRepository.findByUsername(username);

		// Check if the user exists
		if (user == null) {
			throw new AuthenticationException("User not found");
		}
		// Check if the provided password matches the user's password
		if (!password.equals(user.getPassword())) {
			throw new AuthenticationException("Incorrect password");
		}
		// a method to generate a JWT token
//		String token = generateJwtToken(user);

//		return token;
		return this.userRepository.findByUsernameAndPassword(username, password);
	}

}
