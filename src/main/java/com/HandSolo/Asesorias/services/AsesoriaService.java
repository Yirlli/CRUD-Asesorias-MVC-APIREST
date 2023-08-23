package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.modelo.Asesorias;

public interface AsesoriaService {

	Iterable<Asesorias> findAllAsesorias();
	
	Asesorias getAsesoriaById(Integer id);
	
	Asesorias saveAsesoria(Asesorias asesorias);
}
