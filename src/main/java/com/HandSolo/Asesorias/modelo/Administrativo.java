package com.HandSolo.Asesorias.modelo;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Administrativo")
@PrimaryKeyJoinColumn(name = "administrativo_id")
public class Administrativo extends Usuario {

	
	@Column(name = "area")
	private String area;
	
	@Column(name = "experiencia_previa")
	private String experienciaPrevia;
	

	
	public Administrativo() {
		super();
	}



	public Administrativo(  String area, String experienciaPrevia) {
		super();
		
		this.area = area;
		this.experienciaPrevia= experienciaPrevia;
		
	
	}
	



	public Administrativo(int id, String nombre, String apellido, String password, String rut, 
			List<Rol> rol, String area, String experienciaPrevia) {
		super(id, nombre, apellido, password, rut, rol);
		// TODO Auto-generated constructor stub
		this.area = area;
		this.experienciaPrevia= experienciaPrevia;
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

	@Override
	public String toString() {
		return "Administrativo [+ area=" + area
				+ ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
