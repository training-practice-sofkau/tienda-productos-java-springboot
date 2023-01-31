package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String nombre;
    private int cantidadProducto;
    private int precio;

    public Producto(String nombre, int cantidadProducto, int precio) {
        this.nombre = nombre;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
