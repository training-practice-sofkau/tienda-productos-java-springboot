package com.sofkau.qa.tiendaproductos;

import java.util.List;

public class Cliente {

    private String nombre;

    private Integer id;

    List<Producto> carrito;

    public Cliente(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", carrito=" + carrito +
                '}';
    }

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }
}
