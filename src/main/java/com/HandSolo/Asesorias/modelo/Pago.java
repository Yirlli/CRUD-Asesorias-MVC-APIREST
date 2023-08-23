package com.HandSolo.Asesorias.modelo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double monto;
	
	@Column(name="fecha_pago")
	private Date fechaPago;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@JsonIgnore
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pago(int id, double monto, Date fechaPago, Cliente cliente) {
		super();
		this.id = id;
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.cliente = cliente;
	}

	public Pago() {
		super();
	}
	
	
	
	

}
