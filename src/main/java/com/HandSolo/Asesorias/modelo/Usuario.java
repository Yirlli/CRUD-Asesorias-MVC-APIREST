package com.HandSolo.Asesorias.modelo;

import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;

	@Column(name = "password")
	private String password;

	@Column(name = "rut")
	private String username;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	@JsonIgnore
	private List<Rol> roles;
	
	public Usuario() {
        roles = new ArrayList<>(); 
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Usuario(int id, String nombre, String apellido, String password, String username, List<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.username = username;
		this.roles = roles;
	}

	public Usuario(String nombre, String apellido, String password, String username, List<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.username = username;
		this.roles = roles;
	}



}