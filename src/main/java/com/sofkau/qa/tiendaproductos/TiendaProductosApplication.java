package com.sofkau.qa.tiendaproductos;

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

	@Autowired
	private Catalogo catalogo;
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(){




		return args -> {

			List<Producto> añadirProducto = Arrays.asList(
					new Producto("Vestido","Largo",12,95000.0),
					new Producto("Blusa","Azul",11,19000.0),
					new Producto("Falda","Corta",9,15000.0),
					new Producto("Camiseta","manga corta con cristales",11,19000.0),
					new Producto("Blusa","año de conejo",11,19000.0),
					new Producto("Blusa","halter",11,29000.0),
					new Producto("Short","con cinturon",11,19000.0),
					new Producto("Crop","top siza",11,19000.0),
					new Producto("Falda","larga indigo",11,19000.0)
			);

			añadirProducto.stream().forEach(prenda ->{
				catalogo.addProductoaCatalogo(prenda);
			});


			System.out.println("Cantidad de productos: "+ catalogo.productosList.size());
			catalogo.mostrarCatalogo();
		};





}
}
