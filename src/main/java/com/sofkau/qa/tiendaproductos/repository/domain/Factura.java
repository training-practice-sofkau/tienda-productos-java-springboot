package com.sofkau.qa.tiendaproductos.repository.domain;

import java.util.List;

public class Factura {
    private String id;
    private String dato;
    private List<Producto> productos;

    public Factura(String id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    public String id() {
        return id;
    }

    public Factura setId(String id) {
        this.id = id;
        return this;
    }

    public String dato() {
        return dato;
    }

    public Factura setDato(String dato) {
        this.dato = dato;
        return this;
    }

    public List<Producto> productos() {
        return productos;
    }

    public Factura setProductos(List<Producto> productos) {
        this.productos = productos;
        return this;
    }
}
