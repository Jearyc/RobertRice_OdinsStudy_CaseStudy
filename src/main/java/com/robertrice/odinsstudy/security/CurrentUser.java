package com.robertrice.odinsstudy.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.robertrice.odinsstudy.models.User;


// used by spring security to determine current user
public class CurrentUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;
	
	public CurrentUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(user.getUserRole()));
	}

	@Override
	public String getPassword() {
		//return "{noop}" + user.getPassword(); //<-- this would be used for no encryption
		//return "{bcrypt}" + user.getPassword();
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
