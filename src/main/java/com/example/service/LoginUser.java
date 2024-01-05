package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;

public class LoginUser implements UserDetails {
	private final User user;

	public LoginUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	@Override
	public String getUsername() {
		return this.user.getEmail();
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.user.getRole().equals("管理者")) {
			return AuthorityUtils.createAuthorityList("ADMIN", "GENERAL");
		}
		return AuthorityUtils.createAuthorityList("GENERAL");
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
