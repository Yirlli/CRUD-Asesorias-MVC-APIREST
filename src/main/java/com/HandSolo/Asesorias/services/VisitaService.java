package com.HandSolo.Asesorias.services;


import com.HandSolo.Asesorias.modelo.VisitaTerreno;

public interface VisitaService {

	
	Iterable<VisitaTerreno> listAllVisita();

	VisitaTerreno geVisitaById(Integer id);
	

	VisitaTerreno saveVisita(VisitaTerreno visita);
}
