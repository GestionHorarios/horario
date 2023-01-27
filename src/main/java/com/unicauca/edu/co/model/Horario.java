package com.unicauca.edu.co.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="horario")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long hor_id;
	private String hor_dia;
	private Date hor_hora_fin;
	private Date hor_hora_inicio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Recurso recurso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Curso curso;

	
	//getters and setters
	public Long getHor_id() {
		return hor_id;
	}
	public void setHor_id(Long hor_id) {
		this.hor_id = hor_id;
	}
	public String getHor_dia() {
		return hor_dia;
	}
	public void setHor_dia(String hor_dia) {
		this.hor_dia = hor_dia;
	}
	public Date getHor_hora_fin() {
		return hor_hora_fin;
	}
	public void setHor_hora_fin(Date hor_hora_fin) {
		this.hor_hora_fin = hor_hora_fin;
	}
	public Date getHor_hora_inicio() {
		return hor_hora_inicio;
	}
	public void setHor_hora_inicio(Date hor_hora_inicio) {
		this.hor_hora_inicio = hor_hora_inicio;
	}
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
