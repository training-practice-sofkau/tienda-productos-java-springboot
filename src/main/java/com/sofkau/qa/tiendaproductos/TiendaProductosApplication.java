package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {


    @Autowired
    public Factura factura;

    @Autowired
    public Producto producto;

    public static void main(String[] args) {
        SpringApplication.run(TiendaProductosApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {

        return args -> {

            /**
             * realizo el metodo main para realiza la compra
             */


            /**
             * Tienda de Motos
             */
            Scanner sc = new Scanner(System.in);
            ArrayList<Producto> productos = new ArrayList<Producto>();
            productos.add(new Producto("Carburador", 10, 10));
            productos.add(new Producto("Tanque", 20, 20));
            productos.add(new Producto("Manubrio ", 30, 30));

            System.out.println("Bienvenido a la Tienda Moto Racer");
            System.out.println("Productos disponibles: ");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ") " + productos.get(i).getNombre());
            }

            Persona persona = new Persona();
            System.out.print("Ingrese el nombre del cliente: ");
            persona.setNombre(sc.nextLine());
            System.out.print("Ingrese el documento del cliente: ");
            persona.setDocumento(sc.nextLine());
            System.out.print("Ingrese el correo del cliente: ");
            persona.setCorreo(sc.nextLine());

            Factura factura = new Factura(persona.getNombre() + " " + persona.getApéllido(), "01/01/2023");

            String opcion = "";
            while (!opcion.equalsIgnoreCase("salir")) {
                System.out.print("Seleccione un producto (1, 2, 3): ");
                int seleccion = sc.nextInt();
                sc.nextLine();
                System.out.print("Cantidad a comprar: ");
                int cantidad = sc.nextInt();
                sc.nextLine();
                Producto producto = productos.get(seleccion - 1);
                factura.agregarProducto(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
                System.out.print("Desea seguir comprando? (si/no): ");
                sc.nextLine();

                break;
            }

            System.out.println("Factura");
            System.out.println("Cliente: " + persona);
            System.out.println("Fecha: " + factura.getFecha());
            System.out.println("Productos: ");
            for (Producto producto : factura.getProductos()) {
                System.out.println(producto + " Total: " + (producto.getPrecio() * producto.getCantidad()));
            }
            System.out.println("Total a pagar: " + factura.calcularTotal());

        };
    }
}




