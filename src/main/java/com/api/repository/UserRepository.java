package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	
	// Custom query method to find a user by username
	  User findByUsername(String username);

	List<User> findByUsernameAndPassword(String username, String password);

}



