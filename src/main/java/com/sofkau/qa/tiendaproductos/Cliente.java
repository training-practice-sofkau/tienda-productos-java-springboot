package com.sofkau.qa.tiendaproductos;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String id;
    private List<CarritoCompra> cCompras;

    public Cliente(String nombre, String apellido, String id, List<CarritoCompra> cCompras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.cCompras = cCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
