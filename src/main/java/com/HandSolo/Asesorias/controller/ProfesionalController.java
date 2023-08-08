package com.HandSolo.Asesorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.services.ProfesionalService;

@Controller
public class ProfesionalController {
	
	@Autowired
	ProfesionalService service;
	
	@GetMapping("/ProfesionalForm")
	public String CrearProfesionalForm(Model model) {
		Profesional profesional = new Profesional();
		model.addAttribute("profesional", profesional);
		return "CrearProfesional";
	}
	 
	@PostMapping("/ListaProfesional")
	public String GuardarProfesional(@ModelAttribute ("profesional")Profesional profesional) {
		service.saveProfesional(profesional);
		return "redirect:Index";
	}
	

}
