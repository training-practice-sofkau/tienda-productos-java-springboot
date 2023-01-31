package com.sofkau.qa.tiendaproductos;

public class Producto {
    String nombre;
    double precioUnit;
    int idProducto;

    public Producto(String nombre, double precioUnit, int idProducto) {
        this.nombre = nombre;
        this.precioUnit = precioUnit;
        this.idProducto = idProducto;
    }
    @Override
    public String toString() {
        return '\n' +"Producto: " +
                "Nombre del Producto: '" + nombre +
                ", Precio por unidad: " + precioUnit +
                ", Numero del producto: " + idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
