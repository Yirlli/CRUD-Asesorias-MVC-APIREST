package com.HandSolo.Asesorias.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Administrativo extends Usuario {

	private int administrativo_id;
	private String area;
	private String experienciaPrevia;
	
	public Administrativo() {
		super();
	}

	public Administrativo(int administrativo_id) {
		super();
		this.administrativo_id = administrativo_id;
	}

	public Administrativo(int id, String nombre, String tipo, int administrativo_id, String area, String experienciaPrevia) {
		super(id, nombre, tipo);
		this.administrativo_id = administrativo_id;
		this.area = area;
		this.experienciaPrevia= experienciaPrevia;
		
		
	}

	public int getAdministrativo_id() {
		return administrativo_id;
	}

	public void setAdministrativo_id(int administrativo_id) {
		this.administrativo_id = administrativo_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
	
	
	

}
