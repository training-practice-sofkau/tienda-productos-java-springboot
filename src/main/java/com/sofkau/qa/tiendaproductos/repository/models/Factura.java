package com.sofkau.qa.tiendaproductos.repository.models;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private String id;
    private String date;
    private List<Producto> productos;

    public Factura(String id, String date){
        this.id = id;
        this.date = date;
        this.productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
