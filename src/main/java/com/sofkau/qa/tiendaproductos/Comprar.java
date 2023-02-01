package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comprar {


    public List<Orden> elegirProducto(){

        List<Orden> orden = new ArrayList<>();
        int total = 0;

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

        StockTienda mostrarProductos = new StockTienda();
        List<Producto> products = mostrarProductos.getProductos();
        mostrarProductos.mostrar(products);
       /* StockTienda stockTienda = new StockTienda();
        List<Producto> products = stockTienda.getProductos();*/


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
                orden.add(new Orden(products.get(numeroProducto-1), cantidad, products.get(numeroProducto-1).getPrecio()));
                total+= products.get(numeroProducto-1).getPrecio();

            }else {
                System.out.println("Por favor, ingresa un numero valido");
            }
            numeroProducto = input.nextInt();
        }

        System.out.println("-------------------------------");
        System.out.println("Los productos seleccionados son:");

        for (Orden o:orden) {
            System.out.println(" " + o.getProducto().getNombre() + " " + o.getQuantity() + " " + o.getPrice());
        }

        System.out.println("El total de su compra seria: " + total);
        System.out.println("-------------------------------");



        return orden;

    }

        /**
         * Compara los numeros ingresados por el usuario y el stock de la tienda
         */

        /*List<Producto> matchedProducts = products.stream()
                .filter(p -> orden.contains(p.getNombre()))
                .collect(Collectors.toList());

            for (Producto p: matchedProducts) {
                System.out.println(" " + p.getNombre() + " " + p.getPrecio() );

            }*/


}




