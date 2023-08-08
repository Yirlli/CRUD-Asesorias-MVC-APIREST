package com.HandSolo.Asesorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Contacto;

import com.HandSolo.Asesorias.services.ContactoService;

@Controller
public class ContactoController {
	
	@Autowired
	ContactoService servicio;
	
	@GetMapping("/Contacto")
	public String ContactoForm(Model model) {
		Contacto contacto = new Contacto();
		model.addAttribute("contacto",contacto);
		return "Contacto";
	}
	
	@PostMapping("/CrearContacto")
		public String guardarContacto(@ModelAttribute("contacto")Contacto contacto) {
			servicio.saveContact(contacto);
			return "redirect:/ContactoEnviado";
		}
 	 
	@GetMapping("/ContactoEnviado")
	public String mostrarContacto(Model model) {
		model.addAttribute("contacto", servicio.listAllContact());
		return "ContactoEnviado";
	}
	
}