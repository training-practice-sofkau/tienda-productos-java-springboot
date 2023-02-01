package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class Producto {
    private String nombre;
    private int cantidadProducto;
    private int precio;

    String id;

    public Producto(String id, String nombre, int cantidadProducto, int precio) {
        this.nombre = nombre;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.id = id;

    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }



    public int getCantidadProducto() {
        return cantidadProducto;
    }


    public int getPrecio() {
        return precio;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidadProducto=" + cantidadProducto +
                ", precio=" + precio +
                '}';
    }
}
