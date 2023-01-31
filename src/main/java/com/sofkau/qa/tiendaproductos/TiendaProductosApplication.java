package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	static ArrayList<Compra> compras = new ArrayList<Compra>();

	@Component
	public class ejecucion {

		Registros registros = new Registros();
		FuncionComprar funcionComprar = new FuncionComprar();

		public void ejecutar() {
			productos.add(new Producto("Producto 1", 10, 5));
			productos.add(new Producto("Producto 2", 20, 10));
			productos.add(new Producto("Producto 3", 30, 15));
			productos.add(new Producto("Producto 4", 40, 20));
			productos.add(new Producto("Producto 5", 50, 25));
			productos.add(new Producto("Producto 6", 60, 30));
			productos.add(new Producto("Producto 7", 70, 35));
			productos.add(new Producto("Producto 8", 80, 40));
			productos.add(new Producto("Producto 9", 90, 45));
			productos.add(new Producto("Producto 10", 100, 50));

			Scanner sc = new Scanner(System.in);
			boolean salir = false;
			while (!salir) {
				System.out.println("Bienvenido a la tienda!");
				System.out.println("1. Comprar");
				System.out.println("2. Ver registro de compras");
				System.out.println("3. Salir");
				System.out.print("Seleccione una opción: ");
				int opcion = sc.nextInt();
				switch (opcion) {
					case 1:
						funcionComprar.comprar();
						break;
					case 2:
						registros.verRegistroCompras();
						break;
					case 3:
						salir = true;
						break;
					default:
						System.out.println("Opción inválida");
				}
			}

		}

		@Component
		public class Registros {
			public void verRegistroCompras() {
				System.out.println("Registro de compras:");
				for (int i = 0; i < compras.size(); i++) {
					System.out.println((i + 1) + ". " + compras.get(i).getProducto().getNombre() + " - Cantidad: " + compras.get(i).getCantidad());
				}
			}
		}
	}
		public static void main(String[] args) {
				SpringApplication.run(TiendaProductosApplication.class, args);
		}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			ejecucion eje = new ejecucion();
			eje.ejecutar();
		};
	}
}
