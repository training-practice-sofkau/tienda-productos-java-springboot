package com.sofkau.qa.tiendaproductos.repository.domain;

import java.util.UUID;
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidadProducto;

    public Producto(String id, String nombre, double precio, int cantidadProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
    }

    public String getId() {
        return id;
    }

    public Producto setId(String id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public Producto setCantidadProducto(int cantidad) {
        this.cantidadProducto = cantidad;
        return this;
    }

    public void reducirArticulosAlmacen(){
        this.cantidadProducto--;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", producto='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidadProducto +
                '}';
    }
}
