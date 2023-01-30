package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
		InterfazUsuario interfazUsuario = new InterfazUsuario();
		interfazUsuario.menu();
	}

}
