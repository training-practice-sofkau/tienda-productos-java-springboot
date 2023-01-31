package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String nombre;
    private Integer precio;

    // Constructor para crear un producto con un nombre y precio especificados
    public Producto(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getPrecio() {
        return precio;
    }
    // Sobreescritura del método toString para devolver una representación en forma de cadena de texto del producto
    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
