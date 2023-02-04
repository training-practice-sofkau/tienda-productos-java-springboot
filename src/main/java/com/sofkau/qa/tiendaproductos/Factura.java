package com.sofkau.qa.tiendaproductos;

import java.util.List;

public class Factura {
    private String customerName;
    private double total;
    private List<Producto> products;

    public Factura(String name, double total, List<Producto> products) {
        this.customerName = name;
        this.total = total;
        this.products = products;
    }

    public Factura(List<Producto> productos, String customerName) {

    }

    public String getName() {
        return customerName;
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura para el cliente:  " + customerName + ":\n");
        for (Producto producto : products) {
            sb.append("- " + producto.getName() + ", $" + producto.getPrice() +"\n");
        }
        sb.append("Total: $" + total + "\n");
        sb.append("Muchas gracias por tu compra ;) ");
        return sb.toString();
    }

    public static void add(Factura factura) {
    }
}
