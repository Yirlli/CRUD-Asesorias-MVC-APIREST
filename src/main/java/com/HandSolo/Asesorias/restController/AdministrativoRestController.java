package com.HandSolo.Asesorias.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HandSolo.Asesorias.modelo.Administrativo;
import com.HandSolo.Asesorias.services.AdministrativoService;

@RestController
@RequestMapping("/api")
public class AdministrativoRestController {


	
	@Autowired
	AdministrativoService adminS;
	
	@GetMapping("/admin")
	@ResponseBody
	public Iterable<Administrativo> lista() {
		return adminS.listAllAdministrativo();
	}
}
