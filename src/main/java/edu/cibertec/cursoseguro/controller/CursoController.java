package edu.cibertec.cursoseguro.controller;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import edu.cibertec.cursoseguro.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoController {

    Logger logger = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private CursoService cursoService;

    @RequestMapping("/")
    public String listar(){
        return "redirect:/cursoListar";
    }

    @RequestMapping("cursoListar")
    public ModelAndView mostrarCurso(){
        logger.debug("Listando los cursos");
        return new ModelAndView("curso", "lista",cursoService.listarTodos());
    }

    @RequestMapping("cursoGrabar")
    public ModelAndView grabarCurso(CursoEntity ce){
        logger.info("Anotesde insertar un curso");
        cursoService.insertar(ce);
        logger.warn("despues de insertar curso");
        return new ModelAndView("redirect:cursoListar");
    }

    @RequestMapping("cursoEliminar")
    public ModelAndView eliminarCurso(@RequestParam("codigo") int codigo){
        logger.info("Antes de eliminar un curso");
        cursoService.eliminar(codigo);
        logger.warn("despues de eliminar un curso");
        return new ModelAndView("redirect:cursoListar");
    }

}
