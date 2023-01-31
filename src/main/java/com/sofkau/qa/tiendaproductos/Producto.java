package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String nombre;
    // El precio del producto
    private Integer precio;

    // Constructor para crear un producto con un nombre y precio especificados
    public Producto(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Getter para obtener el precio del producto
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    // Sobreescritura del método toString para devolver una representación en forma de cadena de texto del producto
    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
