package com.sofkau.qa.tiendaproductos;

public class Producto {

    private String name;
    private double price;
    private int quantity;
    private int id;

    public Producto(int id,String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.id=id;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return " - ID: "+id+ "- "+name + " - Precio: $" + price + " - Stock: " + quantity;
    }
}
