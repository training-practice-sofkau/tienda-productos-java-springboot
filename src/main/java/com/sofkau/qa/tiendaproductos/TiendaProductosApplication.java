package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {

		SpringApplication.run(TiendaProductosApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args ->{
            int opcion1 = 0;
            int opcion2 = 0;
            int cantidad = 0;
            String nombre;
            String cedula;

            Scanner entrada;

            Stock miStock = new Stock();
            miStock.agregarProducto("1", "Cuaderno", 2.500, 100);
            miStock.agregarProducto("2", "Lapiz", 1.000, 100);
            miStock.agregarProducto("3", "Reglas", 3.000, 100);
            miStock.agregarProducto("4", "Borrador", 600, 100);
            miStock.agregarProducto("5", "Carpeta", 4.500, 100);
            miStock.agregarProducto("6", "Marcadores", 1.800, 100);
            miStock.agregarProducto("7", "Colores", 8.000, 100);
            miStock.agregarProducto("8", "Tajalapiz", 800, 100);
            miStock.agregarProducto("9", "Foami", 1.600, 100);
            miStock.agregarProducto("10", "Cartulina", 1.200, 100);

            // miStock.listarProductos();
            Tienda miTienda = new Tienda(miStock);

            do {

                System.out.println("############################");
                System.out.println("		OPCIONES            ");
                System.out.println("1.Listar");
                System.out.println("2.Nueva Compra");
                System.out.println("3.Ver historial");
                System.out.println("4.Ver historial de cliente");
                System.out.println("5.salir");
                System.out.println("############################");

                entrada = new Scanner(System.in);

                System.out.print("Seleccionar opcion: ");
                opcion1 = Integer.parseInt(entrada.next());

                switch (opcion1) {
                    case 1:

                        miTienda.listarProductos();
                        break;
                    case 2:

                        System.out.print("Cedula: ");
                        cedula = entrada.next();
                        System.out.print("Nombre: ");
                        nombre = entrada.next();
                        Factura nuevaFactura = new Factura(new Cliente(cedula, nombre));
                        miTienda.agregarFactura(nuevaFactura);

                        do {
                            System.out.println("#####################################################");
                            System.out.println("		SELECCIONE EL PRODUCTO A AGREGAR            ");
                            for (int i = 0; i < miStock.getMisProductos().size(); i++) {
                                System.out.println(i + 1 + ".agregar: " + miStock.getMisProductos().get(i).getNombre());
                            }
                            System.out.println(miStock.getMisProductos().size() + 1 + ".Terminar compra");
                            System.out.println("#####################################################");

                            System.out.print("Seleccionar opcion: ");
                            opcion2 = Integer.parseInt(entrada.next());

                            if (opcion2 < miStock.getMisProductos().size() + 1) {
                                String tempId = miStock.getMisProductos().get(opcion2 - 1).getId();
                                String tempNombre = miStock.getMisProductos().get(opcion2 - 1).getNombre();
                                double tempPrecio = miStock.getMisProductos().get(opcion2 - 1).getPrecio();
                                int tempCantidad = 0;

                                ProdCantidad temporal = new ProdCantidad(tempId, tempNombre, tempPrecio, tempCantidad);

                                System.out.print("Cantidad a comprar: ");
                                cantidad = Integer.parseInt(entrada.next());

                                temporal.setCantidad(cantidad);

                                miTienda.agregarProductos(temporal);
                            }

                        } while (opcion2 <= miStock.getMisProductos().size());

                        break;
                    case 3:
                        miTienda.generarTotal();
                        for (Factura miFactura : miTienda.obtenerFacturas()) {
                            System.out.println(miFactura);
                        }
                        break;

                    case 4:
                        miTienda.generarTotal();
                        System.out.print("Escribe la cedula del cliente: ");
                        cedula = entrada.next();
                        miTienda.obtenerFacturasCliente(cedula);
                        break;

                    case 5:
                        System.out.println("saliendo");
                        break;
                }

            } while (opcion1 != 5);
		};
	}

}
