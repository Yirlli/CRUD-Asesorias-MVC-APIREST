package com.HandSolo.Asesorias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.modelo.VisitaTerreno;
import com.HandSolo.Asesorias.services.ClienteService;
import com.HandSolo.Asesorias.services.ProfesionalService;
import com.HandSolo.Asesorias.services.VisitaService;

@Controller
public class VisitaController {

	@Autowired
	VisitaService service;
	
	@Autowired
	ProfesionalService profesionalService;
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/ListaVisitas")
		public String listaVisitas(Model model) {
		Iterable<VisitaTerreno> listaVisita = service.listAllVisita();
		model.addAttribute("listaVisita", listaVisita);
		
		return "ListaVisitas";
	}
	
	@GetMapping("/CrearVisita")
		public String visitaForm(Model model) {
		Iterable<Profesional> listaProfesional = profesionalService.listAllUsuario();
		Iterable<Cliente> listaClientes = clienteService.listAllCliente();
		
		 model.addAttribute("listaProfesional", listaProfesional);
	     model.addAttribute("listaClientes", listaClientes);
		model.addAttribute("visitaTerreno" , new VisitaTerreno());
		
		return "CrearVisita";
	}
	
	@PostMapping("/ListaVisitas")
	public String guardarVisita( VisitaTerreno visitaTerreno) {
		
		 
		service.saveVisita(visitaTerreno);
		return "ListaVisitas";
	}
	
}
