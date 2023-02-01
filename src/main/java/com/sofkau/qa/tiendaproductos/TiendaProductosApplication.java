package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scan = new Scanner(System.in);
		List<Producto> products = new ArrayList<Producto>();
		List<Invoice> invoices = new ArrayList<Invoice>();
		String name = "";

			products.add(new Producto("Full Metal Alchemist 1", 10.0));
			products.add(new Producto("Jujutsu Kaisen 2", 20.0));
			products.add(new Producto("Bochii the Rock 3", 30.0));
			products.add(new Producto("Kimetsu no Yaiba 4", 40.0));
			products.add(new Producto("Sono Bisque Doll 5", 50.0));
			products.add(new Producto("Vinland SAGA 6", 60.0));
			products.add(new Producto("Shingeky no Kyojin 7", 70.0));
			products.add(new Producto("Ore monogatari 8", 80.0));
			products.add(new Producto("Shuumatsu no Valquirie 9", 90.0));
			products.add(new Producto("Baki 10", 100.0));

			boolean running = true;
			while (running) {
				System.out.println("\n--- Menu ---");
				System.out.println("1. Ver Anime");
				System.out.println("2. Comprar");
				System.out.println("3. invoices");
				System.out.println("4. Cambiar otaku");
				System.out.println("5. Salir");
				System.out.print("Escoja las opciones anteriores: ");

				int choice = scan.nextInt();
				switch (choice) {
					case 1:
						System.out.println("\n--- Lista de animes ---");
						for (int i = 0; i < products.size(); i++) {
							System.out.println(i + 1 + ". " + products.get(i).toString());
						}
						break;
					case 2:
						System.out.println("\n--- Comprar ---");
						ArrayList<Producto> cart = new ArrayList<Producto>();
						double total = 0;
						boolean buying = true;
						while (buying) {
							System.out.println("Ingresa el id del producto (0 para finalizar): ");
							int productNum = scan.nextInt();
							if (productNum == 0) {
								buying = false;
							} else {
								Producto product = products.get(productNum - 1);
								System.out.println("Cuantos?: ");
								int quantity = scan.nextInt();
								total += product.getPrice() * quantity;
								cart.add(new Producto(product.getName(), product.getPrice(), quantity));
							}
						}
						Invoice invoice = new Invoice(name, total, cart);
						invoices.add(invoice);
						System.out.println("\n--- Invoice ---");
						System.out.println(invoice.toString());
						break;
					case 3:
						System.out.println("\n--- Invoices ---");
						for (int i = 0; i < invoices.size(); i++) {
							System.out.println(i + 1 + ". " + invoices.get(i).toString());
						}
						break;
					case 4:
						System.out.print("Escribe tu nombre...: ");

						scan.nextLine();
						name = scan.nextLine();
						break;
					case 5:
						running = false;
						break;
					default:
						System.out.println("Opción invalida");
				}
			}
		System.out.println("Sayonara!");
	}

}


