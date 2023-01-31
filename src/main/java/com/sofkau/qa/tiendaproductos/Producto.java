package com.sofkau.qa.tiendaproductos;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(int id, String nombre, int precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
