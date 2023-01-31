package com.sofkau.qa.tiendaproductos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comprar {

    public String elegirProducto(){

        ArrayList<Integer> ListaProducto = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Selecciona los productos de la lista:");

        StockTienda mostrarProductos = new StockTienda();
        mostrarProductos.mostrarStock();


        System.out.println("Ingresa el numero de los productos que deseas seleccionar (Ingresa 0 para terminar): ");
        int numeroProducto = input.nextInt();

        while (numeroProducto != 0) {
            if (numeroProducto >= 1 && numeroProducto <= 10) {
                ListaProducto.add(numeroProducto);
            }else {
                System.out.println("Por favor, ingresa un numero valido");
            }
            numeroProducto = input.nextInt();
        }

        System.out.println("-------------------------------");
        System.out.println("Los productos seleccionados son:");

            for (Integer product : ListaProducto) {
                /*for (Producto stock:mostrarProductos.mostrarStock()) {
                    if (stock.getId() == product){
                        return "estoy entrando aqui";

                }

            }*/

            System.out.println(" " + product);


        }
        return "Estos son los productos";

    }



}
