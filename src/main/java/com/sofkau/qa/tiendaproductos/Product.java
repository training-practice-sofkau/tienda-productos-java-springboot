package com.sofkau.qa.tiendaproductos;


import java.util.ArrayList;
import java.util.List;

public class Product {
    private String Id;
    private String name;
    private String description;
    public double price;
    public int stock;
    private ArrayList<Product> producto;

    public Product(String id, String name, String description, double price, int stock) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void verProductos() {
        this.producto = new ArrayList<>();

    }

    @Override
    public String toString() {
        return this.Id + "-" +this.name;
    }


}
