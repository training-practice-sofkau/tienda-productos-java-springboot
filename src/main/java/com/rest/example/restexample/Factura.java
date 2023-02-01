package com.rest.example.restexample;

import java.util.List;

public class Factura {
    private String Nombre;
    private List<ProductoOrdernado> Ordenes;

    public Factura(String Nombre, List<ProductoOrdernado> Ordenes) {
        this.Nombre = Nombre;
        this.Ordenes = Ordenes;
    }

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
        builder.append("Total: $" + total);
        return builder.toString();
    }
}
