package com.unicauca.edu.co.model.dto;

import java.io.Serializable;

public class HorarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long hor_id;
	private String hor_dia;
	private String hor_hora_inicio;
	private String hor_hora_fin;
	private Long recurso_id;
	private Long cusro_id;
	
	public HorarioDto(Long hor_id, String hor_dia, String hor_hora_inicio, String hor_hora_fin, Long recurso_id,
			Long cusro_id) {
		this.hor_id = hor_id;
		this.hor_dia = hor_dia;
		this.hor_hora_inicio = hor_hora_inicio;
		this.hor_hora_fin = hor_hora_fin;
		this.recurso_id = recurso_id;
		this.cusro_id = cusro_id;
	}
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
	public String getHor_hora_inicio() {
		return hor_hora_inicio;
	}
	public void setHor_hora_inicio(String hor_hora_inicio) {
		this.hor_hora_inicio = hor_hora_inicio;
	}
	public String getHor_hora_fin() {
		return hor_hora_fin;
	}
	public void setHor_hora_fin(String hor_hora_fin) {
		this.hor_hora_fin = hor_hora_fin;
	}
	public Long getRecurso_id() {
		return recurso_id;
	}
	public void setRecurso_id(Long recurso_id) {
		this.recurso_id = recurso_id;
	}
	public Long getCusro_id() {
		return cusro_id;
	}
	public void setCusro_id(Long cusro_id) {
		this.cusro_id = cusro_id;
	}
}
