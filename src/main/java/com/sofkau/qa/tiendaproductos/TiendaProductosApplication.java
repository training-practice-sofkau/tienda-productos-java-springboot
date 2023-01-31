package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class TiendaProductosApplication {


	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

		@Bean
		public CommandLineRunner commandLineRunner(){
			return args -> {

				System.out.println("-----------------------------------" +
									" \n Bienvenidos a nuestra tienda de ropa online para hombre y mujer! Aquí encontraras una  \n " +
									"amplia seleccion de estilos y tendencias para vestir con confianza en cualquier ocasion. \n " +
									"Explora nuestro catalogo, encuentra tu look favorito \n -----------------------------");

				Menu menuEntrada = new Menu();
				menuEntrada.menuPrincipal();

			};

	}

}
