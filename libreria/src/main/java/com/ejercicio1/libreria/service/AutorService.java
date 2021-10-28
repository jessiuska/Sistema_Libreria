
package com.ejercicio1.libreria.service;

import com.ejercicio1.libreria.entity.Autor;
import com.ejercicio1.libreria.entity.Libro;
import com.ejercicio1.libreria.repository.AutorRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    Autor autor = new Autor();
    @Transactional
    public void crear(String id, String nombre){

        autor.setId(id);
        autor.setNombre(nombre);

        autorRepository.save(autor);
    }
    
    @Transactional(readOnly = true)
    public List<Autor> buscarTodo(){
        return autorRepository.mostrar();
//        return autorRepository.findAll();

    }
    
    @Transactional(readOnly = true)
    public Autor buscarPorId(String id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        return autorOptional.orElse(null);
    }
    
    @Transactional
    public void modificar(String id, String nombre) {
        autorRepository.modificar(id, nombre);
    }
    
    @Transactional
    public void eliminar(String id, Boolean FALSE) {
        autor.setAlta(FALSE);
        autorRepository.eliminar(id, FALSE);

    }
}
