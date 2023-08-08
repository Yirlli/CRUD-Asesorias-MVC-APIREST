package com.HandSolo.Asesorias.modelo;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
@PrimaryKeyJoinColumn(name = "cliente_id")
public class Cliente extends Usuario {

	@Column(name = "razon_social")
	private String razonSocial;
	private String telefono;
	
	@Column(name = "Afp")
	private String afp;
	
	@Column(name = "sistema_salud")
	private String sistemaSalud;
	
	@Column(name = "direccion_cliente")
	private String direccionCliente;
	
	@Column(name = "comuna_cliente")
	private String comunaCliente;
	
	
	private Integer edad;


	public Cliente() {
		super();
	}


	public Cliente(int id, String nombre, String apellido, String password, String rut,
			List<Rol> rol, String razonSocial, String telefono, String afp, String sistemaSalud, String direccionCliente, String comunaCliente,
			Integer edad) {
		super(id, nombre, apellido, password, rut, rol);
		// TODO Auto-generated constructor stub
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccionCliente = direccionCliente;
		this.comunaCliente = comunaCliente;
		this.edad = edad;
		this.razonSocial= razonSocial;
	}


	public Cliente(String razonSocial,String telefono, String afp, String sistemaSalud, String direccionCliente, String comunaCliente,
			Integer edad) {
		super();
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccionCliente = direccionCliente;
		this.comunaCliente = comunaCliente;
		this.edad = edad;
		this.razonSocial= razonSocial;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getAfp() {
		return afp;
	}


	public void setAfp(String afp) {
		this.afp = afp;
	}


	public String getSistemaSalud() {
		return sistemaSalud;
	}


	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}


	public String getDireccionCliente() {
		return direccionCliente;
	}


	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}


	public String getComunaCliente() {
		return comunaCliente;
	}


	public void setComunaCliente(String comunaCliente) {
		this.comunaCliente = comunaCliente;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
	
}