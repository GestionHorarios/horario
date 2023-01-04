package com.unicauca.edu.co.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;
import com.unicauca.edu.co.services.IRecursoService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class RecursoRestController {
	
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
	
	//buscar recurso por rec_codigo
	@GetMapping("/recursoscod/{cod_recurso}")
	public ResponseEntity<RecursoResponseRest> buscarRecursoRec_codigo(@PathVariable String cod_recurso){
		ResponseEntity<RecursoResponseRest> response = recursoService.buscarByRec_codigo(cod_recurso);
		return response;
	}
	
	//guardamos un recurso
	@PostMapping("/recursos")
	public ResponseEntity<RecursoResponseRest> guardarRecurso(
			@RequestParam("rec_codigo") String rec_codigo,
			@RequestParam("rectipo_codigo")String rectipo_codigo,
			@RequestParam("fac_codigo") String fac_codigo,
			@RequestParam(defaultValue ="-1" ,value="rec_capmax") int capmax,
			@RequestParam("rec_nombre") String rec_nombre,
			@RequestParam("rec_decripcion")String rec_descripcion,
			@RequestParam("ubi_codigo") String ubi_codigo
			) throws IOException, NumberFormatException, MethodArgumentTypeMismatchException
	{
		System.out.println("recibiendo los datos");
		Recurso recurso = new Recurso();
		recurso.setRec_codigo(rec_codigo);
		if(capmax != -1 ) {
			recurso.setRec_capmax(capmax);
		}
		recurso.setRec_nombre(rec_nombre);
		recurso.setRec_descripcion(rec_descripcion);
		ResponseEntity<RecursoResponseRest> response = recursoService.guardar(recurso,rectipo_codigo, fac_codigo,ubi_codigo);
		return response;
	}

	//actualizamos recurso
	@PutMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> actulizarRecurso(
			@RequestParam("rec_codigo") String rec_codigo,
			@RequestParam("rectipo_codigo")String rectipo_codigo,
			@RequestParam("fac_codigo") String fac_codigo,
			@RequestParam("rec_capmax") int capmax,
			@RequestParam("rec_nombre") String rec_nombre,
			@RequestParam("rec_decripcion")String rec_descripcion,
			@RequestParam("ubi_codigo") String ubi_codigo,
			@PathVariable Long id)
	{
		Recurso recurso = new Recurso();
		recurso.setRec_codigo(rec_codigo);
		recurso.setRec_capmax(capmax);
		recurso.setRec_nombre(rec_nombre);
		recurso.setRec_descripcion(rec_descripcion);
		ResponseEntity<RecursoResponseRest> response = recursoService.actualizar(recurso,id,rectipo_codigo,fac_codigo,ubi_codigo);
		return response;
	}
	
	//eliminar un recurso por id
	@DeleteMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> eliminarRecurso(@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> resposne = recursoService.eliminarById(id);
		return resposne;
	}
	
}
