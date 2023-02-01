package com.sofkau.qa.tiendaproductos;

public class Compra {
    private final String nombreCliente;
    private final String nombreComponente;
    private final int cantidad;
    public final int total;

    public Compra(String nombreCliente, String nombreComponente, int cantidad, int precio) {
        this.nombreCliente = nombreCliente;
        this.nombreComponente = nombreComponente;
        this.cantidad = cantidad;
        this.total = precio * cantidad;
    }

    public String getCompra() {
        return "Cliente: " + nombreCliente +
                ", Componente: " + nombreComponente +
                ", Cantidad: " + cantidad +
                " | Por valor de: $" + total;
    }
}