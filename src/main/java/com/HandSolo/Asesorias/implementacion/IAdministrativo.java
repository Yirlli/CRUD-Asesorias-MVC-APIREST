package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.domain.Administrativo;
import com.HandSolo.Asesorias.repositories.AdministrativoRepositorio;
import com.HandSolo.Asesorias.services.AdministrativoService;

@Service
public class IAdministrativo implements AdministrativoService{
	
	@Autowired
	private AdministrativoRepositorio repositorio;

	@Override
	public Iterable<Administrativo> listAllAdministrativo() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Administrativo getAdministrativoById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Administrativo saveAdministrativo(Administrativo administrativo) {
		// TODO Auto-generated method stub
		return repositorio.save(administrativo);
	}

	@Override
	public Administrativo updateAdministrativo(Administrativo administrativo) {
		// TODO Auto-generated method stub
		return repositorio.save(administrativo);
	}

	@Override
	public void deleteAdministrativo(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
