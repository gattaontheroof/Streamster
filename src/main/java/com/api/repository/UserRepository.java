package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
}



