package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiporecurso")
public class Tiporecurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String rectipo_codigo;
	private String rectipo_nombre;
	private String rectipo_codigo_padre;

	public String getRectipo_codigo() {
		return rectipo_codigo;
	}
	public void setRectipo_codigo(String rectipo_codigo) {
		this.rectipo_codigo = rectipo_codigo;
	}
	public String getRectipo_nombre() {
		return rectipo_nombre;
	}
	public void setRectipo_nombre(String rectipo_nombre) {
		this.rectipo_nombre = rectipo_nombre;
	}
	public String getRectipo_codigo_padre() {
		return rectipo_codigo_padre;
	}
	public void setRectipo_codigo_padre(String rectipo_codigo_padre) {
		this.rectipo_codigo_padre = rectipo_codigo_padre;
	}
	
}
