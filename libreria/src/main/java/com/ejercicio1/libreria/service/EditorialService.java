
package com.ejercicio1.libreria.service;

import com.ejercicio1.libreria.entity.Editorial;
import com.ejercicio1.libreria.repository.EditorialRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialService {
    
    @Autowired
    private EditorialRepository editorialRepository;
    
    Editorial editorial = new Editorial();
    
    @Transactional
    public void crear(String id, String nombre) {
        
        
        editorial.setId(id);
        editorial.setNombre(nombre);
        
        editorialRepository.save(editorial);
    }
    
    @Transactional(readOnly = true)
    public List<Editorial> buscarTodo(){
//      return editorialRepository.findAll();
        return editorialRepository.mostrar();
    }
    
    @Transactional(readOnly = true)
    public Editorial buscarPorId(String id) {
        Optional<Editorial> editorialOptional = editorialRepository.findById(id);
        return editorialOptional.orElse(null);
    }

    @Transactional
    public void modificar(String id, String nombre) {
        editorialRepository.modificar(id, nombre);
    }
    
    @Transactional
    public void eliminar(String id, Boolean FALSE) {
        editorial.setAlta(FALSE);
        editorialRepository.eliminar(id, FALSE);

    }
}
