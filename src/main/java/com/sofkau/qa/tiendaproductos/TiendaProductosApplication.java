package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.repository.TiendaDonJose;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	}
};