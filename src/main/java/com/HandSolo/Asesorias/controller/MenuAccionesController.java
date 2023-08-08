package com.HandSolo.Asesorias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuAccionesController {
	
	@GetMapping("/menu_admin")
	public String MenuAdmin() {
		return "AccAdmin";
	}
	
	@GetMapping("/menu_capacitacion")
	public String MenuCapacitacion() {
		return "AccCapacitacion"; 
	}
	
	@GetMapping("/menu_profesional")
	public String MenuProfesional() {
		return "AccProfesional";
	} 
	
	
	@GetMapping("/menu_cliente")
	public String MenuCliente() {
		return "AccCliente"; 
	}
	
	@GetMapping("/menu_usuario")
	public String MenuUsuario() {
		return "AccUsuario";
	}

} 
 

