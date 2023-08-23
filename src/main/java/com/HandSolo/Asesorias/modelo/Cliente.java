	package com.HandSolo.Asesorias.modelo;
	
	
	import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.PrimaryKeyJoinColumn;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name="Cliente")
	@PrimaryKeyJoinColumn(name = "cliente_id")
	public class Cliente extends Usuario {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Column(name = "razon_social")
		private String razonSocial;
		@Column(name = "rut_cliente")
		private String rutCliente;
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
		
		@OneToMany(mappedBy = "cliente")
		@JsonIgnore
	    private List<VisitaTerreno> visitaTerreno = new ArrayList<>();
		
		@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
		@JsonIgnore
	    private List<Accidente> accidentes;
		
		@OneToMany(mappedBy="cliente")
		@JsonIgnore
		private List<Capacitacion> capacitaciones= new ArrayList<>();
	
		@OneToMany(mappedBy = "cliente")
		@JsonIgnore
		private List<Pago> pagos = new ArrayList<>();
		
		
		public List<Pago> getPagos() {
			return pagos;
		}

		public void setPagos(List<Pago> pagos) {
			this.pagos = pagos;
		}

		public String getRazonSocial() {
			return razonSocial;
		}
	
		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}
	
		public String getRutCliente() {
			return rutCliente;
		}
	
		public void setRutCliente(String rutCliente) {
			this.rutCliente = rutCliente;
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
	
		public List<VisitaTerreno> getVisitaTerreno() {
			return visitaTerreno;
		}
	
		public void setVisitaTerreno(List<VisitaTerreno> visitaTerreno) {
			this.visitaTerreno = visitaTerreno;
		}
	
		public List<Accidente> getAccidentes() {
			return accidentes;
		}
	
		public void setAccidentes(List<Accidente> accidentes) {
			this.accidentes = accidentes;
		}
	
		public List<Capacitacion> getCapacitaciones() {
			return capacitaciones;
		}
	
		public void setCapacitaciones(List<Capacitacion> capacitaciones) {
			this.capacitaciones = capacitaciones;
		}
	
		public Cliente() {
			super();
		}
	
		public Cliente(String razonSocial, String rutCliente, String telefono, String afp, String sistemaSalud,
				String direccionCliente, String comunaCliente, Integer edad, List<VisitaTerreno> visitaTerreno,
				List<Accidente> accidentes, List<Capacitacion> capacitaciones, List <Pago> pagos) {
			super();
			this.razonSocial = razonSocial;
			this.rutCliente = rutCliente;
			this.telefono = telefono;
			this.afp = afp;
			this.sistemaSalud = sistemaSalud;
			this.direccionCliente = direccionCliente;
			this.comunaCliente = comunaCliente;
			this.edad = edad;
			this.visitaTerreno = visitaTerreno;
			this.accidentes = accidentes;
			this.capacitaciones = capacitaciones;
			this.pagos= pagos;
		}
	
		public Cliente(int id, String nombre, String apellido, String password, String username, List<Rol> roles, String razonSocial, String rutCliente, String telefono, String afp, String sistemaSalud,
				String direccionCliente, String comunaCliente, Integer edad, List<VisitaTerreno> visitaTerreno,
				List<Accidente> accidentes, List<Capacitacion> capacitaciones, List <Pago> pagos) {
			super(id, nombre, apellido, password, username, roles );
			// TODO Auto-generated constructor stub
			this.razonSocial = razonSocial;
			this.rutCliente = rutCliente;
			this.telefono = telefono;
			this.afp = afp;
			this.sistemaSalud = sistemaSalud;
			this.direccionCliente = direccionCliente;
			this.comunaCliente = comunaCliente;
			this.edad = edad;
			this.visitaTerreno = visitaTerreno;
			this.accidentes = accidentes;
			this.capacitaciones = capacitaciones;
			this.pagos = pagos;
		}
		
	
	
		
		
		
	}