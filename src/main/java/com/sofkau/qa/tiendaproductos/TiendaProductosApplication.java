package com.sofkau.qa.tiendaproductos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//creo mi aplicacion SpringBoot
@SpringBootApplication
public class TiendaProductosApplication {
	//instancio la clase scanner para la entrada de texto por consola
	private  Scanner scanner = new Scanner(System.in);
	//estoy pasando una instancia con @Autowired
	@Autowired
	private ProductoService ProductoService;



	@Autowired
	private facturaService facturaService;

	//main que esta con SpringBoot por defecto
	public static void main(String[] args) {
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

	@PostConstruct
	public void start() {
		//creo funcionalidades
		System.out.println("Hola Usuario bienvenido a la tienda de Maquillaje Melisita \n");
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
				//lista para almacenar las facturas de todos los clientes
				List<Factura> facturas = facturaService.getFacturas();
				System.out.println("Registro de facturas: ");
				//recorro esta lista con un for
				for (Factura Factura : facturas) {
					System.out.println(Factura);//imprimo las facturas
				}
			} else if(eleccion==4) {
				System.exit(0);
				System.out.println("Muchas gracias, vuelva pronto");
				break;
			}

		}

	}
}


//uso @service porque necesito que SpringBoot me instancie esta clase
@Service
class ProductoService {
	//creo mi lista de productos
	private List<Producto> producticos;

	//agrego productos a esta lista creada

	public ProductoService() {
		producticos = new ArrayList<>();
		producticos.add(new Producto(1, "Zapatos", 160.000, 5));
		producticos.add(new Producto(2, "Camisetas", 28.000, 20));
		producticos.add(new Producto(3, "Pantalones", 90.000, 12));
		producticos.add(new Producto(4, "Camisa", 50.000, 15));
		producticos.add(new Producto(5, "Jogger ", 33.600, 42));
		producticos.add(new Producto(6, "Pantalonetas ", 30.000, 10));
		producticos.add(new Producto(7, "Boxers ", 10.000, 22));
		producticos.add(new Producto(8, "Medias", 8.000, 100));
		producticos.add(new Producto(9, "Chaquetas", 150.000, 22));
		producticos.add(new Producto(10, "Busos", 75.000, 40));
	}

	//creo un get para la lista de productos
	// con el objetivo de mostrar , de obtener despues esta lista
	public List<Producto> getProductosDisponibles() {

		return producticos.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
	}

	//creo metodo imprimir productos disponibes
	public void imprimirProductosDispo() {
		System.out.println("Productos disponibles:");


		for (Producto producto : getProductosDisponibles()) {
			System.out.println(producto.toString());//imprimo mi lista
		}
	}



	//creo lista para los productos que he vendido ya en el menu de arriba
	public List<Producto> productosVendidos(int id, int quantity) {


		Producto product = producticos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);



		if (product == null || product.getQuantity() < quantity) {
			return new ArrayList<>();
		}
		//uso el metodo set de prductoService para validar el stock que hay disponible en tienda
		product.setQuantity(product.getQuantity() - quantity);

		//creo lista de productos vendidos
		List<Producto> productosVendidos = new ArrayList<>();
		//recorro la lista para agregar los productos vendidos
		for (int i = 0; i < quantity; i++) {
			productosVendidos.add(product);
		}
		return productosVendidos;
	}
}


//uso @service
@Service
class facturaService {
	//creo lista de facturas
	private List<Factura> facturas;

	//creo constructor

	public facturaService() {
		facturas = new ArrayList<>();
	}

	public Factura generateFactura(List<Producto> producticos, String name) {

		double total = producticos.stream().mapToDouble(p -> p.getPrice()).sum();


		Factura factura = new Factura(name, total, producticos);
		//agrego a mi lista de facturas generadas
		facturas.add(factura);
		return factura;
	}
	//creo el metodo get
	public List<Factura> getFacturas() {
		return facturas;
	}
}
