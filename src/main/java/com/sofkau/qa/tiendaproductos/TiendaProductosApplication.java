package com.sofkau.qa.tiendaproductos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
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

			ferreteria.agregarProductos(new Producto("Cemento 50 kg", 33500,10));
			ferreteria.agregarProductos(new Producto("Metaldeck 2in Cal.22 ", 311000,10));
			ferreteria.agregarProductos(new Producto("Varilla Corrugada 1/2in", 29000,10));
			ferreteria.agregarProductos(new Producto("Caja de puntilla", 5000,20));
			ferreteria.agregarProductos(new Producto("Galon de Pintura", 25000,15));

			int numeroFactura = 1;
			do {
				System.out.println("***FERRETERIA LA MEJOR***\n");
				System.out.println("Elige una opción");
				System.out.println("1. Comprar");
				System.out.println("2. Ver registro de compras");
				System.out.println("3. Salir");
				opc = in.nextInt();

				switch (opc) {
					case 1:
						ferreteria.iniciarCompra();
					break;
					case 2:
						ferreteria.imprimirHistorialVentas();
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

