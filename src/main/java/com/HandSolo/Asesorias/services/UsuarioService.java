package com.HandSolo.Asesorias.services;


import java.util.Optional;

import com.HandSolo.Asesorias.modelo.Usuario;

public interface UsuarioService {

	Iterable<Usuario> listAllUsuario();

	Usuario getUsuarioById(Integer id);
	

	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	public void deleteUsuario(Integer id);
	
	/*Optional<Usuario> findByRut(String rut);*/
	
	Optional<Usuario> findByUsername(String username);

}
