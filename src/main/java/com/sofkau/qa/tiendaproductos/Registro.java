package com.sofkau.qa.tiendaproductos;

import java.util.List;

public class Registro {
    private String nombre;
    private List<DetalleRegistro> detalle;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
