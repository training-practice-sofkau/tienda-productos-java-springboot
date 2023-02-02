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
	public ShopPc shopPc;


	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);
	}
	@Bean
	public CommandLineRunner cambiarEstenombre(){
		var opcion= -1;
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente("Antonio");

		return args -> {

			while (opcion != 0){
				System.out.println("Elige una opcion: \n"
					+ "1. Mostrar Catalogo de productos: \n"
					+ "2. Listar Catalogo\n"
					+ "0. Salir");

			}
			System.out.println("Digite su nombre: ");
			var nombreCliente = entrada.nextLine();
			System.out.println();
			System.out.println("  ****** Articulos ShopPc *******\n");
			ShopPc prueba = new ShopPc();
			prueba.tienda();
		};
	}

}
