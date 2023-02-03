package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Menu {
        public void menuPrincipal(){
            Scanner scanner = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("1. Ver productos disponibles");
                System.out.println("2. Comprar");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opcion: ");
                opcion = scanner.nextInt();
                System.out.print("-------------------------------------- \n");

                switch (opcion) {
                    case 1:
                        StockTienda mostrarProductos = new StockTienda();
                        mostrarProductos.agregarPrenda(11, "Correas", 30000, 30);
                        List<Producto> pro = mostrarProductos.getProductos();
                        mostrarProductos.mostrar(pro);
                        break;

                    case 2:
                        Comprar comprarProductos = new Comprar();
                        comprarProductos.elegirProducto();
                        break;

                    case 3:
                        System.out.println("Vuelve pronto");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }
            } while (opcion != 3);

            scanner.close();
        }
    }

