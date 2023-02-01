package com.rest.example.restexample;

import static com.rest.example.restexample.ProductoGuardado.productos;

public class ProductoOrdernado {
    private Producto producto;
    private int cantidad;

    public ProductoOrdernado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x " + cantidad + " ($" + producto.getPrecio() * cantidad + ")";
    }

}

