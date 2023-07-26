package com.HandSolo.Asesorias.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.domain.Capacitacion;
import com.HandSolo.Asesorias.repositories.CapacitacionRepositorio;


@Service
public class CapacitacionImpl implements CapacitacionService{

	@Autowired
	private CapacitacionRepositorio repositorio;
	
	@Override
	public Iterable<Capacitacion> listAllCapacitacion() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Capacitacion getCapacitacionById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}
	@Override
	public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
		// TODO Auto-generated method stub
		return repositorio.save(capacitacion);
	}

	@Override
	public Capacitacion updateCapacitacion(Capacitacion capacitacion) {
		// TODO Auto-generated method stub
		return repositorio.save(capacitacion);
	}

	@Override
	public void deleteCapacitacion(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}





	

	
}
