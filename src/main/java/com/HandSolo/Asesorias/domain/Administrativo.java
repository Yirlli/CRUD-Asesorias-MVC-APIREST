package com.HandSolo.Asesorias.domain;

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
@Table(name="Administrativo")
@PrimaryKeyJoinColumn(name = "id")
public class Administrativo extends Usuario {

	
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int administrativo_id;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "experiencia_previa")
	private String experienciaPrevia;
	
	@OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	public Administrativo() {
		super();
	}

	public Administrativo(int administrativo_id) {
		super();
		this.administrativo_id = administrativo_id;
	}

	public Administrativo(int id, String nombre, String tipo, int administrativo_id,  String area, String experienciaPrevia) {
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

	@Override
	public String toString() {
		return "Administrativo [administrativo_id=" + administrativo_id + ", area=" + area
				+ ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
