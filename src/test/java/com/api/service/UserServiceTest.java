package com.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.exception.UserNotFoundException;
import com.api.model.Subscription;
import com.api.model.User;
import com.api.repository.UserRepository;
import com.api.service.UserService;

@SpringBootTest

public class UserServiceTest {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void testGetUserById_ReturnsUserObject_IfIdExists() throws UserNotFoundException {
		// Arrange
		int id = 1357;
		User mockUser = new User(id, "John", "Smith", "jsmith@email.com");

		when(userRepository.findById(id)).thenReturn(Optional.of(mockUser));

		// Act
		Optional<User> userOptional = (Optional<User>) userService.findById(id);

		// check if Optional contains a User
		if (userOptional.isPresent()) {
			User retrievedUser = userOptional.get();

			// Assert

			assertNotNull(retrievedUser);
			assertEquals(id, retrievedUser.getId());
			assertEquals("John", retrievedUser.getFirstName());
			assertEquals("Smith", retrievedUser.getLastName());
			assertEquals("jsmith@email.com", retrievedUser.getEmail());

			// Verify that userRepository.findById was called with the expected argument
			verify(userRepository).findById(id);
		} else {
			// Throw a custom exception when the User is not found
			throw new UserNotFoundException("User with ID: " + id + "not found");
		}
	}
}
