package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class VistaUsuario {
    @Autowired
    private Producto producto;
    @Autowired
    public static Catalogo catalogo;
    public static void menu() {

        int response = 0;
        do {
            System.out.println("\t TIENDA FREE STYLE\n");
            System.out.println("Selecciona la opción deseada:");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Comprar producto");
            System.out.println("3. Ver factura \n");
            Scanner sc = new Scanner(System.in);
            // Captura la opción establecida por el usuario
            response = Integer.valueOf(sc.nextLine());
            // switch para evaluar los respectivos metodos según el caso
            switch (response) {
                // Caso 1 para mostrar productos
                case 1:
                    System.out.println("\tCatalogo Fashion");
                    System.out.println("===========================");

                    break;
                // Caso 2 para realizar compra de producto(s)
                case 2:
                    System.out.println("\tSelecciona tu producto");
                    System.out.println("===========================");

                    break;
                // Caso 3 para mostrar la factura
                case 3:
                    System.out.println("\tMi factura");
                    System.out.println("===========================");

                    break;

                case 0:
                    System.out.println("\t¡Gracias por visitar PLAYLIST!");

                    break;
                default:
                    System.out.println("\tIngresa un valor correcto");
            }

        } while (response != 0);
    }



}
