package com.unicauca.edu.co.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.unicauca.edu.co.model.Curso;

public interface ICursoDao extends CrudRepository<Curso, Long> {
    @Query("SELECT c from Curso c where c.cur_id LIKE %?1%")
    List<Curso> findByCur_id(String cur_id);
}