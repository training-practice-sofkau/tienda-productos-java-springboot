package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String nombre;
    private int precio;
    private int unidades;

    public Producto(String nombre) {
        this.nombre = nombre;
    }


    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, int precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", unidades=" + unidades +
                '}';
    }
}
