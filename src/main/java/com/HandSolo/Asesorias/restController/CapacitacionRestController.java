package com.HandSolo.Asesorias.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandSolo.Asesorias.modelo.Capacitacion;
import com.HandSolo.Asesorias.services.CapacitacionService;

@RestController
public class CapacitacionRestController {
	
	@Autowired
	CapacitacionService capService;
	
	
	@GetMapping("/capacitacion")
	public Iterable<Capacitacion> listaCapacitacion(Model model) {
		model.addAttribute("capacitacion");
		return capService.listAllCapacitacion();
	}

}
