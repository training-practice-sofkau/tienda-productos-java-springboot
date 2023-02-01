package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Comprar {


    public void elegirProducto(){

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

        Scanner input2 = new Scanner(System.in);

        System.out.println("Desea confirmar la compra: \n 1 Si \n 2 No");
        int confirmar = input2.nextInt();

        if (confirmar == 1) {
            System.out.println("Compra confirmada");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce tu nombre para generar factura: ");
            String nombre = scanner.nextLine();

            System.out.println(" Factura para: " + nombre);
            System.out.println(" Compra realizada en Tienda Fashion por un valor de: " + total);
            System.out.println(" Gracias por su Compra  ");


        } else if (confirmar == 2) {
            System.out.println("No se registro ninguna compra");

        } else {
            System.out.println("Por favor, ingresa un numero valido");
        }




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




