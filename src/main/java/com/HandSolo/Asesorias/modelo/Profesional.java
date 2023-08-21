package com.HandSolo.Asesorias.modelo;

import java.sql.Date;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="Profesional")
@PrimaryKeyJoinColumn(name = "profesional_id")
public class Profesional extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Column(name = "titulo")
	private String titulo;
	
	
	

	@Column(name = "fecha_ingreso")
	private Date  fechaIngreso;
	
	@OneToMany(mappedBy = "profesional")
	@JsonIgnore
    private List<VisitaTerreno> visitasEnTerreno = new ArrayList<>();

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

	public List<VisitaTerreno> getVisitasEnTerreno() {
		return visitasEnTerreno;
	}

	public void setVisitasEnTerreno(List<VisitaTerreno> visitasEnTerreno) {
		this.visitasEnTerreno = visitasEnTerreno;
	}

	public Profesional() {
		super();
	}

	public Profesional(String titulo, Date fechaIngreso, List<VisitaTerreno> visitasEnTerreno) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
		this.visitasEnTerreno = visitasEnTerreno;
	}

	public Profesional(int id, String nombre, String apellido, String password, String username, List<Rol> roles, String titulo, Date fechaIngreso, List<VisitaTerreno> visitasEnTerreno) {
		super(id, nombre, apellido, password, username, roles);
		// TODO Auto-generated constructor stub
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
		this.visitasEnTerreno = visitasEnTerreno;
	}

	
	
	


	
	
	
}
