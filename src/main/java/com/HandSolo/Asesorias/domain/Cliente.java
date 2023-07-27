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
@Table(name="Cliente")
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario {


	
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int cliente_id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "Afp")
	private String afp;
	
	@Column(name = "sistema_salud")
	private String sistemaSalud;
	
	@Column(name = "direccion_cliente")
	private String direccionCliente;
	
	@Column(name = "comuna_cliente")
	private String comunaCliente;
	
	@Column(name = "edad")
	private Integer edad;
	
	@OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	public Cliente() {
	}

	public Cliente(int cliente_id) {
		this.cliente_id = cliente_id;
	}



	public Cliente(int id, String nombre, String tipo, int cliente_id, String nombres, String apellidos, String telefono, String afp, String sistemaSalud, String direccionCliente, String comunaCliente, Integer edad) {
		super(id, nombre, tipo);
		this.cliente_id = cliente_id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccionCliente = direccionCliente;
		this.comunaCliente = comunaCliente;
		this.edad = edad;
	}


	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}


	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	@Override
	public String toString() {
		return "Cliente [cliente_id=" + cliente_id + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", afp=" + afp + ", sistemaSalud="
				+ sistemaSalud + ", direccionCliente=" + direccionCliente + ", comunaCliente=" + comunaCliente
				+ ", edad=" + edad + "]";
	}

	
	
}