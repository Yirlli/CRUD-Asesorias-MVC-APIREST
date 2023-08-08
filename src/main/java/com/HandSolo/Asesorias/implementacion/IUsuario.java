package com.HandSolo.Asesorias.implementacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.repositories.UsuarioRepositorio;
import com.HandSolo.Asesorias.services.UsuarioService;

@Service
public class IUsuario implements UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public Iterable<Usuario> listAllUsuario() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Usuario getUsuarioById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}

	@Override
	public void deleteUsuario(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public Optional<Usuario> findByRut(String rut) {
		// TODO Auto-generated method stub
		return repositorio.findByRut(rut);
	}

}
