package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
