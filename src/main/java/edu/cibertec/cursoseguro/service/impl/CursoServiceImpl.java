package edu.cibertec.cursoseguro.service.impl;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.edu.cibertec.cursoseguro.dao.repository.CursoRepository;
import edu.cibertec.cursoseguro.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public List<CursoEntity> listarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public void insertar(CursoEntity ce) {
        cursoRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        cursoRepository.deleteById(codigo);
    }
}
