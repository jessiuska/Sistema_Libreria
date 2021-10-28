
package com.ejercicio1.libreria.repository;


import com.ejercicio1.libreria.entity.Editorial;
import com.ejercicio1.libreria.entity.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>{
    @Modifying
    @Query("UPDATE Libro l SET l.isbn = :isbn, l.titulo = :titulo, l.anio = :anio, l.ejemplares = :ejemplares, l.ePrestados = :ePrestados, l.eRestantes = :eRestantes WHERE l.id = :id")
    void modificar(@Param("id") String id, @Param("isbn") Long isbn,
            @Param("titulo") String titulo,
            @Param("anio") Integer anio, @Param("ejemplares") Integer ejemplares,
            @Param("ePrestados") Integer ePrestados, @Param("eRestantes") Integer eRestantes);
    
    @Modifying
    @Query("UPDATE Libro l SET l.alta = :alta WHERE l.id = :id")
    void eliminar(@Param("id") String id, @Param("alta") boolean alta);
    
    @Query("SELECT l FROM Libro l WHERE l.alta = TRUE")
    List<Libro> mostrar();
}
