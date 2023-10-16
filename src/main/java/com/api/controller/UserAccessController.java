package com.api.controller;

import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.exception.UserNotFoundException;
import com.api.model.User;
import com.api.service.UserAccessService;
import com.api.service.UserService;

import jakarta.validation.Valid;

public class UserAccessController {
	
	@Autowired
	private UserService userService;
	
	
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
	
    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model) throws UserNotFoundException{
        User existingUser = userService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }

        userService.saveUser(user);
        return "redirect:/register?success";
    }

    
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws AuthenticationException {
	    String token = userService.login(user.getUsername(), user.getPassword());
		// Return the token and a success status code
		return ResponseEntity.ok(token);
	}


	

}


