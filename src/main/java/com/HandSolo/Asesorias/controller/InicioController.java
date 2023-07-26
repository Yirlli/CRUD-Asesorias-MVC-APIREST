package com.HandSolo.Asesorias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	
	

	@GetMapping({"/Index","/"})
	public String Index() {
		return "Index";
	}
}
