package com.mpattt.domain.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mpattt.domain.entity.Role;
import com.mpattt.domain.entity.User;

public class MyUserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;

	public MyUserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

	// Get registered password
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	// judge if account is within expiration date
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// judge if account is locked or not
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// judge credentials are within expiration date
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// judge if account is enabled or not
	@Override
	public boolean isEnabled() {
		return true;
	}
}