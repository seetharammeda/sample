package com.satish.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satish.userservice.entities.User;
import com.satish.userservice.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
		
	@GetMapping("/helloworld")
	public String firstController() {
		return "Hello World";
	}
			
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		
		return userService.findAllUsers();
	}

	@GetMapping("/getuser/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		
		return userService.getUser(id);
	}	
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		
		return userService.updateUser(id,user);
	}
	
	@GetMapping("/authenticateUser/{id}/{username}/{password}")
	public String authenticateUser(@PathVariable long id,@PathVariable String name,@PathVariable String password) {
		System.out.println(id + ""+name+""+password);
		return userService.authenticateUser(id, name, password);
	}
	
}
