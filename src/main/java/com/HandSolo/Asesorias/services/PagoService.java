package com.HandSolo.Asesorias.services;


import com.HandSolo.Asesorias.modelo.Pago;


public interface PagoService {

	Iterable<Pago> listAllPago();
	
	Pago savePago(Pago pago);
	
	
}
