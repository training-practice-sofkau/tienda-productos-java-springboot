package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Comprar {



    public String elegirProducto(){

        /**
         * Lista para guardar el id del producto ingresado por el usuario
         */
        ArrayList<Integer> ListaProducto = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Scanner cant = new Scanner(System.in);

        System.out.println("Selecciona los productos de la lista:");

        /**
         * Muestra el stock de la Tienda
         */
        StockTienda stockTienda = new StockTienda();
        List<Producto> products = stockTienda.getProductos();


        System.out.println("Ingresa el numero de los productos que deseas seleccionar (Ingresa 0 para terminar): ");
        int numeroProducto = input.nextInt();

        //Finaliza la compra si se elige 0
        while (numeroProducto != 0) {
            if (numeroProducto >= 1 && numeroProducto <= products.size()) {

                int cantidadActual = products.get(numeroProducto).getCantidad();

                //Pide al usuario la cantidad deseada del producto
                System.out.print("Ingrese la cantidad: ");
                int cantidad = cant.nextInt();

                //Actualiza la cantidad de productos del producto elegido
                products.get(numeroProducto).setCantidad(cantidadActual - cantidad);

                //Agrega el numero del prudcto elegido a una lista
                ListaProducto.add(numeroProducto);

            }else {
                System.out.println("Por favor, ingresa un numero valido");
            }
            numeroProducto = input.nextInt();
        }

        System.out.println("-------------------------------");
        System.out.println("Los productos seleccionados son:");

        /**
         * Compara los numeros ingresados por el usuario y el stock de la tienda
         */

        List<Producto> matchedProducts = products.stream()
                .filter(p -> ListaProducto.contains(p.getId()))
                .collect(Collectors.toList());

            for (Producto p: matchedProducts) {
                System.out.println(" "+ p.getId()+ "  " + p.getNombre() + " " + p.getCantidad());

            }
        return "Estos son los productos";

    }



}
