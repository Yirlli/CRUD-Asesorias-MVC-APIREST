package com.HandSolo.Asesorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HandSolo.Asesorias.modelo.Cliente;
import com.HandSolo.Asesorias.modelo.Pago;
import com.HandSolo.Asesorias.services.ClienteService;
import com.HandSolo.Asesorias.services.PagoService;

@Controller
public class PagoController {
	
	@Autowired
	PagoService pagoService;
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/PagoForm")
	public String pagoForm(Model model) {
		Pago pago = new Pago();
		Iterable <Cliente> listaCliente = clienteService.listAllCliente();
		model.addAttribute("listaCliente",listaCliente);
		model.addAttribute("pago", pago) ;
		return "CrearPago";
	}
	
	@GetMapping("/ListaPago")
	public String listaPago(Model model) {
		model.addAttribute("listaPago", pagoService.listAllPago());
		return "ListadoPagos";
	}
	
	@PostMapping("/ListaPago")
	public String guardarPago(@ModelAttribute("pago") Pago pago){
		 pagoService.savePago(pago);
		 return "redirect:/Index"; 
	}

}
