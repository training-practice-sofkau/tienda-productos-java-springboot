package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;



@SpringBootApplication
public class TiendaProductosApplication {

	@Autowired
	private Product product;

	@Autowired
	private Compra compra;

	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);


	}

	@Service
	class Product {
		private String nombre;
		boolean disponible;

		public Product(String nombre, boolean disponible) {
			this.nombre = nombre;
			this.disponible = disponible;
		}

		public String getNombre() {
			return nombre;
		}

		public boolean isDisponible() {
			return disponible;
		}
	}
@Service
	class Compra {
		private String nombreCliente;
		private String nombreProducto;

		public Compra(String nombreCliente, String nombreProducto) {
			this.nombreCliente = nombreCliente;
			this.nombreProducto = nombreProducto;
		}

		public String getNombreCliente() {
			return nombreCliente;
		}

		public String getNombreProducto() {
			return nombreProducto;
		}
	}
@Service
	class Tienda {
		private ArrayList<Product> products = new ArrayList<>();
		private ArrayList<Compra> compras = new ArrayList<>();
		private Scanner scanner = new Scanner(System.in);

		public Tienda() {
			products.add(new Product("Zapatos", true));
			products.add(new Product("Camisetas", true));
			products.add(new Product("Pantalones", true));
			products.add(new Product("Camisa", true));
			products.add(new Product("Jogger", true));
			products.add(new Product("Pantalonetas", true));
			products.add(new Product("Boxers", true));
			products.add(new Product("Medias", true));
			products.add(new Product("Chaquetas", true));
			products.add(new Product("Busos", true));
		}
		public void mostrarMenu() {
			System.out.println("Bienvenido a la tienda");
			System.out.println("1. Ver productos disponibles");
			System.out.println("2. Realizar compra");
			System.out.println("3. Ver registro de compras");
			System.out.println("4. Salir");
			System.out.print("Ingrese una opción: ");
			int opcion = scanner.nextInt();
			switch (opcion) {
				case 1:
					verProductos();
					break;
				case 2:
					realizarCompra();
					break;
				case 3:
					verRegistroCompras();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}

		public void verProductos() {
			System.out.println("Productos disponibles: ");
			for (Product product : products) {
				if (product.isDisponible()) {
					System.out.println("- " + product.getNombre());
				}
			}
			System.out.println();
		}

		public void realizarCompra() {
			System.out.print("Ingrese el nombre del producto que desea comprar: ");
			String nombreProducto = scanner.next();
			Product productEncontrado = null;
			for (Product product : products) {
				if (product.getNombre().equals(nombreProducto) && product.isDisponible()) {
					productEncontrado = product;
					break;
				}
			}
			if (productEncontrado == null) {
				System.out.println("Producto no disponible o no encontrado");
				return;
			}
			System.out.print("Ingrese su nombre: ");
			String nombreCliente = scanner.next();
			compras.add(new Compra(nombreCliente, nombreProducto));
			productEncontrado.disponible = false;
			System.out.println("Compra realizada con éxito");
		}

		public void verRegistroCompras() {
			System.out.println("Registro de compras: ");
			for (Compra compra : compras) {
				System.out.println(compra.getNombreCliente() + " compró " + compra.getNombreProducto());
			}
			System.out.println();
		}

		public void main(String[] args) {
			Tienda tienda = new Tienda();
			while (true) {
				tienda.mostrarMenu();
			}
		}
	}
}
