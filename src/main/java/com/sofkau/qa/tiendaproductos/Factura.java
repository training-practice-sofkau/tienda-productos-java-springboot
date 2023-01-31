package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String Nombre;
    private List<ProductoOrdernado> Ordenes;

    // Constructor que toma el nombre del cliente y la lista de productos ordenados como argumentos
    public Factura(String Nombre, List<ProductoOrdernado> Ordenes) {
        this.Nombre = Nombre;
        this.Ordenes = Ordenes;
    }
    // Sobrescribir el método toString para imprimir la factura en formato legible
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // Agregar el encabezado de la factura con el nombre del cliente
        builder.append("Factura para el cliente " + Nombre + ":\n");
        int total = 0;
        // Iterar a través de la lista de productos ordenados y calcular el total
        for (ProductoOrdernado orden : Ordenes) {
            builder.append(orden + "\n");
            total += orden.getProducto().getPrecio() * orden.getCantidad();
        }
        // Agregar el total de la factura
        builder.append("Total: $" + total);
        return builder.toString();
    }
}

