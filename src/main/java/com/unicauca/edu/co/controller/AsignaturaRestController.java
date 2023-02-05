package com.unicauca.edu.co.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unicauca.edu.co.response.CursoResponseRest;
import com.unicauca.edu.co.services.ICursoService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")

public class AsignaturaRestController {
	@Autowired
    private IAsignaturaService asignaturaService;

    //obtenemos todas las asignaturas
    @GetMapping("/asignaturas")
    private ResponseEntity<AsignaturaResponseRest> listarAsignaturas(){
        ResponseEntity<AsignaturaResponseRest> response = asignaturaService.listar();
        return response;
    }

    //busca asignatura por id
    @GetMapping("/asignatura/{id}")
    private ResponseEntity<AsignaturaResponseRest> buscarAsignaturaPorId(@PathVariable("id") Long id){
        ResponseEntity<AsignaturaResponseRest> response = asignaturaService.buscarById(id);
        return response;
    }


  //Asignatura por Facultad
  	@GetMapping("/asignaturas/facultad/{fac_codigo}")
  	public ResponseEntity<AsignaturaResponseRest> asignaturasPorFacultad(@PathVariable String fac_codigo){
  		ResponseEntity<AsignaturaResponseRest> response = asignaturaService.asignaturaPorFacultad(fac_codigo);
  		return response;
  	}
}
