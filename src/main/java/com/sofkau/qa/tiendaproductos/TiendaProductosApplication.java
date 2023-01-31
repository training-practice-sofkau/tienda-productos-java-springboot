package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TiendaDonJose tiendaDonJose = new TiendaDonJose("Tienda Don Jose");
		Cliente cliente = new Cliente("Efrain",1111111);
		Scanner scanner = new Scanner(System.in);


		System.out.println("Bienvenido a la tienda de Don Jose");
		System.out.println("---------------------------------");
		System.out.println("Escribe la opcion que necesites");
		System.out.println("1. Para ver los registros de compra");
		System.out.println("2. Para hacer compras en la tienda");
		int compra_regitro = scanner.nextInt();
		 switch (compra_regitro){
			 case 1:tiendaDonJose.verRegistro();
			 case 2:
				 System.out.println("Estos son los productos disponibles.");
				tiendaDonJose.verProductos();
				 System.out.println("1. Sal");
				 System.out.println("2. Azucar");
				 System.out.println("3. Cereal");
				 System.out.println("4. Aceite");
				 System.out.println("5. Cerveza");
				 System.out.println("6. Ron");
				 System.out.println("7. Aguariente");
				 System.out.println("8. Doritos");
				 System.out.println("9. Mantequilla");
				 System.out.println("10. Salsa de tomate");
				 System.out.println("Escribe el producto que quieres comprar");
				 String productoCarrito = scanner.next();
				 System.out.println("Escribe la cantidad en numeros del producto");
				 int cantidadProducto = scanner.nextInt();
				 tiendaDonJose.iterarProducto(productoCarrito);



				 System.out.println(cliente.carritoDeCompra);

		 }


	}};