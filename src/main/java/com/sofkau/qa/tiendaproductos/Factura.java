package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String nombreCliente;
    public List<Producto> productosComprados;
    private int cantidad;

    /**
     * Metodo constructor
     *
     * @param nombreCliente
     */
    public Factura(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productosComprados = new ArrayList<Producto>();
    }

    /**
     * Metodo para mostrar los productos facturados
     */
    public void mostrarFactura() {
        System.out.println("Compras realizadas: ");
        productosComprados.forEach(producto -> {
            System.out.println(producto.getNombre() + "." + " precio $" + producto.getPrecio());
        });

    }

    /**
     * Metodo para agregar a la factura los productos con stock
     *
     * @param producto
     * @param cantidad
     */
    public void agregarCompra(Producto producto, int cantidad) {
        if (cantidad > producto.getStock()) {
            System.out.println("No hay suficiente stock disponible para relizar la compra");
            return;
        }
        producto.setStock(producto.getStock() - cantidad);
        for (int i = 0; i < cantidad; i++) {
            productosComprados.add(producto);
            this.cantidad = cantidad;
        }
    }

    /**
     * Metodos getters y setters
     *
     * @return
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
