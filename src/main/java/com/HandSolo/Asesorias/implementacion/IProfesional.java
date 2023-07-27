package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.domain.Profesional;
import com.HandSolo.Asesorias.repositories.ProfesionalRepositorio;
import com.HandSolo.Asesorias.services.ProfesionalService;

@Service
public class IProfesional implements ProfesionalService{
	
	@Autowired
	private ProfesionalRepositorio repositorio;

	@Override
	public Iterable<Profesional> listAllUsuario() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Profesional getProfesionalById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Profesional saveProfesional(Profesional profesional) {
		// TODO Auto-generated method stub
		return repositorio.save(profesional);
	}

	@Override
	public Profesional updateProfesional(Profesional profesional) {
		// TODO Auto-generated method stub
		return repositorio.save(profesional);
	}

	@Override
	public void deleteProfesional(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}
	
	

}
