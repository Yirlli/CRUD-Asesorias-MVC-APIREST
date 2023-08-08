package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.modelo.Profesional;

public interface ProfesionalService {

	Iterable<Profesional> listAllUsuario();

	Profesional getProfesionalById(Integer id);
	

	Profesional saveProfesional(Profesional profesional);
	
	Profesional updateProfesional(Profesional profesional);
	
	public void deleteProfesional(Integer id);
}
