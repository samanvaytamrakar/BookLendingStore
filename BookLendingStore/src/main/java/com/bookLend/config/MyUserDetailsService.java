package com.bookLend.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookLend.Repo.LoginDetailsRepo;
import com.bookLend.entity.LoginDetails;

/**
 * for Authentication using JPA
 * @author saman
 *
 */

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	LoginDetailsRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		System.out.println("loading user");
		Optional<LoginDetails> us = repo.findByUserName(username);

		System.out.println("user  "+us.toString());
		us.orElseThrow(() -> new UsernameNotFoundException("Not found"));
		
		return us.map(MyUserDetails :: new).get();
		
	}

	
	
}
