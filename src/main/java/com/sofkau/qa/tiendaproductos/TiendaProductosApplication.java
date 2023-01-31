package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class TiendaProductosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

		};
	}
	@Override
	public void run(String... args) throws Exception {
		int idc=4;
		int idp=5;
		int idf=1;
		int opcion;
		int c=0;
		int clientei;
		int verificar;
		double totalPagar=0;
		String nombreProducto;
		String nombreCliente;
		int idCliente;
		int cantidadProducto;
		int idProducto;
		int productoi;
		Scanner entrada = new Scanner(System.in);
		HashMap<Integer, Cliente> listaClientes=new HashMap<>();
		ArrayList<ProductoInventario> inventario=new ArrayList<>();

		Cliente c1=new Cliente("Fabio",1);
		Cliente c2=new Cliente("Carlos",2);
		Cliente c3=new Cliente("Mario",3);

		listaClientes.put(c1.getId(),c1);
		listaClientes.put(c2.getId(),c2);
		listaClientes.put(c3.getId(),c3);

		ProductoInventario p1=new ProductoInventario("Arroz",1,60,200);
		ProductoInventario p2=new ProductoInventario("Lentejas",2,40,300);
		ProductoInventario p3=new ProductoInventario("Gaseosa",3,10,400);
		ProductoInventario p4=new ProductoInventario("Papitas",4,30,500);

		inventario.add(p1);
		inventario.add(p2);
		inventario.add(p3);
		inventario.add(p4);

		do {
			System.out.println("1: Seleccionar cliente");
			System.out.println("2: Ingresar cliente");
			System.out.println("3: Agregar producto");
			System.out.println("4: Salir");
			opcion = entrada.nextInt();
			switch (opcion) {
				case 1:
					for(Map.Entry<Integer,Cliente> entry: listaClientes.entrySet()){
						System.out.println(c+": Nombre:"+entry.getValue().getNombre()+" | Id:"+ entry.getKey());
						c=c+1;
					}
					System.out.println("Por favor escriba el id del cliente");
					clientei = entrada.nextInt();
					c=0;
					System.out.println("1: Agregar productos al carrito");
					System.out.println("2: Comprar");
					System.out.println("3: Ver facturas");
					opcion=entrada.nextInt();
					switch (opcion) {
						case 1:
							do {
								System.out.println("Carrito");
								if (!listaClientes.get(clientei).verificarCarrito()) {
									listaClientes.get(clientei).verProductos(totalPagar);
								} else {
									System.out.println("Carrito vacio");
								}
								Iterator<ProductoInventario> i = inventario.iterator();
								while (i.hasNext()) {
									System.out.println(c + ": " + i.next().toString());
									c = c + 1;
								}
								c = 0;
								System.out.println("Seleccione el indice del producto, o escriba un numero negativo si no desea comprar mas productos");
								productoi = entrada.nextInt();
								if(productoi>=0) {
									System.out.println("Ingrese la cantidad que desea comprar");
									cantidadProducto = entrada.nextInt();
									ProductoInventario productoInventarioAux = inventario.get(productoi);
									ProductoCompra productoCompraAux = new ProductoCompra(productoInventarioAux.getNombre(), productoInventarioAux.getId(), cantidadProducto, productoInventarioAux.getPrecio());
									inventario.get(productoi).setCantidad(inventario.get(productoi).getCantidad() - cantidadProducto);

									if (listaClientes.get(clientei).verificarProducto(productoCompraAux.getId())) {
										listaClientes.get(clientei).verificarProductoCarrito(productoCompraAux.getId(), cantidadProducto);
									} else {
										listaClientes.get(clientei).aniadirProductoCompra(productoCompraAux);
									}
								}
							}while(productoi>=0);

						break;
						case 2:
							LinkedList<ProductoCompra> carritoAux=(LinkedList<ProductoCompra>) listaClientes.get(clientei).getProductos().clone();
							Factura facturaAux=new Factura(idf, LocalDate.now(),carritoAux);
							System.out.println("Factura generada");
							facturaAux.generarFactura();
							listaClientes.get(clientei).aniadirFactura(facturaAux);
							listaClientes.get(clientei).clearCarrito();
						break;
						case 3:
							if(!listaClientes.get(clientei).verificarFacturas()){
								listaClientes.get(clientei).verFacturas();
							}

						break;
						}

					break;
				case 2:
					System.out.println("Ingrese el nombre del Cliente");
					nombreCliente=entrada.next();
					Cliente clinteAux=new Cliente(nombreCliente,idc);
					listaClientes.put(clinteAux.getId(),clinteAux);
					idc=idc+1;
					break;
				case 3:
					System.out.println("1: Producto nuevo\n2: Producto existente");
					opcion=entrada.nextInt();
					if(opcion==1){
						System.out.println("Ingrese el nombre del producto");
						nombreProducto=entrada.next();
						System.out.println("Ingrese la cantidad a aniadir");
						cantidadProducto=entrada.nextInt();
						inventario.add(new ProductoInventario(nombreProducto,idp,cantidadProducto,600));
						idp=idp+1;
					}else{
						Iterator<ProductoInventario> i = inventario.iterator();
						while (i.hasNext()) {
							System.out.println(c + ": " + i.next().toString());
							c = c + 1;
						}
						c = 0;
						System.out.println("Seleccione el indice del producto");
						productoi = entrada.nextInt();
						System.out.println("Ingrese la cantidad");
						cantidadProducto=entrada.nextInt();
						inventario.get(productoi).setCantidad(inventario.get(productoi).getCantidad()+cantidadProducto);
					}

					break;
			}
		} while (opcion <= 3);
	}
}
