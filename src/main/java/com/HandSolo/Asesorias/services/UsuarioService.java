package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.domain.Usuario;

public interface UsuarioService {
	
	Iterable<Usuario> listAllUsuario();

	Usuario getUsuarioById(Integer id);
	

	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	public void deleteUsuario(Integer id);

}
