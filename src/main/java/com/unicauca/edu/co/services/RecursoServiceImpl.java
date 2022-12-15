package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.IRecursoDao;
import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;

@Service
public class RecursoServiceImpl implements IRecursoService{
	
	@Autowired
	private IRecursoDao recursoDao;

	@Override
	@Transactional
	public ResponseEntity<RecursoResponseRest> listar() {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			List<Recurso> recurso = (List<Recurso>) recursoDao.findAll();
			
			response.getRecursoResponse().setRecurso(recurso);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		}catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RecursoResponseRest> buscarById(Long id) {
		RecursoResponseRest response = new RecursoResponseRest();
		List<Recurso> list = new ArrayList<>();
		try {
			
			Optional<Recurso> recurso = recursoDao.findById(id);
			if(recurso.isPresent()) {
				list.add(recurso.get());
				response.getRecursoResponse().setRecurso(list);
				response.setMetadata("Respuesta ok", "00", "Recurso encontrado");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso no encontrado");
				return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RecursoResponseRest> guardar(Recurso recurso) {
		RecursoResponseRest response = new RecursoResponseRest();
		List<Recurso> list = new ArrayList<>();
		try {
			Recurso recursoSave = recursoDao.save(recurso);
			if(recursoSave!= null) {
				list.add(recursoSave);
				response.getRecursoResponse().setRecurso(list);
				response.setMetadata("Respuesta ok", "00", "Recurso Guardada");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso No Guardada");
				return new ResponseEntity<RecursoResponseRest> (response,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consular");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RecursoResponseRest> actualizar(Recurso recurso, Long id) {
		RecursoResponseRest response =  new RecursoResponseRest();
		List<Recurso> list = new  ArrayList<>();
		try {
			Optional<Recurso> recursoSearch = recursoDao.findById(id);
			if(recursoSearch.isPresent()) {
				recursoSearch.get().setRec_codigo(recurso.getRec_codigo());
				recursoSearch.get().setRec_descripcion(recurso.getRec_descripcion());

				
				Recurso recusoUpdate = recursoDao.save(recursoSearch.get());
				if(recusoUpdate != null) {
					list.add(recusoUpdate);
					response.getRecursoResponse().setRecurso(list);
					response.setMetadata("Respuesta ok", "00", "Recurso Actualizado");
				}else {
					response.setMetadata("Respuesta nok", "-1", "Recurso no Actualizado");
					return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.BAD_REQUEST);
				}
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso No encontrado");
				return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al actualizar");
			return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RecursoResponseRest> eliminarById(Long id) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			recursoDao.deleteById(id);
			response.setMetadata("Respuesta ok", "00", "Recurso eliminado");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}

}
