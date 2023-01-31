package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Ferreteria {

    public List<Producto> productoList;

    public Ferreteria() {
        this.productoList = new ArrayList<>();
    }

    public void mostrarProductos() {
        productoList.stream().forEach(producto -> {
            System.out.println(producto.getNombre() + "." + "\nprecio $" + producto.getPrecio() + "\nStock: " + producto.getStock() + "\n");
        });
    }

    public void agregarProductos(Producto producto) {
        productoList.add(producto);
    }

}
