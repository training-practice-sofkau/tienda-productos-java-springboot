package com.sofkau.qa.tiendaproductos.repository.models;

import org.springframework.stereotype.Component;

import java.util.UUID;
public class Producto {
    private String nombre;
    private int cantidadProducto;
    private int precio;

    private String id;

    public Producto(String id, String nombre, int cantidadProducto, int precio) {
        this.nombre = nombre;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.id = id;

    }

    public void disminuirStock(){
        this.cantidadProducto --;
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

    public String getId() {
        return id;
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
