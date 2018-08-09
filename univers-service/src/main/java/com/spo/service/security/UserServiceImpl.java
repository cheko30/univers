package com.spo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spo.model.entity.User;
import com.spo.repository.security.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUserNAme(username);
		return new CustomerUserDetails(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
	}

}
