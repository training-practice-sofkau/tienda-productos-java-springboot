package com.sofkau.qa.tiendaproductos;

public class ProductoCompra extends Producto{

    private String nombre;
    private int id;
    private int cantidad;

    private double precio;

    public ProductoCompra(String nombre, int id, int cantidad, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        aplicarIva();
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoCompra{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public void aplicarIva() {
        this.precio=precio*1.20;
    }
}
