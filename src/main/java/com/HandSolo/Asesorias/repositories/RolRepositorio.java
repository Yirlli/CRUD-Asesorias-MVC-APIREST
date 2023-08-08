package com.HandSolo.Asesorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Rol;

import com.HandSolo.Asesorias.utils.RolNombre;

@Repository
public interface RolRepositorio extends CrudRepository <Rol, Integer>{

	Optional<Rol> findByNombre(RolNombre nombre);
	
	
	
}
