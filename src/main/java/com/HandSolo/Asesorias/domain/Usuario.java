package com.HandSolo.Asesorias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo")
	private String tipo;
	
	@OneToOne(mappedBy = "usuario")
    private Profesional profesional;
	
	@OneToOne(mappedBy = "usuario")
    private Administrativo administrativo;
	
	@OneToOne(mappedBy = "usuario")
    private Cliente cliente;
	
	public Usuario() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario(int id, String nombre, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	
	
}