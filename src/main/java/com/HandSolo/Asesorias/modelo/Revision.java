package com.HandSolo.Asesorias.modelo;

import com.HandSolo.Asesorias.utils.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Revision {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idRevision;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	@JsonIgnore
	private VisitaTerreno visitaTerreno;
	
	@Column(name="nombre_revision")
	private String nombreRevision;
	
	private String detalle;
	
	@Enumerated(EnumType.ORDINAL)
	private Estado estado;

	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public VisitaTerreno getVisitaTerreno() {
		return visitaTerreno;
	}

	public void setVisitaTerreno(VisitaTerreno visitaTerreno) {
		this.visitaTerreno = visitaTerreno;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Revision() {
		super();
	}

	public Revision(int idRevision, VisitaTerreno visitaTerreno, String nombreRevision, String detalle, Estado estado) {
		super();
		this.idRevision = idRevision;
		this.visitaTerreno = visitaTerreno;
		this.nombreRevision = nombreRevision;
		this.detalle = detalle;
		this.estado = estado;
	}

	
}
