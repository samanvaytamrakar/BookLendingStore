package com.bookLend.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookLend.entity.LoginDetails;


/**
 * for Authentication using JPA
 * @author saman
 *
 */
public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authority;

	public MyUserDetails(String username) {
		this.username = username;
	}
	
	public MyUserDetails(LoginDetails user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authority = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority :: new).collect(Collectors.toList());
	}
	
	public MyUserDetails() {
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

}
