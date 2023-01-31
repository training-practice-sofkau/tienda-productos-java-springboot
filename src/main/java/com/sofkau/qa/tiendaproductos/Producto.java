package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
