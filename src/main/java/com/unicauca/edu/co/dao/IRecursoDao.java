package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Recurso;

public interface IRecursoDao extends CrudRepository<Recurso, Long> {

	@Query("SELECT r from Recurso r where r.rec_codigo LIKE %?1%")
	List<Recurso> findByRec_codigo(String rec_codigo);
	
	@Query("SELECT r from Recurso r where r.tiporecurso.rectipo_codigo = 'Salon' OR r.tiporecurso.rectipo_codigo = 'Sala' OR r.tiporecurso.rectipo_codigo = 'Auditorio' And r.facultad.fac_codigo = ?1")
	List<Recurso> recursosPorFacultadAudiSalaSalon (String fac_codigo);
	
	@Query("SELECT r from Recurso r where r.tiporecurso.rectipo_codigo <> 'Salon' OR r.tiporecurso.rectipo_codigo <> 'Sala' OR r.tiporecurso.rectipo_codigo <> 'Auditorio' And r.facultad.fac_codigo = ?1")
	List<Recurso> recursosPorFacultadDiferenteAudiSalaSalon(String fac_codigo);
}