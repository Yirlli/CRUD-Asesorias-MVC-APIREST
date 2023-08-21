package com.HandSolo.Asesorias.modelo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Accidente {

	@ManyToOne
    @JoinColumn(name = "cliente_rut", nullable = false)
	@JsonIgnore
    private Cliente cliente;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private Date fechaAccidente;
	private String hora;
	private String lugar;
	private String origen;
	private String consecuencias;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaAccidente() {
		return fechaAccidente;
	}
	public void setFechaAccidente(Date fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getConsecuencias() {
		return consecuencias;
	}
	public void setConsecuencias(String consecuencias) {
		this.consecuencias = consecuencias;
	}
	public Accidente() {
		super();
	}
	public Accidente(Cliente cliente, int id, Date fechaAccidente, String hora, String lugar, String origen,
			String consecuencias) {
		super();
		this.cliente = cliente;
		this.id = id;
		this.fechaAccidente = fechaAccidente;
		this.hora = hora;
		this.lugar = lugar;
		this.origen = origen;
		this.consecuencias = consecuencias;
	}
	
	
}
