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
									" \n Bienvenido a nuestra tienda de Verduras Frescas. Estamos emocionados de ofrecerle la mejor seleccion \n " +
									"de productos cultivados con amor y cuidado. Haga su pedido en linea hoy mismo! \n -----------------------------");

				Menu menuEntrada = new Menu();
				menuEntrada.menuPrincipal();



			};

	}

}
