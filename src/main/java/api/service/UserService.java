package api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.User;
import api.repository.UserRepository;

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

	public Optional<?> findById(int id) {
		return userRepository.findById(id);
	}

	public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		if (userRepository.existsById(user.getId())) {
		return userRepository.save(user);
		}
		return null;	
	}
}

