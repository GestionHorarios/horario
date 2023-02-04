package com.unicauca.edu.co.response;

import java.util.List;

import com.unicauca.edu.co.model.Curso;


public class CursoResponse {

    private List<Curso> curso;

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
}