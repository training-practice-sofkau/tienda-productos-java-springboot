package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.ArrayList;


@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {


		interface Producto {
			void mostrarInformacion();
		}

		class Inventario implements Producto {
			String nombre;
			int precio;
			int cantidad;

			public Inventario(String nombre, int precio, int cantidad) {
				this.nombre = nombre;
				this.precio = precio;
				this.cantidad = cantidad;
			}

			@Override
			public void mostrarInformacion() {
				System.out.println("Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad);
			}
		}

		class Compra implements Producto {
			int cantidadComprar;
			Inventario producto;

			public Compra(Inventario producto, int cantidadComprar) {
				this.producto = producto;
				this.cantidadComprar = cantidadComprar;
			}

			@Override
			public void mostrarInformacion() {
				System.out.println("Cantidad comprar: " + cantidadComprar + " unidades de " + producto.nombre + " a $" + producto.precio + " cada una");
			}
		}

		class SistemaVentas {
			ArrayList<Producto> productos = new ArrayList<>();
			ArrayList<Compra> historialVentas = new ArrayList<>();

			public void agregarProducto(Inventario producto) {
				productos.add(producto);
			}

			public void agregarCompra(Compra compra) {
				historialVentas.add(compra);
			}

			public void mostrarProductos() {
				System.out.println("\nProductos disponibles: ");
				for (int i = 0; i < productos.size(); i++) {
					productos.get(i).mostrarInformacion();
				}
			}

			public void mostrarHistorialVentas() {
				System.out.println("\nHistorial de ventas: ");
				if (historialVentas.size() > 0) {
					for (int i = 0; i < historialVentas.size(); i++) {
						historialVentas.get(i).mostrarInformacion();
					}
				} else {
					System.out.println("No hay ventas registradas");
				}
			}
		}

		class Main {
			public static void main(String[] args) {
				SistemaVentas sistema = new SistemaVentas();
				Scanner scan = new Scanner(System.in);

				sistema.agregarProducto(new Inventario("Laptop Dell", 800, 10));
				sistema.agregarProducto(new Inventario("Smartphone Samsung", 500, 15));


			}
		}
	}
}