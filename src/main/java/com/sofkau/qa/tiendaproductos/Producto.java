package com.sofkau.qa.tiendaproductos;

public class Producto {
    private String name;
    private double price;
    private int quantity;

    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Producto(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return this.name + " - $" + this.price + " x " + this.quantity;
    }
}