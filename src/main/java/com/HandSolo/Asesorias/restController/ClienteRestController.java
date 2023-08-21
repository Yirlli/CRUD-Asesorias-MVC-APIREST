package com.HandSolo.Asesorias.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	
	@Autowired
	ClienteService cS;
	
	@GetMapping("/lista")
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	public Iterable<Cliente> listaCliente() {
	
		return cS.listAllCliente();
	}
	
	@PutMapping("/modificar")
	public void modificarCliente(@RequestBody Cliente cliente) {
		cS.updateCliente(cliente);
	}
	
}
