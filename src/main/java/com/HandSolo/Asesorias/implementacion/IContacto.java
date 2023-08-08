package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Contacto;
import com.HandSolo.Asesorias.repositories.ContactoRepositorio;
import com.HandSolo.Asesorias.services.ContactoService;

@Service
public class IContacto implements ContactoService{

	@Autowired
	ContactoRepositorio repositorio;
	
	@Override
	public Iterable<Contacto> listAllContact() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	
	@Override
	public Contacto saveContact(Contacto contacto) {
		// TODO Auto-generated method stub
		return repositorio.save(contacto);
	}


	@Override
	public void deleteContact(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
