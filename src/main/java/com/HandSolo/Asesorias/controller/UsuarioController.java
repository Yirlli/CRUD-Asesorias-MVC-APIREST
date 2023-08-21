package com.HandSolo.Asesorias.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Administrativo;
import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.modelo.Profesional;
import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.services.AdministrativoService;
import com.HandSolo.Asesorias.services.ClienteService;
import com.HandSolo.Asesorias.services.ProfesionalService;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.services.UsuarioService;
import com.HandSolo.Asesorias.utils.RolNombre;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProfesionalService profesionalService;
	
	@Autowired
	AdministrativoService adminService;
	
	 @Autowired
	  RolService rolService;
	
	
	
	@GetMapping("/CrearUsuario")
	public String CrearUsuarioForm(Model model) {
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		return "CrearUsuario";
	}

	
	@PostMapping("/ListaUsuario")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, 
            @RequestParam("rolNombre") String rolNombre,
            @RequestParam("area") String area,
            @RequestParam("experienciaPrevia") String experienciaPrevia,
            @RequestParam("username") String username, @RequestParam("password") String password) {
		Administrativo admin = new Administrativo();
		RolNombre rolEnum = RolNombre.valueOf(rolNombre);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encriptedPassword = passwordEncoder.encode(password);
		admin.setPassword(encriptedPassword);
		admin.setUsername(username);
		
		Optional<Rol> optionalRol = rolService.findByName(rolEnum);
		

		 Rol roles;
		 if (optionalRol.isEmpty()) {
		
		        roles = new Rol(RolNombre.valueOf(rolNombre));
		        rolService.saveRol(roles);
		    } else {
		        roles = optionalRol.get();
		    } 

		 usuario.getRoles().add(roles);
		
	 if(rolEnum==RolNombre.ADMINISTRADOR) {
			
	        admin.setArea(area);
	        admin.setExperienciaPrevia(experienciaPrevia);
	        
	       
	        usuarioService.saveUsuario(admin);
			
		}else if(rolEnum==RolNombre.PROFESIONAL) {
		
			
		}
		return "redirect:/Index";
	}

	@GetMapping("/ListaUsuario")
	public String listaUsuarios(Model model) {
	model.addAttribute("listaUsuario",usuarioService.listAllUsuario() );
	return "ListarUsuario";
	}
}
