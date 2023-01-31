package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Proceso {

	@Autowired
	public Tienda tienda;
	public static void main(String[] args) {
		SpringApplication.run(Proceso.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (){
		return args -> {
			Producto Producto1 = new Producto("Computador", 1000, 1);
			Producto Producto2 = new Producto("Computador", 1000, 1);
			Producto Producto3 = new Producto("Computador", 1000, 1);
			Producto Producto4 = new Producto("Celular", 650, 2);
			Producto Producto5 = new Producto("Celular", 650, 2);
			Producto Producto6 = new Producto("Celular", 650, 2);
			Producto Producto7 = new Producto("SmartWatch", 410, 3);
			Producto Producto8 = new Producto("SmartWatch", 410, 3);
			Producto Producto9 = new Producto("Audifonos", 200, 4);
			Producto Producto10 = new Producto("Audifonos", 200, 4);

			tienda.anadirProducto(Producto1);
			tienda.anadirProducto(Producto2);
			tienda.anadirProducto(Producto3);
			tienda.anadirProducto(Producto4);
			tienda.anadirProducto(Producto5);
			tienda.anadirProducto(Producto6);
			tienda.anadirProducto(Producto7);
			tienda.anadirProducto(Producto8);
			tienda.anadirProducto(Producto9);
			tienda.anadirProducto(Producto10);

			System.out.println("Actualización de productos en stock: " + tienda.listaProductos.size());
			System.out.println(tienda);

			tienda.comprarProducto(Producto1);
		};
	};

}
