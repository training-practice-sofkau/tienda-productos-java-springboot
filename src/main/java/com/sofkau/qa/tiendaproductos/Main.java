package com.sofkau.qa.tiendaproductos;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public abstract void descripcionProducto();
}

class Inventario extends Producto {
    private String ubicacion;

    public Inventario(String nombre, double precio, int cantidad, String ubicacion) {
        super(nombre, precio, cantidad);
        this.ubicacion = ubicacion;
    }

    @Override
    public void descripcionProducto() {
        System.out.println("Producto: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Ubicacion: " + ubicacion);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> historialVentas = new ArrayList<>();

        Inventario[] inventario = new Inventario[10];

        inventario[0] = new Inventario("Laptop Dell", 800.00, 10, "Estante 1");
        inventario[1] = new Inventario("Mouse Logitech", 40.00, 20, "Estante 2");
        inventario[2] = new Inventario("Impresora HP", 120.00, 5, "Estante 3");
        inventario[3] = new Inventario("Smartphone Samsung", 600.00, 20, "Estante 4");
        inventario[4] = new Inventario("Tablet Apple", 700.00, 15, "Estante 5");
        inventario[5] = new Inventario("Monitor Dell", 300.00, 25, "Estante 6");
        inventario[6] = new Inventario("Teclado Logitech", 50.00, 30, "Estante 7");
        inventario[7] = new Inventario("Bocinas JBL", 100.00, 15, "Estante 8");
        inventario[8] = new Inventario("Cargador Apple", 20.00, 40, "Estante 9");
        inventario[9] = new Inventario("Audifonos Samsung", 70.00, 25, "Estante 10");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Comprar producto");
            System.out.println("2. Ver historial de ventas");
            System.out.println("3. Salir");
            System.out.print("Eliga una opcion: ");

            int opcion = scan.nextInt();
            scan.nextLine();

            if (opcion == 1) {
                System.out.println("\nProductos disponibles: ");
                for (int i = 0; i < inventario.length; i++) {
                    System.out.println((i + 1) + ". " + inventario[i].nombre + ", Precio: " + inventario[i].precio + ", Cantidad: " + inventario[i].cantidad);
                }
                System.out.print("Elige un producto (numero): ");

                int productoElegido = scan.nextInt();
                scan.nextLine();
                productoElegido--;

                if (productoElegido >= 0 && productoElegido < inventario.length) {
                    Inventario producto = inventario[productoElegido];

                    System.out.print("Cuantas unidades quieres comprar?: ");
                    int cantidadComprar = scan.nextInt();
                    scan.nextLine();

                    if (cantidadComprar > 0 && cantidadComprar <= producto.cantidad) {
                        producto.cantidad -= cantidadComprar;
                        historialVentas.add(cantidadComprar + " unidades de " + producto.nombre + " a $" + producto.precio + " cada una");
                        System.out.println("Compra exitosa! Total a pagar: $" + (cantidadComprar * producto.precio));
                    } else {
                        System.out.println("Cantidad no valida o no hay suficiente en inventario");
                    }
                } else {
                    System.out.println("Producto no encontrado");
                }
            } else if (opcion == 2) {
                System.out.println("\nHistorial de ventas: ");
                if (historialVentas.size() > 0) {
                    for (int i = 0; i < historialVentas.size(); i++) {
                        System.out.println((i + 1) + ". " + historialVentas.get(i));
                    }
                } else {
                    System.out.println("No hay ventas registradas");
                }
            } else if (opcion == 3) {
                System.out.println("Gracias por utilizar nuestro sistema");
                break;
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }
}

