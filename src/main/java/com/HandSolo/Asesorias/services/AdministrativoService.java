package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.modelo.Administrativo;

public interface AdministrativoService {

	Iterable<Administrativo> listAllAdministrativo();

	Administrativo getAdministrativoById(Integer id);
	

	Administrativo saveAdministrativo(Administrativo administrativo);
	
	Administrativo updateAdministrativo(Administrativo administrativo);
	
	public void deleteAdministrativo(Integer id);
}
