package com.sofkau.qa.tiendaproductos;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;

@Service
public class Cliente {
    String id = String.valueOf(UUID.randomUUID());
    private String nombre;
    private int Cc;
    List<Producto> carritoDeCompra;

    public Cliente(String nombre, int cc) {
        this.nombre = nombre;
        this.Cc = cc;
        carritoDeCompra  = new ArrayList<Producto>();
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }



    public int getCc() {
        return Cc;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Cc=" + Cc +
                '}';
    }

    public void agregarProducto(Producto producto) {
        carritoDeCompra.add(producto);
    }



}
