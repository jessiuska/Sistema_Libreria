
package com.ejercicio1.libreria.controller;

import com.ejercicio1.libreria.entity.Libro;
import com.ejercicio1.libreria.service.AutorService;
import com.ejercicio1.libreria.service.EditorialService;
import com.ejercicio1.libreria.service.LibroService;
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
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @Autowired
    private AutorService autorService;
    
    @Autowired
    private EditorialService editorialService;
    
    @GetMapping
    public ModelAndView mostrarLibros(){
        ModelAndView mav = new ModelAndView("libro");
        mav.addObject("libros", libroService.buscarTodo());
        return mav;
    }
    
    @GetMapping("/crear")
    public ModelAndView crearLibro() {
        ModelAndView mav = new ModelAndView("libro-formulario");
        mav.addObject("libro", new Libro());
        mav.addObject("autores", autorService.buscarTodo());
//        mav.addObject("autores", autorService.buscarTodo());
        mav.addObject("editoriales", editorialService.buscarTodo());
        mav.addObject("title", "Crear Libro");
        mav.addObject("action", "guardar");
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String id, @RequestParam Long isbn, 
            @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, 
            @RequestParam Integer ePrestados, @RequestParam Integer eRestantes, 
            @RequestParam("autor") String idAutor, @RequestParam("editorial") String idEditorial) {
        libroService.crear(id, isbn, titulo, anio, ejemplares, ePrestados, eRestantes,
            idAutor, idEditorial);
        return new RedirectView("/libros");
    }
    
    @GetMapping("/editar/{id}")
    public ModelAndView editarLibro(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("libro-formulario");
        mav.addObject("libro", libroService.buscarPorId(id));
//        mav.addObject("autor", autorService.buscarTodo());
        mav.addObject("autor", autorService.buscarTodo());
        mav.addObject("editorial", editorialService.buscarTodo());
        mav.addObject("title", "Editar Libro");
        mav.addObject("action", "modificar");
        return mav;
    }
    
    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ePrestados, @RequestParam Integer eRestantes) {
        libroService.modificar(id, isbn, titulo, anio, ejemplares, ePrestados, eRestantes);
        return new RedirectView("/libros");
    }
    
    
    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        libroService.eliminar(id, Boolean.FALSE);
        return new RedirectView("/libros");
    }
}
