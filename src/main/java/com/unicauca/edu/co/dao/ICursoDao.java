package com.unicauca.edu.co.dao;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Curso;

public interface ICursoDao extends CrudRepository<Curso, Long> {

}
