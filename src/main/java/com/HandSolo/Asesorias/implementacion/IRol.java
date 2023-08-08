package com.HandSolo.Asesorias.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.repositories.RolRepositorio;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.utils.RolNombre;

@Service
public class IRol implements RolService{

	@Autowired
	private RolRepositorio repositorio;

	@Override
	public Optional<Rol> findByName(RolNombre nombre) {
		// TODO Auto-generated method stub
		 return repositorio.findByNombre(nombre);
	}

	@Override
	public Optional<Rol> findByRut(String rut) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Rol> getAllRoles() {
		// TODO Auto-generated method stub
		return (List<Rol>) repositorio.findAll();
	}

	@Override
	public Rol saveRol(Rol rol) {
		// TODO Auto-generated method stub
		return repositorio.save(rol);
	}
	
	

}
