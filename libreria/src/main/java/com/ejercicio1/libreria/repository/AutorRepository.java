
package com.ejercicio1.libreria.repository;


import com.ejercicio1.libreria.entity.Autor;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String>{
    
    @Modifying
    @Query("UPDATE Autor a SET a.nombre = :nombre WHERE a.id = :id")
    void modificar(@Param("id") String id, @Param("nombre") String nombre);
    
    @Modifying
    @Query("UPDATE Autor a SET a.alta = :alta WHERE a.id = :id")
    void eliminar(@Param("id") String id, @Param("alta") boolean alta);
    
    @Query("SELECT a FROM Autor a WHERE a.alta = TRUE")
    List<Autor> mostrar();
}
