package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.ITipoRecursoDao;
import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.model.Tiporecurso;
import com.unicauca.edu.co.response.TipoRecursoResponseRest;

@Service
public class TipoRecursoServiceImpl implements ITipoRecursoService{

	@Autowired
	private ITipoRecursoDao tiporecursoDao;
	
	@Override
	public ResponseEntity<TipoRecursoResponseRest> listar() {
		TipoRecursoResponseRest response = new TipoRecursoResponseRest();
		try {
			List<Tiporecurso> recurso = (List<Tiporecurso>) tiporecursoDao.findAll();
			response.getTiporecursoResponse().setTiporecurso(recurso);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<TipoRecursoResponseRest> buscarById(String id) {
		TipoRecursoResponseRest response = new TipoRecursoResponseRest();
		List<Tiporecurso> list = new ArrayList<>();
		try {
			Optional<Tiporecurso> tiporecurso = tiporecursoDao.findById(id);
			
			if(tiporecurso.isPresent()) {
				list.add(tiporecurso.get());
				response.getTiporecursoResponse().setTiporecurso(list);
				response.setMetadata("respuesta ok", "00", "tipo recurso encontrado");
			}else {
				response.setMetadata("respuesta ok", "-1", "tipo recurso no encontrado");
				return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.getStackTrace();
			response.setMetadata("respuesta ok", "-1", "Error al buscar tipo de recurso");
			return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> guardar(Recurso recurso, String rectipo_codigo, String fac_codigo,
			String ubi_codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> actualizar(Recurso recurso, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> eliminarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
