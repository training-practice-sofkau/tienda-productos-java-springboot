package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String Nombre;
    private List<ProductoOrdernado> Ordenes;

    public Factura(String Nombre, List<ProductoOrdernado> Ordenes) {
        this.Nombre = Nombre;
        this.Ordenes = Ordenes;
    }

    public Factura(String nombre, ArrayList<Producto> productosComprados, double total) {
    }

    public String getNombre() {
        return Nombre;
    }

    public List<ProductoOrdernado> getOrdenes() {
        return Ordenes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Factura para el cliente " + Nombre + ":\n");
        int total = 0;
        for (ProductoOrdernado orden : Ordenes) {
            builder.append(orden + "\n");
            total += orden.getProducto().getPrecio() + orden.getPrecio * orden.getCantidad();
        }
        builder.append("Total: $" + total);
        return builder.toString();
    }
}
