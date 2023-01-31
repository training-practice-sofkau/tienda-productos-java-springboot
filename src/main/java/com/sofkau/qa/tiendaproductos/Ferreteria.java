package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Ferreteria {

    public List<Producto> productoList;
    public List<Producto> productoStock;
    public Ferreteria() {
        this.productoList = new ArrayList<>();
    }

    public void agregarProductos(Producto producto) {
        productoList.add(producto);
    }

    public void productosDisponibles() {
        this.productoStock = new ArrayList<>();

        for (Producto p : productoList) {
            if (p.getStock() > 0) {
                productoStock.add(p);
            }
        }

        productoStock.stream().forEach(p -> {
            System.out.println(p.getNombre() + "." + "\nprecio $" + p.getPrecio() + "\nStock: " + p.getStock() + "\n");
        });
    }


}
