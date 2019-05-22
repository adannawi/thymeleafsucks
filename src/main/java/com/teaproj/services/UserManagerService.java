package com.teaproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teaproj.models.User;
import com.teaproj.repository.UserRepository;

@Service
public class UserManagerService {
	@Autowired
	UserRepository ur;
	
	public void save(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		ur.save(user);
	}
}
