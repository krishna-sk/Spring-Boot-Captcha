package com.springbootsimplecaptcha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsimplecaptcha.entity.User;
import com.springbootsimplecaptcha.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void createUser(User employee) {

		userRepository.save(employee);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

}
