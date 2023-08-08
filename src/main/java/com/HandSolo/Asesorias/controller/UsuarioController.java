package com.HandSolo.Asesorias.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.services.UsuarioService;
/*
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	
	@GetMapping("/CrearUsuario")
	public String CrearUsuarioForm(Model model) {
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		return "CrearUsuario";
	}

	
	@PostMapping("/ListaUsuario")
	public String guardarUsuario(Usuario usuario, @RequestParam String tipo, @RequestParam String nombre) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/Index";
	}

	@GetMapping("/ListaUsuario")
	public String listaUsuarios(Model model) {
	model.addAttribute("listaUsuario",usuarioService.listAllUsuario() );
	return "ListarUsuario";
	}
}
*/