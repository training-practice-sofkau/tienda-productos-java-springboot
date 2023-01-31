package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaProductosApplication {

	@Autowired
	public Cafeteria cafeteria;
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("Cantidad de productos iniciales: " + cafeteria.productoList.size());
			Producto cafe = new Producto("Café", 2000, 10);
			Producto leche = new Producto("Leche", 5000, 6);
			Producto canela = new Producto("Canela", 3500, 11);
			Producto lecheAlmendras = new Producto("leche de almendras", 5000,9);

			cafeteria.agregarProductos(cafe);
			cafeteria.agregarProductos(leche);
			cafeteria.agregarProductos(canela);
			cafeteria.agregarProductos(lecheAlmendras);

			System.out.println("Cantidad de productos finales: " + cafeteria.productoList.size());
			System.out.println(cafeteria.toString());
		};
	}
}