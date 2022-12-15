package com.unicauca.edu.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.edu.co.dao.IUbicacionDao;
import com.unicauca.edu.co.model.Ubicacion;
import com.unicauca.edu.co.response.UbicacionResponseRest;

@Service
public class UbicacionServiceImpl implements IUbicacionService {

	@Autowired
	private IUbicacionDao ubicacionDao;
	
	@Override
	public ResponseEntity<UbicacionResponseRest> listar() {
		UbicacionResponseRest response = new UbicacionResponseRest();
		try {
			List<Ubicacion> ubicacion = (List<Ubicacion>) ubicacionDao.findAll();
			
			response.getUbicacionResponse().setUbicacion(ubicacion);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<UbicacionResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UbicacionResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UbicacionResponseRest> buscarById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UbicacionResponseRest> guardar(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UbicacionResponseRest> actualizar(Ubicacion ubicacion, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UbicacionResponseRest> eliminarById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
