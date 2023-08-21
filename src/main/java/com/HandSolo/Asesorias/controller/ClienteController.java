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
import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.modelo.Rol;
import com.HandSolo.Asesorias.services.ClienteService;
import com.HandSolo.Asesorias.services.RolService;
import com.HandSolo.Asesorias.utils.RolNombre;

@Controller
public class ClienteController {

	@Autowired
	ClienteService servicio;
	

    @Autowired
    RolService rolService;
	
	@GetMapping("/ClienteForm")
	public String crearClienteForm(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "CrearCliente";
	}
	
	@GetMapping("/ListarCliente")
	public String listaCapacitaciones(Model model) {
	model.addAttribute("listaCliente",servicio.listAllCliente() );
	return "ListarCliente";
	}
	
	
	@PostMapping("/ListarCliente")
	public String guardarCliente(@ModelAttribute("cliente") @RequestParam("rolNombre") String rolNombre, @RequestParam("username") String username, @RequestParam("password") String password, Cliente cliente) {
		RolNombre rolEnum = RolNombre.valueOf(rolNombre);
		
		 Optional<Rol> optionalRol = rolService.findByName(rolEnum);
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encriptedPassword = passwordEncoder.encode(password);
		 cliente.setPassword(encriptedPassword);
		 cliente.setUsername(username);
		 
		 Rol roles;
		    if (optionalRol.isEmpty()) {
		
		        roles = new Rol(RolNombre.valueOf(rolNombre));
		        rolService.saveRol(roles);
		    } else {
		        roles = optionalRol.get(); 
		    } 
		    
		    cliente.getRoles().add(roles); 
		servicio.saveCliente(cliente); 
		return "redirect:/Index"; 
	}
	
	@GetMapping("/ListarCliente/editar/{id}")
	public String editarAdmin(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente",servicio.getClienteById(id));
		return "EditarCliente";
	} 
	

	@PostMapping("/ListarCliente/{id}")
	public String actualizarAdmin(@PathVariable Integer id,@ModelAttribute("cliente") Cliente cliente, Model model){
		Cliente existenteCliente = servicio.getClienteById(id);
		existenteCliente.setId(id);
		existenteCliente.setNombre(cliente.getNombre());
		existenteCliente.setApellido(cliente.getApellido());
		existenteCliente.setUsername(cliente.getUsername());
		existenteCliente.setRazonSocial(cliente.getRazonSocial());
		existenteCliente.setTelefono(cliente.getTelefono());
		existenteCliente.setAfp(cliente.getAfp());
		existenteCliente.setSistemaSalud(cliente.getSistemaSalud());
		existenteCliente.setDireccionCliente(cliente.getDireccionCliente());
		existenteCliente.setComunaCliente(cliente.getComunaCliente());
		existenteCliente.setEdad(cliente.getEdad());
		
	
	
		servicio.updateCliente(existenteCliente);
		return "redirect:/ListarCliente";
	}
	
	@GetMapping("/ListarCLiente/{id}")
	public String eliminarAdmin(@PathVariable Integer id) {
		servicio.deleteUsuario(id);
		return "redirect:/ListarCliente";
	}

}
 