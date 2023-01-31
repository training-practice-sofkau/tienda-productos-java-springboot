package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String nombreCliente;
    public List<Producto> productosComprados;

    public Factura(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productosComprados = new ArrayList<Producto>();
    }

    public void agregarCompra(Producto producto, int cantidad) {
        if (cantidad > producto.getStock()) {
            System.out.println("No hay suficiente stock disponible para relizar la compra");
            return;
        }
        producto.setStock(producto.getStock() - cantidad);
        for (int i = 0; i < cantidad; i++) {
            productosComprados.add(producto);
        }
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }
}
