package com.sofkau.qa.tiendaproductos;

/**
 * Clase que representa un producto de la ferreteria
 */
public class Producto {
    /**
     * Atributos
     */
    private String nombre;
    private int precio;
    private int stock;

    /**
     * Método Constructor
     *
     * @param nombre
     * @param precio
     * @param stock
     */
    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Metodos getters y setters
     *
     * @return
     */
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
