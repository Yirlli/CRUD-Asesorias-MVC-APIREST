package com.HandSolo.Asesorias.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.services.ProfesionalService;

@RestController
public class ProfesionalRestController {

	@Autowired
	ProfesionalService pS;
	
	@GetMapping("/prof")
	public Iterable<Profesional> listaP(Model model) {
		model.addAttribute("capacitacion");
		return pS.listAllUsuario();
	}
}
