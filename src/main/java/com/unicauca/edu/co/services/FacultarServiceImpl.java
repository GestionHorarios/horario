package com.unicauca.edu.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.edu.co.dao.IFacultadDao;
import com.unicauca.edu.co.model.Facultad;
import com.unicauca.edu.co.response.FacultadResponseRest;

@Service
public class FacultarServiceImpl implements IFacultadService{

	@Autowired
	private IFacultadDao facultadDao;
	
	@Override
	public ResponseEntity<FacultadResponseRest> listar() {
		FacultadResponseRest response = new FacultadResponseRest();
		try {
			List<Facultad> facultad = (List<Facultad>) facultadDao.findAll();
			
			response.getFaculdatResponse().setFacultad(facultad);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		}catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<FacultadResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FacultadResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<FacultadResponseRest> buscarById(String fac_cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FacultadResponseRest> guardar(Facultad facultad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FacultadResponseRest> actualizar(Facultad facultad, String fac_cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FacultadResponseRest> eliminarById(String fac_cod) {
		// TODO Auto-generated method stub
		return null;
	}

}
