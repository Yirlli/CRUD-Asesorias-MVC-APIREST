package com.HandSolo.Asesorias.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Capacitacion;
import com.HandSolo.Asesorias.services.CapacitacionService;


@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService servicio;
	

	@GetMapping("/CrearCapacitacion")
	public String CrearCapacitacionForm(Model model) {
		Capacitacion capacitacion = new Capacitacion();
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
		existenteCapacitacion.setRutCliente(capacitacion.getRutCliente());
		existenteCapacitacion.setDia(capacitacion.getDia());
		existenteCapacitacion.setHora(capacitacion.getHora());
		existenteCapacitacion.setLugar(capacitacion.getLugar());
		existenteCapacitacion.setDuracion(capacitacion.getDuracion());
		existenteCapacitacion.setCantidadAsistentes(capacitacion.getCantidadAsistentes());
		servicio.updateCapacitacion(existenteCapacitacion);
		return "redirect/ListaCapacitacion";
	}
	  
	@GetMapping("/ListaCapacitacion/{id}")
	public String eliminarCapacitacion(@PathVariable Integer id) {
		servicio.deleteCapacitacion(id);
		return "redirect:/ListaCapacitacion";
	}
}
	
