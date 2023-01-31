package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@SpringBootApplication
public class TiendaProductosApplication  implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Scanner entrada = new Scanner(System.in);

		List<Producto> productoList = new ArrayList<>();

		productoList.add(new Producto("Manga1", 10, 12));
		productoList.add(new Producto("Manga2", 14, 15));
		productoList.add(new Producto("Manga3", 11, 7));
		productoList.add(new Producto("Manga4", 1, 9));
		productoList.add(new Producto("Manga5", 15, 88));
		productoList.add(new Producto("Anime1", 11, 2));
		productoList.add(new Producto("Anime2", 19, 76));
		productoList.add(new Producto("Anime3", 10, 7));
		productoList.add(new Producto("Anime4", 3, 23));
		productoList.add(new Producto("Anime5", 7, 89));


		List<Cliente> clienteList = new ArrayList<>();
		Cliente cliente = new Cliente("Francisco", 12);
		clienteList.add(new Cliente("Luis", 1));
		clienteList.add(new Cliente("Fernando", 2));
		clienteList.add(new Cliente("Lucero", 3));
		clienteList.add(new Cliente("Lucas", 4));


		Tienda productosTienda = new Tienda(productoList, clienteList);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bienvenido ");
		System.out.println("---------------------------------");
		System.out.println("Escribre la ópcion");
		System.out.println("1. Registros compra");
		System.out.println("2. Comprar");
		int registroDeCompra = scanner.nextInt();

		switch (registroDeCompra){
			case 1:productosTienda.verProductos();

			case 2:
				System.out.println("Estos son los productos disponibles.");
				productosTienda.verProductos();

				for (Producto producto: productoList){
					System.out.println("Los productos son: " + producto.getNombreProducto());
				}

				System.out.println("Escribe el producto que quieres comprar");
				String productoCarrito = scanner.next();
				System.out.println("Escribe la cantidad en numeros del producto");
				int cantidadProducto = scanner.nextInt();
				productosTienda.iterarProducto(productoCarrito);
				System.out.println(cliente.carrito);


		}






	}
}


