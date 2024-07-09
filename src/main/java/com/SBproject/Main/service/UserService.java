package com.SBproject.Main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBproject.Main.model.User;
import com.SBproject.Main.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public List<User>  getUsers() {
		List<User> users = repository.findAll();
		return users;
	}
	public User  getUser(Long id) {
		User user = repository.findById(id).orElse(null);
		return user;		
	}
	public User saveUser(User user) {
		 user  =repository.save(user);
	return user;
	}
	public User updateUser(User user) {
		Optional<User> u = repository.findById(user.getId());
		if (u.isPresent()) {
			u.get().setEmail(user.getEmail());
			u.get().setUsername(user.getUsername());
			u.get().setItems(user.getItems());
			user = repository.save(user);
		return user;
		}
		return null;
	}
	
	
}
