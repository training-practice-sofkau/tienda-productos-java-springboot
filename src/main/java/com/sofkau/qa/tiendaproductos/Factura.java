package com.sofkau.qa.tiendaproductos;

import java.util.*;

public class Factura {
    int idProducto;
    String nombreCliente;
    private int valorTotal;
    Date fecha;
    Map<Producto, Integer> productos;

    public Factura(String nombreCliente)
    {
        fecha = new Date();
        this.nombreCliente = nombreCliente;
        productos = new HashMap<Producto, Integer>();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void añadirProducto(Producto producto, int cantidad) {
        this.idProducto = idProducto;
        var productoEnCarrito = productos.containsKey(producto);

        if(productoEnCarrito)
        {
            productos.put(producto, productos.get(producto) + 1);
        }
        else{
            productos.put(producto, cantidad);
        }

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getValorTotal() {
        int valorTotal = 0;

        for (Map.Entry<Producto, Integer> set : productos.entrySet())
        {
            valorTotal += set.getKey().getPrecioUnit() * set.getValue();
        }

        return valorTotal;
    }


    public String generarFactura()
    {
        this.valorTotal =  getValorTotal();

        return "La factura se genero para el cliente: " + this.getNombreCliente() + ", por un valor de: " + this.valorTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idProducto=" + getIdProducto() +
                ", nombreCliente='" + getNombreCliente() + '\'' +
                ", valorTotal=" + getValorTotal() +
                ", fecha=" + fecha;
    }
}
