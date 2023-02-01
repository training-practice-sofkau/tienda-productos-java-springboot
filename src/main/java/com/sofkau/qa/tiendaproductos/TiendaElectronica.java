package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class TiendaElectronica {

    public List<Factura> facturas = new ArrayList<>();
    public String[] componentes = {"Resistencia",
            "Capacitor",
            "Inductor",
            "Diodo",
            "Transistor",
            "Pulsador",
            "Relay",
            "uC",
            "Jumper",
            "LED"};
    public int[] cantidad = {10000, 10000, 1000, 10000, 1000, 1000, 10, 5, 50, 10000};

    public void tienda() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = sc.nextLine();

        while (true) {
            System.out.println("Opciones: ");
            System.out.println("[1] Comprar");
            System.out.println("[2] Ver historial de compras");
            System.out.print("Ingrese la opción ([1] o [2]): ");

        }
    }
}



