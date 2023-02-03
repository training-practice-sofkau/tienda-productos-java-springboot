package com.sofkau.qa.tiendaproductos;

public class Orden {
    private Producto producto;
    private int quantity;
    private double price;

    public Orden(Producto producto, int quantity, double price) {
        this.producto = producto;
        this.quantity = quantity;
        this.price = price;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}