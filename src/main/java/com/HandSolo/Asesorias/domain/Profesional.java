package com.HandSolo.Asesorias.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Profesional extends Usuario {

	
	private int profesional_id;
	private String titulo;
	private Date  fechaIngreso;
	
	public Profesional() {
	}
	
	
	public Profesional(int profesional_id) {
		this.profesional_id = profesional_id;
	}



	public Profesional(int id, String nombre, String tipo, int profesional_id, String titulo, Date fechaIngreso) {
		super(id, nombre, tipo);
		this.profesional_id = profesional_id;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}


	public int getProfesional_id() {
		return profesional_id;
	}


	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	

	
	
	
}
