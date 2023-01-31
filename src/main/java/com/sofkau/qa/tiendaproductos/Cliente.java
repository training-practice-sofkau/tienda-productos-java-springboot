package com.sofkau.qa.tiendaproductos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;

public class Cliente {

    private String nombre;
    private int Cc;
    List<Producto> carritoDeCompra;

    public Cliente(String nombre, int cc) {
        this.nombre = nombre;
        this.Cc = cc;
        carritoDeCompra  = new ArrayList<Producto>();
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
                "nombre='" + nombre + '\'' +
                ", Cc=" + Cc +
                ", carritoDeCompra=" + carritoDeCompra +
                '}';
    }

    public void agregarProducto(Producto producto) {
        carritoDeCompra.add(producto);
    }



}
