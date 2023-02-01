package com.sofkau.qa.tiendaproductos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                        List<Producto> pro = mostrarProductos.getProductos();
                        mostrarProductos.mostrar(pro);
                        break;

                    case 2:
                        Comprar comprarProductos = new Comprar();
                        comprarProductos.elegirProducto();

                        Scanner input = new Scanner(System.in);

                        System.out.println("Desea confirmar la compra: \n 1 Si \n 2 No");
                        int confirmar = input.nextInt();

                        if (confirmar == 1) {
                            System.out.println("Compra confirmada");


                            Factura factura = new Factura();
                            /*List<Orden> listaProducto = comprarProductos.elegirProducto();
                            System.out.println(" " + listaProducto.size());*/

                            List<Orden> listaProducto = new ArrayList<>();
                            String fact = factura.generarFactura(listaProducto);
                            System.out.println(" " + fact);

                        } else if (confirmar == 2) {
                            System.out.println("No se registro ninguna compra");

                        } else {
                            System.out.println("Por favor, ingresa un numero valido");
                        }
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

