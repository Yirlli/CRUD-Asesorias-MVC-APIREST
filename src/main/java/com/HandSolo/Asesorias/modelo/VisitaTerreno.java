package com.HandSolo.Asesorias.modelo;

import java.sql.Date;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="visita_terreno")
public class VisitaTerreno {

	
	@ManyToOne
    @JoinColumn(name = "profesional_id")
	@JsonIgnore
	private Profesional profesional;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	@JsonIgnore
    private Cliente cliente;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@OneToMany(mappedBy="visitaTerreno")
	@JsonIgnore
	private List<Revision> revisiones = new ArrayList<>();
	
	@Column(name="fecha_accidente")
	private Date fechaAccidente;
	private String hora;
	private String lugar;
	private String comentarios;
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
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
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	public List<Revision> getRevisiones() {
		return revisiones;
	}
	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}
	public VisitaTerreno() {
		super();
	}
	public VisitaTerreno(Profesional profesional, Cliente cliente, int id, List<Revision> revisiones,
			Date fechaAccidente, String hora, String lugar, String comentarios) {
		super();
		this.profesional = profesional;
		this.cliente = cliente;
		this.id = id;
		this.revisiones = revisiones;
		this.fechaAccidente = fechaAccidente;
		this.hora = hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

	
	

}
