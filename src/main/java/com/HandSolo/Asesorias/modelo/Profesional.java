package com.HandSolo.Asesorias.modelo;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="Profesional")
@PrimaryKeyJoinColumn(name = "profesional_id")
public class Profesional extends Usuario {

	@Column(name = "titulo")
	private String titulo;
	
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name = "fecha_ingreso")
	private Date  fechaIngreso;

	public Profesional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesional(String titulo, Date fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesional(int id, String nombre, String apellido, String password, String rut, 
			List<Rol> rol, String titulo, Date fechaIngreso) {
		super(id, nombre, apellido, password, rut,  rol);
		// TODO Auto-generated constructor stub
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
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
