
package com.ejercicio1.libreria.repository;


import com.ejercicio1.libreria.entity.Autor;
import com.ejercicio1.libreria.entity.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, String>{ 
    @Modifying
    @Query("UPDATE Editorial e SET e.nombre = :nombre WHERE e.id = :id")
    void modificar(@Param("id") String id, @Param("nombre") String nombre);
    
    @Modifying
    @Query("UPDATE Editorial e SET e.alta = :alta WHERE e.id = :id")
    void eliminar(@Param("id") String id, @Param("alta") boolean alta);
    
    @Query("SELECT e FROM Editorial e WHERE e.alta = TRUE")
    List<Editorial> mostrar();
}

