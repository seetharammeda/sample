package com.satish.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.userservice.entities.User;
import com.satish.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepository;

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();

	}

	public Optional<User> getUser(long id) {
		Optional<User> user = userrepository.findById(id);

		return user;
	}

	public User createUser(User user) {

		user = userrepository.save(user);
		return user;

	}
	
	public User updateUser(long id, User user) {
		return userrepository.save(user);	
		
//		if(userrepository.findById(id).isPresent()) {
//			userrepository.save(user);			
//			//Optional<User> existingUser=userrepository.findById(id);		
//			return userrepository.findById(id);
//		}else 		
//		return userrepository.save(user);
	
	}
	
	public String  authenticateUser(long id,String uname,String password) {
		if(userrepository.findById(id).isPresent()) {
			Optional<User> existingUser=userrepository.findById(id);
			User existinguser1=existingUser.get();
			if(existinguser1.getUserName().equals(uname)&&existinguser1.getPassword().equals(password))
			return "Logged in successfully";
		}else {
			return "Please enter valid credentials";
		}
		
				
		return null;
	}
}
