package com.HandSolo.Asesorias.implementacion;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.security.SecurityUser;
import com.HandSolo.Asesorias.services.UsuarioService;



@Service
public class ISecurityUserDetails implements UserDetailsService{

	private final UsuarioService servicio;
	
	public ISecurityUserDetails(UsuarioService servicio) {
		this.servicio = servicio;
	}
	

	@Override
	public UserDetails loadUserByUsername(String rut) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = servicio.findByRut(rut)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + rut));

		return new SecurityUser(usuario);
	} 
}
