package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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

			Producto producto1 = new Producto("1","1",1,1.0);
			Producto producto2 = new Producto("1","1",1,1.0);

			catalogo.addProductoaCatalogo(producto1);
			catalogo.addProductoaCatalogo(producto2);
			System.out.println("Cantidad de productos: "+ catalogo.productosList.size());
			catalogo.mostrarCatalogo();
		};





}
}
