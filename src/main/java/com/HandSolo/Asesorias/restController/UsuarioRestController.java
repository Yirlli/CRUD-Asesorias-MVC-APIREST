package com.HandSolo.Asesorias.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.services.UsuarioService;
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	UsuarioService userService;
	
	@GetMapping("/usuarios")
	@ResponseBody
	public Iterable<Usuario> listaUsuarios(Model model) {
		model.addAttribute("usuarios");
		return userService.listAllUsuario();
	}
	
	@PostMapping("/crear/usuario")
	public Usuario crear(@Validated @RequestBody Usuario usuario) {
		return userService.saveUsuario(usuario);
	}
}
