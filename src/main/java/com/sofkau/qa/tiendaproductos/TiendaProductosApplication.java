package com.sofkau.qa.tiendaproductos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {


	@Autowired
	public Ferreteria ferreteria;
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			int opc = 0;
			Scanner in = new Scanner(System.in);

			//System.out.println("Numero de productos iniciales: " + ferreteria.productoList.size() + "\n");

			ferreteria.agregarProductos(new Producto("1. Cemento 50 kg", 33500,10));
			ferreteria.agregarProductos(new Producto("2. Metaldeck 2in Cal.22 ", 311000,10));
			ferreteria.agregarProductos(new Producto("3. Varilla Corrugada 1/2in", 29000,10));
			ferreteria.agregarProductos(new Producto("4. Caja de puntilla", 5000,20));
			ferreteria.agregarProductos(new Producto("5. Galon de Pintura", 25000,15));
			ferreteria.productosDisponibles();
			do {
				System.out.println("***FERRETERIA LA MEJOR***\n");
				System.out.println("Elige una opción");
				System.out.println("1. Comprar");
				System.out.println("2. Ver registro de compras");
				System.out.println("3. Salir");
				opc = in.nextInt();

				switch (opc) {
					case 1:
						System.out.println("Introduce tu nombre:");
						String nombreCliente = in.nextLine();

						Factura factura = new Factura(nombreCliente);

						boolean continuarComprando = true;
						while (continuarComprando) {
							System.out.println("Productos disponibles");
							ferreteria.productosDisponibles();

							System.out.println("Seleccione un ");
						}

						System.out.println("Selecciona un producto (Ingrese un numero entre 1 y " + ferreteria.productoStock.size());
						int opcion =in.nextInt();

						break;
					case 2:
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("Opción incorrecta");
				}

			}while (opc != 3);

		};
	}
}

