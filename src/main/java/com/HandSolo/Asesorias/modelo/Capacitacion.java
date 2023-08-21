package com.HandSolo.Asesorias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="capacitaciones")
public class Capacitacion {
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="capacitacion_id")
	private Integer id;
	
	
	private String nombre;
	
	private String detalle;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
	
	private String dia;
	
	private String hora;
	
	private String lugar;
	
	private Integer duracion;
	@Column(name = "cantidad_asistentes")
	private Integer cantidadAsistentes;
	

	public Capacitacion(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(Integer cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Capacitacion() {
		super();
	}


	public Capacitacion(Integer id, String nombre, String detalle, Cliente cliente, String dia, String hora,
			String lugar, Integer duracion, Integer cantidadAsistentes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.cliente = cliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	
	
	

}