package com.sofkau.qa.tiendaproductos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			System.out.println("Numero de productos iniciales: " + ferreteria.productoList.size() + "\n");

			ferreteria.agregarProductos(new Producto("Cemento 50 kg", 33500,10));
			ferreteria.agregarProductos(new Producto("Metaldeck 2in Cal.22 ", 311000,10));
			ferreteria.agregarProductos(new Producto("Varilla Corrugada 1/2in", 29000,10));
			ferreteria.agregarProductos(new Producto("Caja de puntilla", 5000,20));
			ferreteria.agregarProductos(new Producto("Galon de Pintura", 25000,15));
			//ferreteria.mostrarProductos();


		};
	}
}

