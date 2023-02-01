package com.sofkau.qa.tiendaproductos;

import java.util.List;
import java.util.Scanner;

public class Factura {


    public String generarFactura (List<Orden> listaProductos){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre para generar factura: ");
        String nombre = scanner.nextLine();



        StringBuilder factura = new StringBuilder();

        factura.append("Factura para: " + nombre + "\n");

        double total=0;

        for (Orden orden: listaProductos) {
            factura.append(orden.getProducto() + " - " + orden.getPrice() + "\n");
            total += orden.getPrice();
        }

        factura.append("Total: " + total);
        return factura.toString();



    }


}
