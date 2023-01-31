package com.sofkau.qa.tiendaproductos;



public class Product {
    private String Id;
    private String name;
    private String description;
    public double price;
    public int stock;

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

    @Override
    public String toString() {
        return "Product{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
