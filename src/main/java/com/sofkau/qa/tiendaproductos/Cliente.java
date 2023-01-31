package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

@Service
public class Cliente {
    private String nombre,id;
    private Long dinero;
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
}
