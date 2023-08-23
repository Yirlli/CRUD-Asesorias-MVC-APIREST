package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Asesorias;
import com.HandSolo.Asesorias.repositories.AsesoriaRepositorio;
import com.HandSolo.Asesorias.services.AsesoriaService;

@Service
public class IAsesoria implements AsesoriaService {

	@Autowired
	AsesoriaRepositorio asesoriaRepo;

	@Override
	public Iterable<Asesorias> findAllAsesorias() {
		// TODO Auto-generated method stub
		return asesoriaRepo.findAll();
	}

	@Override
	public Asesorias getAsesoriaById(Integer id) {
		// TODO Auto-generated method stub
		return asesoriaRepo.findById(id).get();
	}

	@Override
	public Asesorias saveAsesoria(Asesorias asesorias) {
		// TODO Auto-generated method stub
		return asesoriaRepo.save(asesorias);
	}
}
