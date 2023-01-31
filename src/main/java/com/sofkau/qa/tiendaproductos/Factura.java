package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class Factura {
    private ArrayList<Producto> productos;
    private String cliente;
    private String fecha;


    public Factura() {
    }

    public Factura(String cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        productos = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }



}