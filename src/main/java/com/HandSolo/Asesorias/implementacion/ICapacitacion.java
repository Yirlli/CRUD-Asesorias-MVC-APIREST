package com.HandSolo.Asesorias.implementacion;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Capacitacion;
import com.HandSolo.Asesorias.repositories.CapacitacionRepositorio;
import com.HandSolo.Asesorias.services.CapacitacionService;


@Service
public class ICapacitacion implements CapacitacionService{

	private static final Logger logger = LoggerFactory.getLogger(ICapacitacion.class);

	@Autowired
	private CapacitacionRepositorio repositorio;
	
	@Override
	public Iterable<Capacitacion> listAllCapacitacion() {
		// TODO Auto-generated method stub
		 logger.info("Despliegue lista de capacitaciones");
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
		 logger.info("Capacitacion creada satisfactoriamente");
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
