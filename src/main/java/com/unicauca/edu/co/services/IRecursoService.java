package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;

public interface IRecursoService {

	public ResponseEntity<RecursoResponseRest> listar();
	public ResponseEntity<RecursoResponseRest> buscarById(Long id);
	public ResponseEntity<RecursoResponseRest> buscarByRec_codigo(String rec_codigo);
	public ResponseEntity<RecursoResponseRest> guardar(Recurso recurso, String rectipo_codigo, String fac_codigo, String ubi_codigo);
	public ResponseEntity<RecursoResponseRest> actualizar(Recurso recurso, Long idRecurso,String rectipo_codigo, String fac_codigo, String ubi_codigo);
	public ResponseEntity<RecursoResponseRest> eliminarById(Long id);
	
}
