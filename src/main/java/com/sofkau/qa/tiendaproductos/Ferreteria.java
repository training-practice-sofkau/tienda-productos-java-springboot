package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Ferreteria {

    public List<Producto> productoList;
    public List<Producto> productoStock;
    private ArrayList<Factura> facturas;
    private Factura facturaEnCurso;


    public Ferreteria() {
        this.productoList = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    /**
     * Metodo para agregar productos a la lista de productos
     *
     * @param producto
     */
    public void agregarProductos(Producto producto) {
        productoList.add(producto);
    }

    /**
     * Metodo para agregar a la lista productos stock y mostrar los productos con stock
     *
     * @return
     */

    public void productosDisponibles() {
        this.productoStock = new ArrayList<>();
        int indice = 1;
        for (Producto p : productoList) {
            if (p.getStock() > 0) {
                productoStock.add(p);
            }
        }

        for (Producto p : productoStock) {
            System.out.println(indice + "." + p.getNombre() + "." + "\nprecio $" + p.getPrecio() + "\nStock: " + p.getStock() + "\n");
            indice++;
        }

    }

    public void imprimirHistorialVentas() {
        int contador = 1;
        for (Factura factura :this.facturas) {
            System.out.println("#" + contador + " - " + factura.getNombreCliente() + "");
            contador = contador + 1;
        }

    }

    public void iniciarCompra() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce tu nombre:");
        String nombreCliente = in.nextLine();

        this.facturaEnCurso = new Factura(nombreCliente);

        boolean continuarComprando = true;
        while (continuarComprando) {
            System.out.println("Productos disponibles");
            this.productosDisponibles();

            System.out.println("Selecciona un producto (Ingrese un numero entre 1 y " + this.productoStock.size() + ") o ingrese 0 para finalizar la compra");
            int opcion =in.nextInt();
            in.nextLine();

            if (opcion == 0) {
                continuarComprando = false;
                break;
            }
            Producto productoSeleccionado = this.productoStock.get(opcion - 1);
            if (productoSeleccionado.getStock() == 0) {
                System.out.println("Lo sentimos, el producto está agotado.");
                continue;
            }

            int unidadesDisponibles = productoSeleccionado.getStock();
            System.out.println("Unidades disponibles: " + unidadesDisponibles);
            System.out.println("Ingrese la cantidad a comprar: ");
            int cantidad = in.nextInt();
            in.nextLine();

            if (cantidad > unidadesDisponibles) {
                System.out.println("Lo sentimos no tenemos suficiente stock");
            }
            facturaEnCurso.agregarCompra(productoSeleccionado,cantidad);
        }

        System.out.println("Cliente" + facturaEnCurso.getNombreCliente());
        System.out.println("Productos comprados:");
        facturaEnCurso.mostrarFactura();
    }

}
