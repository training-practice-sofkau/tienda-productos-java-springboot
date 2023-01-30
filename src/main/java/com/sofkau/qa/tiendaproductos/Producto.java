package com.sofkau.qa.tiendaproductos;

public class Producto {
    
    String nombre;
    String descripcion;
    int  cantidad;
    Double precio;

    public Producto(String nombre, String descripcion, int cantidad, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
