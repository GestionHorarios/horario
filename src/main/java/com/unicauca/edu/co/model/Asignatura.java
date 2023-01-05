package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="asignatura")
public class Asignatura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String asig_codigo;
	private String asig_nombre;
	private String asig_intensidad;
	private String asig_semestre;
	private String asig_modalidad;
	private String asig_observaciones;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Programa programa;
	public String getAsig_codigo() {
		return asig_codigo;
	}
	public void setAsig_codigo(String asig_codigo) {
		this.asig_codigo = asig_codigo;
	}
	public String getAsig_nombre() {
		return asig_nombre;
	}
	public void setAsig_nombre(String asig_nombre) {
		this.asig_nombre = asig_nombre;
	}
	public String getAsig_intensidad() {
		return asig_intensidad;
	}
	public void setAsig_intensidad(String asig_intensidad) {
		this.asig_intensidad = asig_intensidad;
	}
	public String getAsig_semestre() {
		return asig_semestre;
	}
	public void setAsig_semestre(String asig_semestre) {
		this.asig_semestre = asig_semestre;
	}
	public String getAsig_modalidad() {
		return asig_modalidad;
	}
	public void setAsig_modalidad(String asig_modalidad) {
		this.asig_modalidad = asig_modalidad;
	}
	public String getAsig_observaciones() {
		return asig_observaciones;
	}
	public void setAsig_observaciones(String asig_observaciones) {
		this.asig_observaciones = asig_observaciones;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
}
