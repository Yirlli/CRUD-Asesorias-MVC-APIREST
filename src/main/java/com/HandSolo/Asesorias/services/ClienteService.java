package com.HandSolo.Asesorias.services;

import com.HandSolo.Asesorias.modelo.Cliente;

public interface ClienteService {
	Iterable<Cliente> listAllCliente();

	Cliente getClienteById(Integer id);
	
	
	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Cliente cliente);
	
	public void deleteUsuario(Integer id);
	

}
