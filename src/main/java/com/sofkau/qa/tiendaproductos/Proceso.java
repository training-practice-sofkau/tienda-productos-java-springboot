package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Proceso {

	@Autowired
	public Tienda tienda;
	public Factura factura;
	public static void main(String[] args) {
		SpringApplication.run(Proceso.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (){
		return args -> {

			Producto Producto1 = new Producto("Computador", 1000, 1);
			Producto Producto2 = new Producto("Computador", 1000, 1);
			Producto Producto3 = new Producto("Computador", 1000, 1);
			Producto Producto4 = new Producto("Celular", 650, 2);
			Producto Producto5 = new Producto("Celular", 650, 2);
			Producto Producto6 = new Producto("Celular", 650, 2);
			Producto Producto7 = new Producto("SmartWatch", 410, 3);
			Producto Producto8 = new Producto("SmartWatch", 410, 3);
			Producto Producto9 = new Producto("Audifonos", 200, 4);
			Producto Producto10 = new Producto("Audifonos", 200, 4);

			List<Producto> productosTienda = new ArrayList<>();
			productosTienda.add(Producto1);
			productosTienda.add(Producto2);
			productosTienda.add(Producto3);
			productosTienda.add(Producto4);
			productosTienda.add(Producto5);
			productosTienda.add(Producto6);
			productosTienda.add(Producto7);
			productosTienda.add(Producto8);
			productosTienda.add(Producto9);
			productosTienda.add(Producto10);


			tienda.anadirProducto(Producto1);
			tienda.anadirProducto(Producto2);
			tienda.anadirProducto(Producto3);
			tienda.anadirProducto(Producto4);
			tienda.anadirProducto(Producto5);
			tienda.anadirProducto(Producto6);
			tienda.anadirProducto(Producto7);
			tienda.anadirProducto(Producto8);
			tienda.anadirProducto(Producto9);
			tienda.anadirProducto(Producto10);

			System.out.println("Productos en stock: " + tienda.listaProductos.size());
			System.out.println(tienda);

				System.out.println("Lista de productos");
				tienda.nombrarProductos();

				System.out.println("------------PROCESO DE COMPRA------------");
				System.out.println("¿Que producto desea comprar?");
			    Producto productoEncontrado = productosTienda.stream().filter(c -> c.idProducto == 1).findAny().get();
				System.out.println("¿Que cantidad?");
				Integer cantidad = 1;

				System.out.println("Actualización productos en stock: " + tienda.listaProductos.size());

				System.out.println("------------GENERAR FACTURA-----------");
				System.out.println("¿Cual es su nombre?");
			    factura = new Factura("Carlos Perez");

				factura.getNombreCliente();
				System.out.println("GENERANDO FACTURA............!");

				tienda.comprarProducto(factura, productoEncontrado, cantidad);

				System.out.println(factura);
				System.out.println(factura.generarFactura());
				System.out.println("Factura entregada con exito");
		} ;
	};

}
