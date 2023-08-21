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

import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.modelo.Administrativo;

import com.HandSolo.Asesorias.services.AdministrativoService;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.services.UsuarioService;
import com.HandSolo.Asesorias.utils.RolNombre;


@Controller
public class AdministrativoController {

	
	@Autowired
	AdministrativoService adminService;
	@Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;
	

	@GetMapping("/CrearAdministrativo")
	public String CrearAdminForm(Model model) {
		Administrativo administrativo = new Administrativo();
		model.addAttribute("administrativo", administrativo);
		
		return "CrearAdmin"; 
	} 
	
	@GetMapping("/ListaAdministrativo")
	public String listaAdmin(Model model) {
	model.addAttribute("listAdmin",adminService.listAllAdministrativo() );
	return "ListarAdministrativo";
}
	@PostMapping("/ListaAdministrativo")
	public String guardarAdmin(@ModelAttribute("administrativo")  @RequestParam("rolNombre") String rolNombre, @RequestParam("username") String username, @RequestParam("password") String password, Administrativo administrativo) {
		 
		RolNombre rolEnum = RolNombre.valueOf(rolNombre);
		
		 Optional<Rol> optionalRol = rolService.findByName(rolEnum);
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encriptedPassword = passwordEncoder.encode(password);
		    administrativo.setPassword(encriptedPassword);
		    administrativo.setUsername(username);
 
		    Rol roles;
		    if (optionalRol.isEmpty()) {
		
		        roles = new Rol(RolNombre.valueOf(rolNombre));
		        rolService.saveRol(roles);
		    } else {
		        roles = optionalRol.get();
		    } 
 
		    administrativo.getRoles().add(roles);
		    adminService.saveAdministrativo(administrativo);
		return "ListarAdministrativo";
	}  
	  
	@GetMapping("/ListaAdministrativo/editar/{id}")
	public String editarAdmin(@PathVariable Integer id, Model model) {
		model.addAttribute("administrativo", adminService.getAdministrativoById(id));
		return "EditarAdmin";
	} 
	 
	
	@PostMapping("/ListaAdministrativo/{id}")
	public String actualizarAdmin(@PathVariable Integer id,@ModelAttribute("administrativo") Administrativo administrativo, Model model){
		Administrativo existenteAdmin = adminService.getAdministrativoById(id);
		existenteAdmin.setId(id);
		existenteAdmin.setNombre(administrativo.getNombre());
		existenteAdmin.setApellido(administrativo.getApellido());
		existenteAdmin.setUsername(administrativo.getUsername());
		existenteAdmin.setArea(administrativo.getArea());
		existenteAdmin.setExperienciaPrevia(administrativo.getExperienciaPrevia());
	
		adminService.updateAdministrativo(existenteAdmin);
		return "redirect:/ListaAdministrativo";
	}
	  
	@GetMapping("/ListaAdministrativo/{id}")
	public String eliminarAdmin(@PathVariable Integer id) {
		adminService.deleteAdministrativo(id);
		return "redirect:/ListaAdministrativo";
	}  
}  
 
