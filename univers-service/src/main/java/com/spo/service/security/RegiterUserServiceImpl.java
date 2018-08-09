package com.spo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spo.model.entity.User;
import com.spo.repository.security.UserRepository;

@Service
public class RegiterUserServiceImpl implements RegiterUserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void save(String username, String password) 
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		
	}

}
