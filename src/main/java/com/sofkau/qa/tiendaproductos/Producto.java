package com.sofkau.qa.tiendaproductos;
import java.util.Scanner;

public class Producto {
    /**
     * Atributos
     */
    private String nombreProducto;
    private int valor;
    private int stock;
    private int ID;

    public Producto(){

    }

    /**
     * Constructor
     * @param nombreProducto
     * @param valor
     * @param stock
     */
    public Producto(String nombreProducto, int valor, int stock) {
        this.nombreProducto = nombreProducto;
        this.valor = valor;
        this.stock = stock;
    }

    /**
     * Constructor que permitirá realizar el modificar y eliminar de API Rest
     */
    public Producto(int ID, String nombreProducto, int valor, int stock) {
        this.ID = ID;
        this.nombreProducto = nombreProducto;
        this.valor = valor;
        this.stock = stock;
    }

    /**
     * Métodos getters y setters
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Lista de productos: \n" +
                "Nombre del producto: " + nombreProducto + "\n" +
                "Valor: " + "$"+ valor + "\n" +
                "Cantidad: " + stock + "\n";
    }
}
