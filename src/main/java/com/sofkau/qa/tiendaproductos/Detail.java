package com.sofkau.qa.tiendaproductos;

public class Detail {

    private String id;
    private Product product;
    private int quantity;
    private double amount;


    public Detail(String id, Product product, int quantity, double amount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
