package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;
import com.unicauca.edu.co.services.IRecursoService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class RecursoController {
	
	@Autowired
	private IRecursoService recursoService;
	
	//obtenemos todos los recursos
	@GetMapping("/recursos")
	private ResponseEntity<RecursoResponseRest> listarRecursos(){
		ResponseEntity<RecursoResponseRest> response = recursoService.listar();
		return response;
	}
	
	//busca recurso por id
	@GetMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> buscarRecursoById(@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> response = recursoService.buscarById(id);
		return response;
	}
	
	//guardamos un recurso
	@PostMapping("/recursos")
	public ResponseEntity<RecursoResponseRest> guardarRecurso(@RequestBody Recurso recurso){
		ResponseEntity<RecursoResponseRest> response = recursoService.guardar(recurso);
		return response;
	}

	//actualizamos recurso
	@PutMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> actulizarRecurso(@RequestBody Recurso recurso,@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> response = recursoService.actualizar(recurso, id);
		return response;
	}
	
	//eliminar un recurso por id
	@DeleteMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> eliminarRecurso(@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> resposne = recursoService.eliminarById(id);
		return resposne;
	}
	
}
