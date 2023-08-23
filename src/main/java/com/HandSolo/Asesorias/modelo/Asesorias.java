package com.HandSolo.Asesorias.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asesorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String detalle;
	
	@ManyToOne
	@JoinColumn(name="profesional_id")
	@JsonIgnore
	private Profesional profesional;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Asesorias(int id, String nombre, String detalle, Profesional profesional) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.profesional = profesional;
	}

	public Asesorias() {
		super();
	}
	
	
}
