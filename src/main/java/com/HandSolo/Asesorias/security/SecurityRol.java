package com.HandSolo.Asesorias.security;

import org.springframework.security.core.GrantedAuthority;

import com.HandSolo.Asesorias.modelo.Rol;

public class SecurityRol implements GrantedAuthority {

	private final Rol rol;
	
	public SecurityRol(Rol rol) {
		this.rol = rol;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return rol.getNombre().toString();
	}

}
