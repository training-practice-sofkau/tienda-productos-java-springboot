package com.sofkau.qa.tiendaproductos;
import java.util.List;

public class Factura {
    private String nombreCliente;
    private List<CarritoCompras> productosVendidos;
    private double total;

    public Factura(String nombreCliente, List<CarritoCompras> productosVendidos, double total) {
        this.nombreCliente = nombreCliente;
        this.productosVendidos = productosVendidos;
        this.total = total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<CarritoCompras> getProductosVendidos() {
        return productosVendidos;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", productosComprados=" + productosVendidos +
                ", total=" + total +
                '}'+"\n";
    }
}
