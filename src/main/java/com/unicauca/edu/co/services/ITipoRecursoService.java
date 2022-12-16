package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.TipoRecursoResponseRest;

public interface ITipoRecursoService {
	
	public ResponseEntity<TipoRecursoResponseRest> listar();
	public ResponseEntity<TipoRecursoResponseRest> buscarById(String id);
	public ResponseEntity<TipoRecursoResponseRest> guardar(Recurso recurso, String rectipo_codigo, String fac_codigo, String ubi_codigo);
	public ResponseEntity<TipoRecursoResponseRest> actualizar(Recurso recurso, Long id);
	public ResponseEntity<TipoRecursoResponseRest> eliminarById(Long id);

}
