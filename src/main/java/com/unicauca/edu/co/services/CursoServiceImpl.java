package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import com.unicauca.edu.co.model.Curso;
import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.CursoResponseRest;
import com.unicauca.edu.co.response.RecursoResponseRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;

import com.unicauca.edu.co.dao.ICursoDao;

@Service
public class CursoServiceImpl implements  ICursoService {

    @Autowired
    private ICursoDao cursoDao;



    //Listar todos los cursos
    @Override
    @Transactional (readOnly = true)
    public ResponseEntity<CursoResponseRest> listar() {
        CursoResponseRest response = new CursoResponseRest();
        try {
            List<Curso> curso = (List<Curso>) cursoDao.findAll();
            response.getCursoResponse().setCurso(curso);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CursoResponseRest>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CursoResponseRest> buscarById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CursoResponseRest> guardar(Curso curso, String curtip_codigo, String fac_codigo, String ubi_codigo) {
        return null;
    }

    @Override
    public ResponseEntity<CursoResponseRest> eliminarById(Long id) {
        return null;
    }
    
   // otro lado:    
   //Curso por Facultad
    
  	@Override
  	public ResponseEntity<CursoResponseRest> cursosPorFacultad(String fac_codigo) {
  		CursoResponseRest response = new CursoResponseRest();
  		try {
  			List<Curso> list = cursoDao.listaByFacultad(fac_codigo);
  			response.getCursoResponse().setCurso(list);
  			response.setMetadata("Respuesta ok", "00", "Cursos encontrados");
  		} catch (Exception e) {
  			response.setMetadata("Respuesta nok", "-1", "Error al buscar cursos");
  			return new ResponseEntity<CursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  		return new ResponseEntity<CursoResponseRest>(response, HttpStatus.OK);
  	}
}