package com.rest.example.restexample;

import java.util.Objects;

public class Producto {

    private String id;
    private String Nombre;
    private int precioUnit;

    public Producto(String id, String Nombre, int precioUnit) {
        this.id = id;
        this.Nombre = Nombre;
        this.precioUnit = precioUnit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(int precioUnit) {
        this.precioUnit = precioUnit;
    }

    @Override
    public String toString() {
        return "Producto: " +
                "id: " + id + '\'' +
                ", Nombre: " + Nombre + '\'' +
                ", Precio unitario" + precioUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(Nombre, producto.Nombre) && Objects.equals(precioUnit, producto.precioUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Nombre, precioUnit);
    }
}
