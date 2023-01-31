package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class TiendaProductosApplication {

	@Autowired
	public Store store;


	public static void main(String[] args) { SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {

		return args -> {
			System.out.println("Lista de Productos: ");


			Product product1 = new Product("1", "Tv ", "LG smart", 1800000.00, 22);
			Product product2 = new Product("2", "Lapto ", "Acer game", 4800000.00, 11);
			Product product3 = new Product("3", "Audifonos ", "Motorola", 600000.00, 4);
			Product product4 = new Product("4", "Celular ", "samsung", 5800000.00, 14);
			Product product5 = new Product("5", "Modem ", "LG", 400000.00, 6);
			Product product6 = new Product("6", "Cámara ", "Go Pro", 2800000.00, 15);
			Product product7 = new Product("7", "Drone ", "Eachine E58 con cámara FullHD", 190000.00, 11);
			Product product8 = new Product("8", "micrófono ", "Boya BY-M1", 50000.00, 4);
			Product product9 = new Product("9", "Trípode celular", "Weifeng", 130000.00, 14);
			Product product10 = new Product("10", "consola ", "Microsoft Xbox", 1500000.00, 6);





			Client client1 = new Client("12", "Juan");
			Client client2 = new Client("11", "Tsuki");
			Client client3 = new Client("2", "Gina");

			PurchaseOrder facture1 = new PurchaseOrder("11", client2);
			PurchaseOrder facture2 = new PurchaseOrder("12", client1);
			PurchaseOrder facture3 = new PurchaseOrder("5", client3);

			facture1.addProduct("11", product1, 5);
			facture1.addProduct("11", product5, 1);

			facture2.addProduct("12", product5,5);


			facture1.orderPrint();
			facture2.orderPrint();

			store.addOrder(facture1);
			store.addOrder(facture2);

			    store.HistoricalList();
		};

	}
}

