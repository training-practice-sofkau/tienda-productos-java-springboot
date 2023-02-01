package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class TiendaElectronica {

    public Factura factura = new Factura();
    public List<String> componentes = Arrays.asList(
            "Resistencia",
            "Capacitor",
            "Inductor",
            "Diodo",
            "Transistor",
            "Pulsador",
            "Relay",
            "uC",
            "Jumper",
            "LED");
    public List<Integer> existencia = new ArrayList<>(Arrays.asList(10000, 10000, 1000, 10000, 1000, 1000, 10, 5, 50, 10000));
    public List<Integer> precio = new ArrayList<>(Arrays.asList(20, 10, 200, 50, 1000, 10, 1500, 20000, 500, 50));

    public void tienda() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = sc.nextLine();

        while (true) {
            System.out.println("\n-- TIENDA DE COMPONENTES ELECTRÓNICOS --");
            System.out.println("\nOpciones: ");
            System.out.println("[1] Comprar");
            System.out.println("[2] Ver historial de compras");
            System.out.println("[3] Generar factura");
            System.out.print("\nIngrese la opción ([1] - [2] - [3]): ");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\nLista de componentes: ");
                for (int i = 0; i < componentes.toArray().length; i++) {
                    System.out.println((i + 1) + ". " + componentes.get(i) + " [" + existencia.get(i) + "] a $" + precio.get(i));
                }
                System.out.print("\nIngrese el número del componente a comprar: ");
                int numeroComponente = sc.nextInt();
                System.out.print("Ingrese la cantidad a comprar: ");
                int cantidad = sc.nextInt();

                if (cantidad > existencia.get(numeroComponente - 1)) {
                    System.out.println("\nNo hay suficientes existencias de " + componentes.get(numeroComponente - 1));
                } else {
                    existencia.set(numeroComponente - 1, existencia.get(numeroComponente - 1) - cantidad);
                    Compra compra = new Compra(
                            nombreCliente,
                            componentes.get(numeroComponente - 1),
                            cantidad,
                            precio.get(numeroComponente - 1));
                    factura.add(compra);
                    System.out.println("Compra generada -> " + compra.getCompra());
                }
            } else if (opcion == 2) {
                System.out.println("\nHistorial de compra: ");
                factura.mostrar(true);
            } else if (opcion == 3) {
                System.out.println("-- Factura --");
                factura.mostrar(false);
                break;
            } else {
                System.out.println("Opción incorrecta.");
            }
        }
    }
}