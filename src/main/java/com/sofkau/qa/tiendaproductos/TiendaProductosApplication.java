package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaProductosApplication {

	@Autowired
	public ShopPc shopPc;


	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);
	}
	@Bean
	public CommandLineRunner cambiarEstenombre(){

		return args -> {
			System.out.println("**** ShopPc ***");
			System.out.println();
			System.out.println("Articulos de la tienda\n");

			ShopPc prueba = new ShopPc();
			prueba.tienda();
		};
	}

}
