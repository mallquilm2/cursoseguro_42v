package edu.cibertec.cursoseguro.controller;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import edu.cibertec.cursoseguro.service.CursoService;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    Logger logger = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<CursoEntity> listarTodosCursos(){
        return cursoService.listarTodos();
    }

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public void insertarCurso(@RequestBody CursoEntity ce){
        try {
            cursoService.insertar(ce);
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Curso no pudo ser creado",null);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCurso(@PathVariable("id") int codigo){
        cursoService.eliminar(codigo);
    }


}
