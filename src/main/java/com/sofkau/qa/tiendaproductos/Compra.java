package com.sofkau.qa.tiendaproductos;

public class Compra {
    private Producto producto;
    private int cantidad;

    public Compra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
