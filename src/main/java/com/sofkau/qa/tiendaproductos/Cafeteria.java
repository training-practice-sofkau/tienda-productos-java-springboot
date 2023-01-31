package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Cafeteria {
    public List<Producto> productoList;
    public List<Producto> productoEnStock;
    private ArrayList<Factura> facturas;

    /**
     * Constructor
     */
    public Cafeteria(){
        this.productoList = new ArrayList<>();
        this.facturas = new ArrayList<>();
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

        int indice = 1;

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

    public void iniciarCompra (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nombre del cliente: ");
        String nombreCliente = entrada.nextLine();

        Factura factura = new Factura(nombreCliente);

        this.mostrarProductos();

        boolean comprando = true;
        while (comprando){
            System.out.println("¿Qué producto deseas? ");
        }
    }

    @Override
    public String toString() {
        return "\n---Lista de productos---\n" + productoList;
    }
}
