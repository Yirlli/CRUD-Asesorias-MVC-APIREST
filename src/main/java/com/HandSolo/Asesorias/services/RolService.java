package com.HandSolo.Asesorias.services;

import java.util.List;
import java.util.Optional;



import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.utils.RolNombre;


public interface RolService {

	Optional<Rol> findByName(RolNombre nombre);
	
	Optional<Rol> findByRut(String rut);
	
	List<Rol> getAllRoles();
	
	Rol saveRol(Rol rol);
	
 
}
