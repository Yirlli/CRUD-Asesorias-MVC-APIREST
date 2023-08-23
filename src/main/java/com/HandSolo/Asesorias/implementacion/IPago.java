package com.HandSolo.Asesorias.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HandSolo.Asesorias.modelo.Pago;
import com.HandSolo.Asesorias.repositories.PagoRepositorio;
import com.HandSolo.Asesorias.services.PagoService;

@Service
public class IPago implements PagoService{

	@Autowired
	PagoRepositorio pagoRepo;

	@Override
	public Iterable<Pago> listAllPago() {
		// TODO Auto-generated method stub
		return pagoRepo.findAll();
	}

	

	@Override
	public Pago savePago(Pago pago) {
		// TODO Auto-generated method stub
		return null;
	}
}
