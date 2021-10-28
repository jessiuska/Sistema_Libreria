
package com.ejercicio1.libreria.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editorial {
    @Id
    private String id;
    private String nombre;
    private Boolean alta;
    @OneToMany(mappedBy="editorial")
    private List<Libro> libros;

    public Editorial() {
        libros = new ArrayList();
        alta=true;
    }

    public Editorial(String id, String nombre, Boolean alta, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
        this.libros = libros;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    
    
    
}

