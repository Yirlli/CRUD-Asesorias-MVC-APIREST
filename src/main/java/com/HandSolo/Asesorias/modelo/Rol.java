package com.HandSolo.Asesorias.modelo;

import java.util.List;

import com.HandSolo.Asesorias.utils.RolNombre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
	
	

	public Rol(RolNombre rolNombre) {
		this.nombre = rolNombre;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private RolNombre nombre;

	@ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RolNombre getNombre() {
		return nombre;
	}

	public void setNombre(RolNombre nombre) {
		this.nombre = nombre;
	}

	public Rol() {
		super();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Rol(int id, RolNombre nombre, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}



	
	
	
	
}
