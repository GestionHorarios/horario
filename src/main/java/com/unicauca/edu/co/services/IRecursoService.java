package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;

public interface IRecursoService {

	public ResponseEntity<RecursoResponseRest> listar();
	public ResponseEntity<RecursoResponseRest> buscarById(Long id);
	public ResponseEntity<RecursoResponseRest> guardar(Recurso recurso);
	public ResponseEntity<RecursoResponseRest> actualizar(Recurso recurso, Long id);
	public ResponseEntity<RecursoResponseRest> eliminarById(Long id);
	
}
