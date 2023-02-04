package com.sofkau.qa.tiendaproductos;
import com.sofkau.qa.tiendaproductos.services.FacturaService;
import com.sofkau.qa.tiendaproductos.services.ProductoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class TiendaProductosApplication {
	//instancio la clase scanner para la entrada de texto por consola
	private  Scanner scanner = new Scanner(System.in);
	//estoy pasando una instancia con @Autowired
	@Autowired
	private ProductoService productoService;



	@Autowired
	private FacturaService facturaService;

	//main que esta con SpringBoot por defecto
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@PostConstruct
	public void start() {
		//creo funcionalidades
		System.out.println("Hola Usuario Bienvenido a la tienda de Ropa Macarron \n");
		while (true) {
			System.out.println("Por favor selecciona una opcion \n");
			System.out.println("1. Ver lista de productos disponibles");
			System.out.println("2. Comprar un producto");
			System.out.println("3. Ver Registro de facturas ");
			System.out.println("4. Salir del menu ");
			System.out.print("Ingresa tu opcion: \n");

			//uso la clase Scanner para ingreso de texto por la consola

			int eleccion = scanner.nextInt();

			//creo condicionales acorde a mis necesidades del Menu:
			//1 para mostrar la lista de productos disponibles

			if (eleccion == 1) {
				List<Producto> ProductosDisponibles = ProductoService.getProductosDisponibles();

				System.out.println("Estos son nuestros productos disponibles:");
				//recorro lista con un for
				for (Producto product : ProductosDisponibles) {
					System.out.println(product);
				}

			} else if (eleccion == 2) {

				System.out.println("Ingresa el id del producto que quieres comprar (del 1 al 10): \n");
				int id = scanner.nextInt();

				System.out.println("Ingresa la cantidad que vas a adquirir de ese producto: \n");
				int quantity = scanner.nextInt();


				scanner.nextLine();
				System.out.println("Ingresa tu nombre para generar la factura : \n");
				String customerName = scanner.nextLine();



				List<Producto> productosVendidos = ProductoService.productosVendidos(id, quantity);


				if (productosVendidos.isEmpty()) {
					System.out.println("No es posible comprar el producto con id: " + id);


				} else {
					Factura factura = facturaService.generateFactura(productosVendidos, customerName);
					System.out.println("Factura Generada exitosamente: \n" + factura);
				}


			} else if (eleccion == 3) {

				List<Factura> facturas = facturaService.getFacturas();
				System.out.println("Registro de facturas: ");

				for (Factura Factura : facturas) {
					System.out.println(Factura);
				}
			} else if(eleccion==4) {
				System.exit(0);
				System.out.println("Muchas gracias, vuelva pronto");
				break;
			}

		}

	}
}


