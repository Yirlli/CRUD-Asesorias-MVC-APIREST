package com.HandSolo.Asesorias.services;

import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Contacto;

public interface ContactoService {

	Iterable<Contacto> listAllContact();

	

	Contacto saveContact(Contacto contacto);
	

	
	public void deleteContact(Integer id);
}
