package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cafeteria {
    public List<Producto> productoList;

    public Cafeteria(){
        this.productoList = new ArrayList<>();
    }
    public void mostrarProductos (){
        productoList.stream().forEach(producto -> {
            System.out.println(producto.getNombreProducto() + " $"
                    + producto.getValor()
                    + " cantidad: "
                    + producto.getStock());
        });
    }

    public void agregarProductos(Producto producto){
        productoList.add(producto);
    }

    @Override
    public String toString() {
        return "\n---Lista de productos---\n" + productoList;
    }
}
