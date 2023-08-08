package com.HandSolo.Asesorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.services.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	ClienteService servicio;
	
	@GetMapping("/ClienteForm")
	public String crearClienteForm(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "CrearCliente";
	}
	
	@PostMapping("/ListarCliente")
	public String guardarCliente(@ModelAttribute("cliente")Cliente cliente) {
		servicio.saveCliente(cliente);
		return "redirect:/Index";
	}

}
