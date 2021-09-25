package com.springbootsimplecaptcha.service;

import java.util.List;
import java.util.Optional;

import com.springbootsimplecaptcha.entity.User;

public interface UserService {
	
	void createUser(User employee);
	
	List<User> getAllUsers();
	
	Optional<User> getUserById(Integer id);
	
}
