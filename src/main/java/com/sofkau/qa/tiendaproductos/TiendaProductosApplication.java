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
            Scanner sc = new Scanner(System.in);
            Factura factura = new Factura("Cliente1", "01/01/2023");
            ArrayList<Producto> productos = new ArrayList<>();

            // Agregar productos a la lista
            productos.add(new Producto("Llanta", 100.0, 10));
            productos.add(new Producto("Freno", 200.0, 5));
            productos.add(new Producto("Amortiguador", 150.0, 8));

            boolean continuar = true;

            while (continuar) {
                System.out.println("Productos disponibles:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println((i + 1) + ". " + productos.get(i).getNombre());
                }

                System.out.print("Seleccione un producto (0 para salir): ");
                int opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 0) {
                    continuar = false;
                } else if (opcion > 0 && opcion <= productos.size()) {
                    Producto producto = productos.get(opcion - 1);
                    System.out.print("Ingrese la cantidad que desea comprar: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    producto.setCantidad(cantidad);
                    factura.agregarProducto(producto);
                } else {
                    System.out.println("Opción inválida, intente de nuevo.");
                }
            }
        };
    }
}




