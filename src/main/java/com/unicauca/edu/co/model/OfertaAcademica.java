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
@Table(name="ofertaacademica")
public class OfertaAcademica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ofer_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Curso curso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Periodo perido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Docente docente;
	
	public Long getOfer_id() {
		return ofer_id;
	}
	public void setOfer_id(Long ofer_id) {
		this.ofer_id = ofer_id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Periodo getPerido() {
		return perido;
	}
	public void setPerido(Periodo perido) {
		this.perido = perido;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
