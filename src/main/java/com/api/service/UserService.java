package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exception.AuthenticationException;
import com.api.exception.UserNotFoundException;
import com.api.model.User;
import com.api.repository.UserRepository;

import src.main.java.com.fdmgroup.news.service.String;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<?> findById(Integer id) throws UserNotFoundException {
		if (userRepository.existsById(id)) {
			return userRepository.findById(id);
		}
		throw new UserNotFoundException("User with ID: " + id + "not found");
	}

	public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) throws UserNotFoundException {
		if (userRepository.existsById(user.getId())) {
			return userRepository.save(user);
		}
		throw new UserNotFoundException("User with ID: " + user.getId() + " not found ");
	}

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
