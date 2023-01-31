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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCc() {
        return Cc;
    }

    public void setCc(int cc) {
        Cc = cc;
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
