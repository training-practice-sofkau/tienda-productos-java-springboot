package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {

	/**
	 * @Autowired Quien decide cuando se debe instanciar un objeto
	 */
	@Autowired
	public Cafeteria cafeteria;
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			/**
			 * Instancias de productos
			 */
			//System.out.println("Cantidad de productos iniciales: " + cafeteria.productoList.size());
			Producto cafe = new Producto("Café americano", 2000, 0);
			Producto mocha = new Producto("Café mocha", 5000, 15);
			Producto espresso = new Producto("Café espresso", 3500, 20);
			Producto cappuccino = new Producto("Cappuccino", 5000,21);
			Producto latte = new Producto("Café latte", 40000, 15);
			Producto coldbrew = new Producto("Cold Brew", 8000, 25);

			cafeteria.agregarProductos(cafe);
			cafeteria.agregarProductos(mocha);
			cafeteria.agregarProductos(espresso);
			cafeteria.agregarProductos(cappuccino);
			cafeteria.agregarProductos(latte);
			cafeteria.agregarProductos(coldbrew);

			Scanner entrada = new Scanner(System.in);
			boolean ejecutarMenu = true;

			/**
			 * Menú principal de la aplicación
			 */
			while (ejecutarMenu) {
				System.out.println("---Bienvenido(a) a la cafetería---");
				System.out.println("Selecciona una opción");
				System.out.println("1. Mostrar productos");
				System.out.println("2. Comprar productos");
				System.out.println("3. Generar factura");
				System.out.println("4. Visualizar registro de compras");
				System.out.println("5. Salir");
				int opcion = entrada.nextInt();

				switch (opcion){
					case 1:
						cafeteria.mostrarProductos();
						break;

					case 2:
						cafeteria.iniciarCompra();
						break;

					case 3:
						cafeteria.generarFactura();
						break;

					case 4:
						cafeteria.imprimirHistorialVentas();
						break;

					case 5:
						System.out.println("¡Hasta pronto!");
						ejecutarMenu = false;
						break;

					default:
						System.out.println("Opción inválida");
				}

			}
		};
	}
}