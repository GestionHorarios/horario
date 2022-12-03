package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recurso")
public class Recurso implements Serializable{

	//prueba de cambio 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rec_id;
	private String rec_codigo;
	private String rec_descripcion;
	private String rec_tipo;
	
	public Long getRec_id() {
		return rec_id;
	}
	public void setRec_id(Long rec_id) {
		this.rec_id = rec_id;
	}
	public String getRec_codigo() {
		return rec_codigo;
	}
	public void setRec_codigo(String rec_codigo) {
		this.rec_codigo = rec_codigo;
	}
	public String getRec_descripcion() {
		return rec_descripcion;
	}
	public void setRec_descripcion(String rec_descripcion) {
		this.rec_descripcion = rec_descripcion;
	}
	public String getRec_tipo() {
		return rec_tipo;
	}
	public void setRec_tipo(String rec_tipo) {
		this.rec_tipo = rec_tipo;
	}

	
	
}
