package com.HandSolo.Asesorias.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Capacitacion;
import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.services.CapacitacionService;
import com.HandSolo.Asesorias.services.ClienteService;


@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService servicio;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/CrearCapacitacion")
	public String CrearCapacitacionForm(Model model) {
		Iterable<Cliente> listaClientes = clienteService.listAllCliente();
		Capacitacion capacitacion = new Capacitacion();
		model.addAttribute("listaClientes", listaClientes);
		model.addAttribute("capacitacion", capacitacion);
		return "CrearCapacitacion";
	}
	
	@GetMapping("/ListaCapacitacion")
		public String listaCapacitaciones(Model model) {
		model.addAttribute("listaCapacitacion",servicio.listAllCapacitacion() );
		return "ListarCapacitaciones";
	}
	
	@PostMapping("/ListaCapacitacion")
	public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
		servicio.saveCapacitacion(capacitacion);
		return "redirect:/ListaCapacitacion";
	}
	
	@GetMapping("/ListaCapacitacion/editar/{id}")
	public String editarCapacitacionForm(@PathVariable Integer id, Model model) {
		model.addAttribute("capacitacion", servicio.getCapacitacionById(id));
		return "EditarCapacitacion";
	}
	
	
	@PostMapping("/ListaCapacitacion/{id}")
	public String actualizarCapacitacion(@PathVariable Integer id,@ModelAttribute("capacitacion") Capacitacion capacitacion, Model model){
		Capacitacion existenteCapacitacion = servicio.getCapacitacionById(id);
		existenteCapacitacion.setId(id);
		existenteCapacitacion.setNombre(capacitacion.getNombre());
		existenteCapacitacion.setDetalle(capacitacion.getDetalle());
		existenteCapacitacion.getCliente().setUsername(capacitacion.getCliente().getUsername());
		existenteCapacitacion.setDia(capacitacion.getDia());
		existenteCapacitacion.setHora(capacitacion.getHora());
		existenteCapacitacion.setLugar(capacitacion.getLugar());
		existenteCapacitacion.setDuracion(capacitacion.getDuracion());
		existenteCapacitacion.setCantidadAsistentes(capacitacion.getCantidadAsistentes());
		servicio.updateCapacitacion(existenteCapacitacion);
		return "redirect:/ListaCapacitacion";
	}
	  
	@GetMapping("/ListaCapacitacion/{id}")
	public String eliminarCapacitacion(@PathVariable Integer id) {
		servicio.deleteCapacitacion(id);
		return "redirect:/ListaCapacitacion";
	}
}
	
