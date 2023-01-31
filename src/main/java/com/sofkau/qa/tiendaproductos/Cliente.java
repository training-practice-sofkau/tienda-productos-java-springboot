package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String id;
    private List<CarritoCompra> cCompras = new ArrayList<>();

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarritoCompra> getcCompras() {
        return cCompras;
    }

    public void setcCompras(List<CarritoCompra> cCompras) {
        this.cCompras = cCompras;
    }
}
