
package com.ejercicio1.libreria.controller;

import com.ejercicio1.libreria.entity.Autor;
import com.ejercicio1.libreria.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;
    
    //INDEX
    
    @GetMapping
    public ModelAndView mostrarLibros(){
        ModelAndView mav = new ModelAndView("autor");
        mav.addObject("autores", autorService.buscarTodo());
//        mav.addObject("autores", autorService.buscarTodo());
        return mav;
    }
    
    //PARA CREAR Y GUARDAR
    
    @GetMapping("/crear")
    public ModelAndView crearAutor() {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", new Autor());
        mav.addObject("title", "Crear Autor");
        mav.addObject("action", "guardar");
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String id, @RequestParam String nombre) {
        autorService.crear(id, nombre);
        return new RedirectView("/autores");
    }
    
    //PARA EDITAR
    
    @GetMapping("/editar/{id}")
    public ModelAndView editarAutor(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", autorService.buscarPorId(id));
        mav.addObject("title", "Editar Autor");
        mav.addObject("action", "modificar");
        return mav;
    }
    
    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String nombre) {
        autorService.modificar(id, nombre);
        return new RedirectView("/autores");
    }
    
    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        autorService.eliminar(id, Boolean.FALSE);
        return new RedirectView("/autores");
    }
}
