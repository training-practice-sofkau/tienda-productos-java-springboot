package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;

public class Invoice {
    private String name;
    private double total;
    private ArrayList<Producto> productos;

    public Invoice(String name, double total, ArrayList<Producto> products) {
        this.name = name;
        this.total = total;
        this.productos = products;
    }

    public String getName() {
        return this.name;
    }

    public double getTotal() {
        return this.total;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public String toString() {
        String result = "Name: " + this.name + "\n";
        result += "Total: $" + this.total + "\n";
        result += "Products:\n";
        for (int i = 0; i < this.productos.size(); i++) {
            result += "  " + this.productos.get(i).toString() + "\n";
        }
        return result;
    }
}