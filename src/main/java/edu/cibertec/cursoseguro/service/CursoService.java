package edu.cibertec.cursoseguro.service;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.CursoEntity;

import java.util.List;

public interface CursoService {

    public List<CursoEntity> listarTodos();

    public void insertar(CursoEntity ce);

    public void eliminar(int codigo);

}
