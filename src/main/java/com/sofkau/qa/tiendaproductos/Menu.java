package com.sofkau.qa.tiendaproductos;

import java.util.Scanner;

public class Menu {
    public void desplegarMenu(){
        System.out.println("Bienvenido a la tienda de Productos\n" +
                "Por favor ingrese su nombre");
        Scanner line = new Scanner(System.in); // Se crea un objeto Scanner
        String nombre = line.nextLine(); // Se lee el nombre ingresado por usuario

        System.out.println("Por favor elija la opción\n" +
                "1. Comprar en la tienda\n" +
                "2. Listar productos comprados");
        int opcion = Integer.parseInt(line.nextLine());

        switch (opcion) {
            case 1:
                System.out.println("Estos son los productos que se encuentran disponibles en la tienda:");

        }
    }
}
