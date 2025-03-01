package com.AlphaDza.tweetApp.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AlphaDza.tweetApp.dao.UserRepository;
import com.AlphaDza.tweetApp.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository R_user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = R_user.findByUsername(username);
		
		return new CustomUserDetails(user);
	}
	
	public User getUserByUsername(String username)
	{
		return R_user.findByUsername(username);
	}
	
}
