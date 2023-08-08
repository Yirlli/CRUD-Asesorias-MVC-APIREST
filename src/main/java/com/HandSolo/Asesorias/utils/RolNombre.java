package com.HandSolo.Asesorias.utils;

public enum RolNombre {
	CLIENTE("Cliente"), ADMINISTRADOR("Administrador"), PROFESIONAL("Profesional");
	
	private String nombreRol;
	
	private RolNombre(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
}
