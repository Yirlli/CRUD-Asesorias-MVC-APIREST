package com.HandSolo.Asesorias.implementacion;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.security.SecurityUser;
import com.HandSolo.Asesorias.services.UsuarioService;



@Service
public class ISecurityUserDetails implements UserDetailsService{
	@Autowired
	private final UsuarioService servicio;

	
	public ISecurityUserDetails(UsuarioService servicio) {
		this.servicio = servicio;
	
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		var optUser = this.servicio.findByUsername(username);
		if(optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		
		throw new  UsernameNotFoundException("user not foun" + username);
		
		/*
		Optional<Usuario> usuarioOp = this.servicio.findByUsername(username);

		 if (usuarioOp.isPresent()) {
	    System.out.println("loadUserByUsername: Rut recibido: " +username+usuarioOp.get());
	            return new SecurityUser(usuarioOp.get());
	        }
		 System.out.println("no eoncontrado" +rut);
		throw new UsernameNotFoundException("usuario no encontrado" +username);
		/* Usuario usuario = usuarioOp.get();
		
		 List<GrantedAuthority> authorities = new ArrayList<>();
	        for (Rol roles : usuario.getRoles()) {
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getNombre().name()));
	        }
	        
	  
	      
	        return new org.springframework.security.core.userdetails.User(
	                usuario.getRut(),
	                usuario.getPassword(),
	                authorities
	                
	                
	            );*/

		/*return servicio.findByRut(rut).map(SecurityUser :: new).orElseThrow( () -> 
		new UsernameNotFoundException("usuario no encontrado" +rut)); */
	
		
		
			
	} 
	
	/*
	 @Bean
	public UserDetailsService userDetailsSerivce() {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		var admin = User.withUsername("22347643")
					.password(passwordEncoder.encode("pepe"))
					.authorities("ADMINISTRADOR")
					.build();
		var result = new InMemoryUserDetailsManager();
		result.createUser(admin);
	return result;
		
	}*/
}
