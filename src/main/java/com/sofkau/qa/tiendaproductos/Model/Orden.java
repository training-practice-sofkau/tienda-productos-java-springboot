package com.sofkau.qa.tiendaproductos.Model;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private String id;
    private String date;
    private List<Producto> productosComprados;

    public Orden(String id, String date){
        this.id = id;
        this.date = date;
        this.productosComprados = new ArrayList<>();
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

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List<Producto> productosComprados) {
        this.productosComprados = productosComprados;
    }
}
