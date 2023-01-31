package com.sofkau.qa.tiendaproductos;

public class ProductoCompra {

    private String nombre;
    private int id;
    private int cantidad;

    public ProductoCompra(String nombre, int id, int cantidad) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoCompra{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }
}
