package com.unicauca.edu.co.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="programaroferta")
public class ProgramarOferta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long progof_id;
	private Date progof_hora_inicio;
	private Date progof_hora_fin;
	private String progof_dia;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private OfertaAcademica ofertaacademica;
	
	public Long getProgof_id() {
		return progof_id;
	}
	public void setProgof_id(Long progof_id) {
		this.progof_id = progof_id;
	}
	public Date getProgof_hora_inicio() {
		return progof_hora_inicio;
	}
	public void setProgof_hora_inicio(Date progof_hora_inicio) {
		this.progof_hora_inicio = progof_hora_inicio;
	}
	public Date getProgof_hora_fin() {
		return progof_hora_fin;
	}
	public void setProgof_hora_fin(Date progof_hora_fin) {
		this.progof_hora_fin = progof_hora_fin;
	}
	public String getProgof_dia() {
		return progof_dia;
	}
	public void setProgof_dia(String progof_dia) {
		this.progof_dia = progof_dia;
	}
	public OfertaAcademica getOfertaacademica() {
		return ofertaacademica;
	}
	public void setOfertaacademica(OfertaAcademica ofertaacademica) {
		this.ofertaacademica = ofertaacademica;
	}
}
