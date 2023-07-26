package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.domain.Capacitacion;


public interface CapacitacionService {
	
	Iterable<Capacitacion> listAllCapacitacion();
	
	//busqueda por id
	
	
	//para aplicar la busqueda indigamos el tipo de dato y el dato que estamos buscando
	Capacitacion getCapacitacionById(Integer id);
	
	
	//para guardar el producto guardarmos una instancia del objeto
	Capacitacion saveCapacitacion(Capacitacion capacitacion);
	
	Capacitacion updateCapacitacion(Capacitacion capacitacion);
	
	public void deleteCapacitacion(Integer id);
	
}

