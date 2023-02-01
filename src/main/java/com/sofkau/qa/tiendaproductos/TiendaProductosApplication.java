package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.datos.ProductosStock;
import com.sofkau.qa.tiendaproductos.datos.StockMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {
	/**
	 * Se utiliza la anotación Autowired para genera una instancia de StockMethods, y así acceder a la
	 * implementación de los métodos definidos en estas interfaz.
	 */

	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);

	}

}
