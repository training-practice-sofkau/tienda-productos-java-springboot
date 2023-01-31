package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class Factura {
    private ArrayList<Producto> productos;
    private String cliente;
    private String fecha;


    public Factura() {
    }


    public Factura(String cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        productos = new ArrayList<Producto>();
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "productos=" + productos +
                ", cliente='" + cliente + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}