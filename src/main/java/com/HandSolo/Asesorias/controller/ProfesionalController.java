package com.HandSolo.Asesorias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Administrativo;
import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.services.ProfesionalService;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.utils.RolNombre;

@Controller
public class ProfesionalController {
	
	@Autowired
	ProfesionalService service;
    @Autowired
    RolService rolService;
	
	
	@GetMapping("/ProfesionalForm")
	public String CrearProfesionalForm(Model model) {
		Profesional profesional = new Profesional();
		model.addAttribute("profesional", profesional);
		return "CrearProfesional";
	}
	 
	@GetMapping("/ListaProfesional")
	public String listaProfesional(Model model) {
	model.addAttribute("listaProf",service.listAllUsuario() );
	return "ListarProfesional";
	}
	@PostMapping("/ListaProfesional")
	public String GuardarProfesional(@ModelAttribute ("profesional")@RequestParam("rolNombre") String rolNombre, @RequestParam("username") String username, @RequestParam("password") String password,Profesional profesional) {
		RolNombre rolEnum = RolNombre.valueOf(rolNombre);
		
		 Optional<Rol> optionalRol = rolService.findByName(rolEnum);
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encriptedPassword = passwordEncoder.encode(password);
		 
		 profesional.setPassword(encriptedPassword);
		 profesional.setUsername(username);
		
		service.saveProfesional(profesional);
		Rol roles;
	    if (optionalRol.isEmpty()) {
	
	        roles = new Rol(RolNombre.valueOf(rolNombre));
	        rolService.saveRol(roles);
	    } else {
	        roles = optionalRol.get();
	    }
	    
	    profesional.getRoles().add(roles);
	    service.saveProfesional(profesional);
		return "redirect:Index";
	}
	
	@GetMapping("/ListaProfesional/editar/{id}")
	public String editarProfesionalForm(@PathVariable Integer id, Model model) {
		model.addAttribute("profesional", service.getProfesionalById(id));
		return "EditarProfesional";
	} 
	
	@PostMapping("/ListaProfesional/{id}")
	public String actualizarProfesional(@PathVariable Integer id,@ModelAttribute("profesional") Profesional profesional, Model model){
		Profesional existenteProfesional = service.getProfesionalById(id);
		existenteProfesional.setId(id);
		existenteProfesional.setNombre(profesional.getNombre());
		existenteProfesional.setApellido(profesional.getApellido());
		existenteProfesional.setUsername(profesional.getUsername());
		existenteProfesional.setTitulo(profesional.getTitulo());
		existenteProfesional.setFechaIngreso(profesional.getFechaIngreso());
	
		service.updateProfesional(existenteProfesional);
		return "redirect:/ListaProfesional";
	}
	
	@GetMapping("/ListaProfesional/{id}")
	public String eliminarProfesional(@PathVariable Integer id) {
		service.deleteProfesional(id);
		return "redirect:/ListaProfesional";
	}
	

}
 