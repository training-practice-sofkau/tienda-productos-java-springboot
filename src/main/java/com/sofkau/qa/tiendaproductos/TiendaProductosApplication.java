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

    /**
     * @Autowired public Factura factura;
     * @Autowired public Producto producto;
     */
    public static void main(String[] args) {

        SpringApplication.run(TiendaProductosApplication.class, args);
    }

/**
 @Bean public CommandLineRunner commandLineRunner() {


 return args -> {


 // Tienda de Motos


 Scanner sc = new Scanner(System.in);
 ArrayList<Producto> productos = new ArrayList<Producto>();
 productos.add(new Producto("12", "Carburador", 10000, 2));
 productos.add(new Producto("21", "Tanque", 20000, 20));
 productos.add(new Producto("1", "Manubrio ", 30000, 30));
 productos.add(new Producto("2", "Patillas de Freno", 100000, 20));
 productos.add(new Producto("25", "Llantas ", 300000, 30));
 productos.add(new Producto("33", "Tanque", 200000, 20));
 productos.add(new Producto("434", "freno ", 30000, 30));

 System.out.println("Bienvenido a la Tienda Moto Racer");
 System.out.println("Productos disponibles: ");
 for (int i = 0; i < productos.size(); i++) {
 System.out.println((i + 1) + ") " + productos.get(i).getNombre() + " : "
 + " El Precio es : " + productos.get(i).getPrecio());
 }

 Persona persona = new Persona();
 System.out.print("Ingrese el nombre del cliente: ");
 persona.setNombre(sc.nextLine());
 System.out.print("Ingrese el documento del cliente: ");
 persona.setDocumento(sc.nextLine());
 System.out.print("Ingrese el correo del cliente: ");
 persona.setCorreo(sc.nextLine());

 ArrayList<Factura> facturas = new ArrayList<Factura>();
 Factura factura = new Factura(persona.getNombre() + " " + persona.getApéllido(), "01/01/2023");
 facturas.add(factura);

 String opcion = "";
 while (!opcion.equalsIgnoreCase("salir")) {
 System.out.print("Seleccione un producto (1, 2, 3): ");
 int seleccion = sc.nextInt();
 sc.nextLine();
 System.out.print("Cantidad a comprar: ");
 int cantidad = sc.nextInt();
 sc.nextLine();
 Producto producto = productos.get(seleccion - 1);

 if (cantidad > producto.getCantidad()) {
 System.out.println("Lo siento, solo tenemos " + producto.getCantidad() + " unidades disponibles de " + producto.getNombre());
 } else {
 producto.setCantidad(producto.getCantidad() - cantidad);
 factura.agregarProducto(new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), cantidad));
 System.out.print("Desea seguir comprando? (si/no): ");
 opcion = sc.nextLine();
 }

 factura.agregarProducto(new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), cantidad));
 System.out.print("Desea seguir comprando? (si/no): ");
 opcion = sc.nextLine();
 if (opcion.equalsIgnoreCase("no")) {
 System.out.println("Factura");
 System.out.println("Cliente: " + persona.getNombre() + persona.getDocumento() + persona.getCorreo());
 System.out.println("Fecha: " + factura.getFecha());
 System.out.println("Productos: ");
 for (Producto producto1 : factura.getProductos()) {
 System.out.println(producto + " Total: " + (producto1.getPrecio() * producto1.getCantidad()));
 }
 System.out.println("Total a pagar: " + factura.calcularTotal());
 System.out.print("Desea salir? (si/no): ");
 String respuesta = sc.nextLine();

 }

 }

 };

 }

 */
}