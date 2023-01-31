package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {

		CasaMusical casaMusical=new CasaMusical();


		SpringApplication.run(TiendaProductosApplication.class, args);
	}

}
