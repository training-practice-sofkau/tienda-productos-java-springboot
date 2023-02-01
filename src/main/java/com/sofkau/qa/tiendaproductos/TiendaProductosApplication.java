package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		/**
		 * TiendaDonJose tiendaDonJose = new TiendaDonJose("Tienda Don Jose");
		 *
		 * 		Scanner scanner = new Scanner(System.in);
		 * 		int seguir_salir_carrito;
		 * 		int compra_regitro;
		 *
		 *
		 * 		System.out.println("Bienvenido a la tienda de Don Jose");
		 * 		System.out.println("---------------------------------");
		 * 		System.out.println("Escriba su nombre");
		 * 		String nombreCliente = scanner.next();
		 * 		System.out.println("Escriba su Cedula");
		 * 		int cedulaCliente = scanner.nextInt();
		 * 		Cliente cliente = new Cliente(nombreCliente, cedulaCliente);
		 *
		 * 			do {
		 * 				System.out.println("Escribe la opcion que necesites");
		 * 				System.out.println("1. Para ver los registros de compra");
		 * 				System.out.println("2. Para hacer compras en la tienda");
		 * 				System.out.println("Para salir del programa escriba la palabra Salir");
		 *
		 * 				compra_regitro = scanner.nextInt();
		 * 				switch (compra_regitro) {
		 * 					case 1:
		 * 						tiendaDonJose.verRegistro();
		 * 						break;
		 * 					case 2:
		 * 						do {
		 * 							System.out.println("Estos son los productos disponibles.");
		 * 							tiendaDonJose.verProductos();
		 * 							System.out.println("1. Sal");
		 * 							System.out.println("2. Azucar");
		 * 							System.out.println("3. Cereal");
		 * 							System.out.println("4. Aceite");
		 * 							System.out.println("5. Cerveza");
		 * 							System.out.println("6. Ron");
		 * 							System.out.println("7. Aguariente");
		 * 							System.out.println("8. Doritos");
		 * 							System.out.println("9. Mantequilla");
		 * 							System.out.println("10. Salsa de tomate");
		 * 							System.out.println("Escribe el producto que quieres comprar");
		 * 							String productoCarrito = scanner.next().toLowerCase();
		 * 							System.out.println("Escribe la cantidad en numeros del producto");
		 * 							int cantidadProducto = scanner.nextInt();
		 * 							tiendaDonJose.iterarProducto(productoCarrito);
		 * 							cliente.agregarProducto(new Producto(productoCarrito, cantidadProducto, tiendaDonJose.getPrecioProducto()));
		 * 							System.out.println(cliente.carritoDeCompra);
		 * 							System.out.println("Si quieres seguir agregando productos al carrito escribe 1");
		 * 							System.out.println("Si quieres hacer la factura escribe 2");
		 * 							seguir_salir_carrito = scanner.nextInt();
		 *                                                } while (seguir_salir_carrito == 1);
		 * 						tiendaDonJose.totalFactura(cliente);
		 * 						System.out.println("Tu factura es:");
		 * 						tiendaDonJose.factura(cliente);
		 * 						break;
		 * 				}} while (compra_regitro != 1 || compra_regitro != 2); ;
		 *
		 */

	}
};