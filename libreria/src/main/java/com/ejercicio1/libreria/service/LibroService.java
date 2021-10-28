
package com.ejercicio1.libreria.service;

import com.ejercicio1.libreria.entity.Autor;
import com.ejercicio1.libreria.entity.Editorial;
import com.ejercicio1.libreria.entity.Libro;
import com.ejercicio1.libreria.repository.AutorRepository;
import com.ejercicio1.libreria.repository.EditorialRepository;
import com.ejercicio1.libreria.repository.LibroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    
    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private EditorialRepository editorialRepository;
    
    
    Libro libro= new Libro();
    
    @Transactional
    public void crear(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ePrestados, Integer eRestantes, String idAutor, String idEditorial){

        libro.setId(id);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setePrestados(ePrestados);
        libro.seteRestantes(eRestantes);
        libro.setAutor(autorRepository.findById(idAutor).orElse(null));
        libro.setEditorial(editorialRepository.findById(idEditorial).orElse(null));

        libroRepository.save(libro);
        
    }
   
    
    @Transactional(readOnly = true)
    public List<Libro> buscarTodo(){
//        return libroRepository.findAll();
        return libroRepository.mostrar();
    }
    
    @Transactional(readOnly = true)
    public Libro buscarPorId(String id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        return libroOptional.orElse(null);
    }
    
    @Transactional
    public void modificar(String id, Long isbn,String titulo, Integer anio, Integer ejemplares, Integer ePrestados, Integer eRestantes) {
        libroRepository.modificar(id, isbn, titulo, anio, ejemplares, ePrestados, eRestantes);
    }
    
    @Transactional
    public void eliminar(String id, Boolean FALSE) {
        libro.setAlta(FALSE);
        libroRepository.eliminar(id, FALSE);

    }
}
