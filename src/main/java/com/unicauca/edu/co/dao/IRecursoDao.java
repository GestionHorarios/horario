package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Recurso;

public interface IRecursoDao extends CrudRepository<Recurso, Long> {

	@Query("SELECT r from Recurso r where r.rec_codigo = ?1")
	List<Recurso> findByRec_codigo(String rec_codigo);
}
