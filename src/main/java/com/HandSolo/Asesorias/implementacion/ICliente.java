package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.repositories.ClienteRepositorio;
import com.HandSolo.Asesorias.services.ClienteService;

@Service
public class ICliente implements ClienteService {
	
	@Autowired
	private ClienteRepositorio repositorio;

	@Override
	public Iterable<Cliente> listAllCliente() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return repositorio.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return repositorio.save(cliente);
	}

	@Override
	public void deleteUsuario(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
