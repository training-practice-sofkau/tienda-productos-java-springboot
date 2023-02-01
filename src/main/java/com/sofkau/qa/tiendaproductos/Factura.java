package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Component;

@Component
public class Factura {
    private final String nombreCliente;
    private final String nombreComponente;
    private final int cantidad;

    public Factura(String nombreCliente, String nombreComponente, int cantidad) {
        this.nombreCliente = nombreCliente;
        this.nombreComponente = nombreComponente;
        this.cantidad = cantidad;
    }

    public String getFactura() {
        return "Cliente: " + nombreCliente +
                "\nComponente: " + nombreComponente +
                "\nCantidad: " + cantidad;
    }
}
