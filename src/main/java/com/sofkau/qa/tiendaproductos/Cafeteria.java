package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cafeteria {
    public List<Producto> productoList;
    public List<Producto> productoEnStock;

    /**
     * Constructor
     */
    public Cafeteria(){
        this.productoList = new ArrayList<>();
    }

    /**
     * Método que permite mostrar los productos que están disponibles
     */
    public void mostrarProductos (){
        System.out.println("\n---Lista de productos disponibles---\n");

        this.productoEnStock = new ArrayList<>();

        for (Producto prod : productoList){
            if(prod.getStock() > 0){
                productoEnStock.add(prod);
            }
        }

        for (Producto prod : productoEnStock){
            System.out.println("Producto: " + prod.getNombreProducto() + "\n"
                    + "Precio: $" + prod.getValor() + "\n"
                    + "Cantidad: " + prod.getStock()
                    + "\n"
            );
        }
    }

    /**
     * Método que permite agregar un nuevo producto
     * @param producto
     */
    public void agregarProductos(Producto producto){
        System.out.println("Producto añadido: " + producto.getNombreProducto());
        productoList.add(producto);
    }

    @Override
    public String toString() {
        return "\n---Lista de productos---\n" + productoList;
    }
}
