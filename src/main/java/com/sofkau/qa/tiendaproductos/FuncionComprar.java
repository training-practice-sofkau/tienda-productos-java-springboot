package com.sofkau.qa.tiendaproductos;

import java.util.Scanner;

import static com.sofkau.qa.tiendaproductos.TiendaProductosApplication.*;

public class FuncionComprar {
    public void comprar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre() + " - $" + productos.get(i).getPrecio() + " - Stock: " + productos.get(i).getStock());
        }
        System.out.print("Seleccione un producto (por número): ");
        int productoSeleccionado = sc.nextInt() - 1;
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidad = sc.nextInt();
        if (cantidad > productos.get(productoSeleccionado).getStock()) {
            System.out.println("Lo siento, no tenemos suficiente stock");
        } else {
            productos.get(productoSeleccionado).setStock(productos.get(productoSeleccionado).getStock() - cantidad);
            compras.add(new Compra(productos.get(productoSeleccionado), cantidad));
            System.out.println("Compra realizada con éxito");
            System.out.println("Factura:");
            System.out.println("Producto: " + productos.get(productoSeleccionado).getNombre());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio unitario: $" + productos.get(productoSeleccionado).getPrecio());
            System.out.println("Total: $" + (productos.get(productoSeleccionado).getPrecio() * cantidad));
        }

    }
}
