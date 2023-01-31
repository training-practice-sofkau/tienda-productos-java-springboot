package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.datos.ProductosStock;
import com.sofkau.qa.tiendaproductos.datos.StockMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {
	/**
	 * Se utiliza la anotación Autowired para genera una instancia de StockMethods, y así acceder a la
	 * implementación de los métodos definidos en estas interfaz.
	 */
	@Autowired
	public ProductosStock productosStock;

	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

			System.out.println("Bienvenido a la tienda de Productos deportivosw\n" +
					"Por favor ingrese su nombre");

			Scanner line = new Scanner(System.in); // Se crea un objeto Scanner
			String nombre = line.nextLine(); // Se lee el nombre ingresado por usuario

			System.out.println("Por favor elija la opción\n" +
					"1. Comprar en la tienda\n" +
					"2. Listar productos comprados");
			int opcion = Integer.parseInt(line.nextLine()); // se lee la opción ingresada por el usuario

			switch (opcion) {
				case 1:
					System.out.println("A continuación encuentras la lista de productos disponibles en la tienda");
					productosStock.getStock();

					System.out.println("Por favor escriba el nombre de los productos que desea adquirir, seguido por\n" +
							"el numero de unidades; separados por coma y sin espacios");

					String[] listaProductosCliente = line.nextLine().split(",");

					String nombreProducto = listaProductosCliente[0];
					// TODO: crear instancias, tomando como parametros de entrada el texto ingresado por el usuario

					break;

					// TODO: crear el menu para la opción 2 de listar los productos comprados en la sesión actual
			}

		};
	}

}
