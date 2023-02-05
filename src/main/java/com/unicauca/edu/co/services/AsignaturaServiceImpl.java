package com.unicauca.edu.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.ICursoDao;
import com.unicauca.edu.co.model.Curso;
import com.unicauca.edu.co.response.CursoResponseRest;

@Service
public class AsignaturaServiceImpl implements  IAsignaturaService{
	
	@Autowired
    private IAsignaturaDao asignaturaDao;

    //Listar todas las asignaturas
    @Override
    @Transactional (readOnly = true)
    public ResponseEntity<AsignaturaResponseRest> listar() {
        AsignaturaResponseRest response = new AsignaturaResponseRest();
        try {
            List<Asignatura> asignatura = (List<Asignatura>) asignaturaDao.findAll();
            response.getCursoResponse().setAsignatura(asignatura);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<AsignaturaResponseRest> buscarById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AsignaturaResponseRest> guardar(Asignatura asignatura, String curtip_codigo, String fac_codigo, String ubi_codigo) {
        return null;
    }
       
   //Asignatura por Facultad
    
  	@Override
  	public ResponseEntity<AsignaturaResponseRest> asignaturasPorFacultad(String fac_codigo) {
  		CursoResponseRest response = new CursoResponseRest();
  		try {
  			List<Curso> list = asignaturaDao.listaByFacultad(fac_codigo);
  			response.getAsignaturaResponse().setAsignatura(list);
  			response.setMetadata("Respuesta ok", "00", "Asignaturas encontradas");
  		} catch (Exception e) {
  			response.setMetadata("Respuesta nok", "-1", "Error al buscar Asignaturas");
  			return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  		return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.OK);
  	}
}
