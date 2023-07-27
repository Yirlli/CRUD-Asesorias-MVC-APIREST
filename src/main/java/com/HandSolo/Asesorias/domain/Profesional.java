package com.HandSolo.Asesorias.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Profesional")
@PrimaryKeyJoinColumn(name = "id")
public class Profesional extends Usuario {

	
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int profesional_id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "fecha_ingreso")
	private Date  fechaIngreso;
	
	@OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	public Profesional() {
		super();
	}


	public Profesional(int profesional_id) {
		super();
		this.profesional_id = profesional_id;
	}



	public Profesional(String titulo, Date fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	
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



	@Override
	public String toString() {
		return "Profesional [profesional_id=" + profesional_id + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso
				+  "]";
	}
	
	
	
}
