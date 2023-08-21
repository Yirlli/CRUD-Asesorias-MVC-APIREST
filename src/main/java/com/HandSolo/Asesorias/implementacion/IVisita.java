package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.VisitaTerreno;
import com.HandSolo.Asesorias.repositories.VisitaRepository;
import com.HandSolo.Asesorias.services.VisitaService;

@Service
public class IVisita implements VisitaService {

	@Autowired
	VisitaRepository repositorio;

	@Override
	public Iterable<VisitaTerreno> listAllVisita() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public VisitaTerreno geVisitaById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public VisitaTerreno saveVisita(VisitaTerreno visita) {
		// TODO Auto-generated method stub
		return repositorio.save(visita);
	}
}
