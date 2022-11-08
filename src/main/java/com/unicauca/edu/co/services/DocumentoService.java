package com.unicauca.edu.co.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.edu.co.response.ResponseRest;

@Service
public class DocumentoService {
	
	public ResponseEntity<Object> trabajarDocumento(MultipartFile file)  {
		ResponseRest response = new ResponseRest();
		if(!file.isEmpty()) {
//esparcio para trabajar file que es el archivo
							   // nombre del archivo	//lo spliteo por(.) como puede tener varios . en el nombre solo uso la ultima posición
			String extension = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
			if(extension.equals("xlsx")) {
				
			}
//fin espacio para trabajar file 
			response.setMetadata("Respuesta ok", "00", "Si hay archivo");
		}
		else {
			response.setMetadata("Respuesta nok", "-1", "No se envio archivo");
			return new ResponseEntity<Object> (response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object> (response, HttpStatus.OK);
	}
	
}
