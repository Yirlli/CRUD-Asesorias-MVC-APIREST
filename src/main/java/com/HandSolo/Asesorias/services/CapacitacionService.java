package com.HandSolo.Asesorias.services;



import com.HandSolo.Asesorias.modelo.Capacitacion;



public interface CapacitacionService {
	
	Iterable<Capacitacion> listAllCapacitacion();

	Capacitacion getCapacitacionById(Integer id);
	
	Capacitacion saveCapacitacion(Capacitacion capacitacion);
	
	Capacitacion updateCapacitacion(Capacitacion capacitacion);
	
	public void deleteCapacitacion(Integer id);
	
}

