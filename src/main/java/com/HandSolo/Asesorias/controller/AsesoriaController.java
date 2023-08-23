package com.HandSolo.Asesorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Asesorias;
import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.services.AsesoriaService;
import com.HandSolo.Asesorias.services.ProfesionalService;

@Controller
public class AsesoriaController {
	@Autowired
	AsesoriaService asesoriaService;
	
	@Autowired
	ProfesionalService profesionalService;
	
	@GetMapping("/crearAsesoria")
	public String asesoriaForm(Model model) {
		Iterable<Profesional> listaProfesional = profesionalService.listAllUsuario();
		Asesorias asesoria = new Asesorias();
		model.addAttribute("asesoria", asesoria);
		model.addAttribute("listaProfesional", listaProfesional);
		return "CrearAsesoria";
	}
	
	@PostMapping("/ListaAsesoria")
	public String guardarAsesoria(Asesorias asesorias) {
		asesoriaService.saveAsesoria(asesorias);
		return "redirect:/Index";
	}
	
	@GetMapping("/ListaAsesoria")
	public String lista(Model model) {
		Iterable<Asesorias> listaAsesoria = asesoriaService.findAllAsesorias();
		model.addAttribute("listaAsesoria", listaAsesoria);
		return "ListaAsesoria";
	}

}
