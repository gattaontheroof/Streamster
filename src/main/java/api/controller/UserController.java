package api.controller;

import java.util.List;

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

import api.model.User;
import api.service.UserService;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getId(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
	}
	
	@GetMapping("/searchUserByName")
	public ResponseEntity<List<User>> findByFirstNameAndLastName(@PathVariable String lastName,
			@PathVariable String firstName){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByFirstNameAndLastName(firstName, lastName));		
	}
	@PostMapping("/add-user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return new ResponseEntity<> (userService.save(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(user));
	}
	

}
