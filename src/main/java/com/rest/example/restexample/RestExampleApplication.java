package com.rest.example.restexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RestExampleApplication {
    @Autowired
    private static ProductoGuardado ProductoGuardado;
    @Autowired
    private static FacturasGuardadas FacturasGuardadas;
    public static void main(String[] args) {
        SpringApplication.run(RestExampleApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            boolean continueShopping = true;
            while (continueShopping) {
                System.out.println("Bienvenido a la tienda sofka!");
                System.out.println("Seleccione una opción:\n" +
                        "1. Comprar un producto\n" +
                        "2. Ver Registro de Facturas\n" +
                        "3. Salir");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Escriba su nombre para la factura:");
                    String name = scanner.nextLine();
                    List<Producto> products = ProductoGuardado.getAllProductos();
                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + 1 + ". " + products.get(i).getNombre() + ", precio: " + products.get(i).getPrecio());
                    }
                    List<ProductoOrdernado> orders = new ArrayList<>();
                    while (true) {
                        System.out.println("Seleccione un producto o presione [0] para terminar la compra:");
                        int productIndex = scanner.nextInt();
                        if (productIndex == 0) {
                            break;
                        }
                        System.out.println("Ingrese cantidad del producto a comprar:");
                        int quantity = scanner.nextInt();
                        orders.add(new ProductoOrdernado(products.get(productIndex - 1), quantity));
                    }
                    Factura factura = new Factura(name, orders);
                    FacturasGuardadas.addFactura(factura);
                    System.out.println("Gracias por comprar en sofka!!");
                    System.out.println("Factura: " + factura + "\n");
                } else if (choice.equals("2")) {
                    List<Factura> facturas = FacturasGuardadas.getFacturas();
                    System.out.println("Facturas:");
                    for (Factura factura : facturas) {
                        System.out.println(factura + "\n");
                    }
                } else if (choice.equals("3")) {
                    System.out.println("Vuelve pronto");
                    break;
                } else {
                    System.out.println("Opción ingresada invalida, intente de nuevo.");
                }
            }
        };
    }
}

