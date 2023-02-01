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
	public TiendaDeJuegos tienda;
	@Autowired
	FacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			boolean bandera = true;
//			while (bandera) {
//				System.out.println("*****Tienda de Videojuegos*****");
//				System.out.println("Seleccione la opcion deseada");
//				System.out.println("1. Iniciar una nueva Compra");
//				System.out.println("2. Ver Registro de Compras");
//				Scanner sc = new Scanner(System.in);
//				int op = sc.nextInt();
//				switch (op) {
//					case 1:
//						System.out.println("---Lista de Videojuegos Disponibles en la Tienda---\n");
//						tienda.mostrarProductos();
//						tienda.addToCart();
//						break;
//					case 2:
//						System.out.println("---Registro de Facturas---");
//						System.out.println(facturaService.getFacturas());
//						break;
//					default:
//						System.out.println("Opcion Incorrecta");
//						bandera = false;
//						break;
//				}
//			}
//		};
//	}

}
