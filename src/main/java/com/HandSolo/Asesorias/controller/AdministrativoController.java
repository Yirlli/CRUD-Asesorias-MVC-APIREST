package com.HandSolo.Asesorias.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.modelo.Administrativo;
import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.services.AdministrativoService;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.services.UsuarioService;
import com.HandSolo.Asesorias.utils.RolNombre;
import com.HandSolo.Asesorias.modelo.Usuario;

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
		 RolNombre[] roles = RolNombre.values(); // Obtener todos los valores del enum
		    model.addAttribute("roles", roles);
		Administrativo administrativo = new Administrativo();
		model.addAttribute("administrativo", administrativo);
		
		return "CrearAdmin";
	} 
	
	@PostMapping("/ListaAdministrativo")
	public String guardarAdmin(@ModelAttribute("administrativo")  @RequestParam("rolNombre") String rolNombre,  Administrativo administrativo) {
		 
		adminService.saveAdministrativo(administrativo);
		 Optional<Rol> optionalRol = rolService.findByName(RolNombre.valueOf(rolNombre));

		    Rol rol;
		    if (optionalRol.isEmpty()) {
		
		        rol = new Rol(RolNombre.valueOf(rolNombre));
		        rolService.saveRol(rol);
		    } else {
		        rol = optionalRol.get();
		    }

		    administrativo.getRol().add(rol);
		return "Index";
	}   
} 
 
