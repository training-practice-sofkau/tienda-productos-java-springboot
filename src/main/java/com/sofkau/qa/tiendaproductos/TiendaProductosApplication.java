package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sofkau.qa.tiendaproductos.Model.Product;
import com.sofkau.qa.tiendaproductos.service.Invoice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TiendaProductosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("************** Bienvenido a la tienda de frutas **************");
        System.out.println("");

        Product Manzana = new Product("Manzana", 400, 1, 1);
        Product Pera = new Product("Pera", 450, 1, 2);
        Product durazno = new Product("Banano", 320, 1, 3);
        Product Naranja = new Product("Naranja", 370, 1, 4);
        Product Uva = new Product("Uva", 150, 1, 5);
        Product Kiwi = new Product("Kiwi", 120, 1, 6);
        Product Melón = new Product("Melón", 235, 1, 7);
        Product Fresa = new Product("Fresa", 356, 1, 8);
        Product Mango = new Product("Mango", 278, 1, 9);
        Product Papaya = new Product("Papaya", 356, 1, 10);
        List<Product> listProduct = Arrays.asList(Manzana, Pera, durazno, Naranja, Uva, Kiwi, Melón, Fresa, Mango, Papaya);
        List<Invoice> facturas = new ArrayList<>();
        List<Product> listCarritoDeCompra = new ArrayList<>();
        boolean whileapp = true;
        while (whileapp) {
            System.out.println("");
            System.out.println("1. Lista de productos ");
            System.out.println("2. ver carrito de compra y generar factura");
            System.out.println("3. Facturas  Guardadas");
            boolean whilefrutas = true;
            boolean whileFactura = true;

            int elegir = scan.nextInt();
            switch (elegir) {
                case 1:
                    whilefrutas = true;
                    System.out.println("************** Lista de productos **************");
                    for (Product producto : listProduct) {
                        System.out.println("");
                        System.out.println(producto.getId() + ". " + "Nombre: " + producto.getName() + ", Precio: " + producto.getPrice());
                    }
                    System.out.println("0. para regresar");
                    System.out.print("Elija una opción : ");
                    int fruta = scan.nextInt();
                    int cantidad = 0;
                    if (fruta == 0) {
                        whilefrutas = false;
                    } else {
                        System.out.print("Cantidad de fruta: ");
                        cantidad = scan.nextInt();
                    }
                    while (whilefrutas) {

                        List<Product> productsFilter = listProduct.stream().filter(product -> product.getId() == fruta).collect(Collectors.toList());

                        Product product = productsFilter.get(0);

                        switch (fruta) {
                            case 1:
                                System.out.println("Manzana");
                                listCarritoDeCompra.add(new Product("Manzana", 400, cantidad, 1));
                                System.out.println("Manzana :" + new Product("Manzana", 400, cantidad, 1).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Manzana", 400, cantidad, 1).valorTotal());
                                System.out.println("Añadido al carrito manzana");
                                whilefrutas = false;
                                break;
                            case 2:
                                System.out.println("Pera");
                                listCarritoDeCompra.add(new Product("Pera", 450, cantidad, 2));
                                System.out.println("Pera :" + new Product("Pera", 450, cantidad, 2).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Pera", 450, cantidad, 2).valorTotal());
                                System.out.println("Añadido al carrito Pera");
                                whilefrutas = false;
                                break;
                            case 3:
                                System.out.println("Banano");
                                listCarritoDeCompra.add(new Product("Banano", 320, cantidad, 3));
                                System.out.println("Banano :" + new Product("Banano", 320, cantidad, 3).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Banano", 320, cantidad, 3).valorTotal());
                                System.out.println("Añadido al carrito Banano");
                                whilefrutas = false;
                                break;
                            case 4:
                                System.out.println("Naranja");
                                listCarritoDeCompra.add(new Product("Naranja", 370, cantidad, fruta));
                                System.out.println("Naranja :" + new Product("Naranja", 370, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Naranja", 370, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Naranja");
                                whilefrutas = false;
                                break;
                            case 5:
                                System.out.println("Uva");
                                listCarritoDeCompra.add(new Product("Uva", 150, cantidad, fruta));
                                System.out.println("Uva :" + new Product("Uva", 150, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Uva", 150, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Uva");
                                whilefrutas = false;
                                break;
                            case 6:
                                System.out.println("Kiwi");
                                listCarritoDeCompra.add(new Product("Kiwi", 120, cantidad, fruta));
                                System.out.println("Kiwi :" + new Product("Kiwi", 120, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Manzana", 120, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Kiwi");
                                whilefrutas = false;
                                break;
                            case 7:
                                System.out.println("Melón");
                                listCarritoDeCompra.add(new Product("Melón", 235, cantidad, fruta));
                                System.out.println("Manzana :" + new Product("Melón", 235, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Melón", 235, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Melón");
                                whilefrutas = false;
                                break;
                            case 8:
                                System.out.println("Fresa");
                                listCarritoDeCompra.add(new Product("Fresa", 356, cantidad, fruta));
                                System.out.println("Fresa :" + new Product("Fresa", 356, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Fresa", 356, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Fresa");
                                whilefrutas = false;
                                break;
                            case 9:
                                System.out.println("Mango");
                                listCarritoDeCompra.add(new Product("Mango", 278, cantidad, fruta));
                                System.out.println("Mango :" + new Product("Mango", 278, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Mango", 278, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Mango");
                                whilefrutas = false;
                                break;
                            case 10:
                                System.out.println("Papaya");
                                listCarritoDeCompra.add(new Product("Papaya", 356, cantidad, fruta));
                                System.out.println("Papaya :" + new Product("Papaya", 356, cantidad, fruta).getPrice() + " Cantidad: " + cantidad + " Valor total: " + new Product("Papaya", 356, cantidad, fruta).valorTotal());
                                System.out.println("Añadido al carrito Papaya");
                                whilefrutas = false;
                                break;

                            default:
                                System.out.println("Opción inválida");
                                whilefrutas = false;
                        }
                    }
                    ;

                    break;
                case 2:
                    whileFactura = true;
                    System.out.println("********* Carrito de compras *********");
                    System.out.println("");
                    double varlorTotal= 0;
                    for (Product item : listCarritoDeCompra) {

                        System.out.println("Nombre: " + item.getName() + " Precio: " + item.getPrice() + " Cantidad: " + item.getAmount() + " Valor total: " + item.valorTotal());
                        System.out.println("");
                        varlorTotal = item.valorTotal() + varlorTotal ;
                    }
                    System.out.println("1. Generar factura");
                    System.out.println("0. para regresar");
                    System.out.print("Elija una opción : ");
                    int factura = scan.nextInt();
                    String nombre = "";
                    if (factura == 0) {
                        whilefrutas = false;
                    } else {
                        System.out.print("Cual es su nombre: ");
                        nombre = scan.next();
                    }
                    while (whileFactura) {
                        switch (factura) {
                            case 1:
                                System.out.println("");
                                System.out.println("********** Factura total *********");
                                System.out.println("");
                                System.out.println( new Invoice(varlorTotal,nombre,"pagado",listCarritoDeCompra).toString());
                                facturas.add(new Invoice(varlorTotal,nombre,"pagado",listCarritoDeCompra));
                                listCarritoDeCompra.clear();
                                whileFactura = false;
                                break;
                            case 0:
                                whileFactura = false;
                            default:
                                System.out.println("Opción inválida");
                                whileFactura = false;
                        }
                    }


                    break;
                case 3:
                    System.out.println("********* Historial de facturas *********");
                    for (Invoice item : facturas) {
                        System.out.println("");
                        System.out.println(item.toString());
                    }

                    break;

                default:
                    System.out.println("Opción inválida");

            }

            Invoice invoice = new Invoice(listCarritoDeCompra);


        }

    }

}
