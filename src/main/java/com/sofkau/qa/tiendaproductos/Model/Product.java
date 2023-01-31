package com.sofkau.qa.tiendaproductos.Model;

public class Product {

    private int id;
    private String name;
    private int price;
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product( String name, int price, int amount,int id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int valorTotal (){
       return this.amount * this.price;
    };

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
