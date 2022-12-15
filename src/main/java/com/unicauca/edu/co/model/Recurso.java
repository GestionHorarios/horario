package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="recurso")
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rec_id;
	private String rec_codigo;
	private Integer rec_capmax;
	private String rec_nombre;
	private String rec_descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Ubicacion ubicacion;
	
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
	public Integer getRec_capmax() {
		return rec_capmax;
	}
	public void setRec_capmax(Integer rec_capmax) {
		this.rec_capmax = rec_capmax;
	}
	public String getRec_nombre() {
		return rec_nombre;
	}
	public void setRec_nombre(String rec_nombre) {
		this.rec_nombre = rec_nombre;
	}
	public String getRec_descripcion() {
		return rec_descripcion;
	}
	public void setRec_descripcion(String rec_descripcion) {
		this.rec_descripcion = rec_descripcion;
	}
	
}