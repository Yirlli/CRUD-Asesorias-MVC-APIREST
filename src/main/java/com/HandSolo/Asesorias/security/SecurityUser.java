package com.HandSolo.Asesorias.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.HandSolo.Asesorias.modelo.Usuario;


public class SecurityUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Usuario usuario;
	
	public SecurityUser(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return usuario.getRoles().stream().map(SecurityRol::new).toList();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getUsername();
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
		return true;
	}

}
