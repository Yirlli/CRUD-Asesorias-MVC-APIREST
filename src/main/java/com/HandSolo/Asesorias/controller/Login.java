package com.HandSolo.Asesorias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandSolo.Asesorias.modelo.Usuario;
import com.HandSolo.Asesorias.services.UsuarioService;

@Controller
public class Login {
	@Autowired
    private UsuarioService usuarioService;
	private Authentication authentication;
	
	 @GetMapping("/Login")
	    public String showLoginForm() {
		
	        return "Login";
	    }
	 

	 @PostMapping("/login")
	 public String login(@RequestParam("rut") String rut, @RequestParam("password") String password) {
	     System.out.println("Login intentado con usuario: " + rut);
	     
	     // Resto del código de autenticación
	     
	     if (authentication.isAuthenticated()) {
	         System.out.println("Usuario autenticado: " + rut);
	     } else {
	         System.out.println("Autenticación fallida para el usuario: " + rut);
	     }
	     
	     // Resto del código de redirección
	     
	     return "redirect:/Login";
	 }
	
	



}
