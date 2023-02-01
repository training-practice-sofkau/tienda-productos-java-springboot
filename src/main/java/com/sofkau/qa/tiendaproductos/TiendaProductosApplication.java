package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//creo mi aplicacion de Tienda utilizando SpringBoot
@SpringBootApplication
public class TiendaProductosApplication {
    //instancio la clase scanner para la entrada de texto por consola
    private  Scanner scanner = new Scanner(System.in);
    //estoy pasando una instancia con @Autowired


    private ProductoService ProductoService;
    static List<Producto> productosVendidos;

    //estoy pasando una instancia con @Autowired

    @Autowired
    private FacturaService facturaService;

    //main que esta con SpringBoot por defecto
    public static void main(String[] args) {
        SpringApplication.run(TiendaProductosApplication.class, args);
    }
    //esta anotacion de @PostConstruct es utilizada en un metodo que debe ejecutarse despues de
    // realizar la inyeccion de dependencia

    public void start() {

        //creo mis funcionalidades
        System.out.println("Hola Usuario bienvenido a la tienda de Maquillaje Melisita \n");
        while (true) {
            System.out.println("Por favor selecciona una opcion \n");
            System.out.println("1. Ver lista de productos disponibles");
            System.out.println("2. Comprar un producto");
            System.out.println("3. Ver facturas ");
            System.out.println("4. Salir del menu ");
            System.out.print("Ingresa tu opcion: \n");

            //uso la clase Scanner para ingreso de texto por la consola

            int eleccion = scanner.nextInt();

            //creo mis condicionales acorde a mis necesidades del Menu:
            //1 para mostrar la lista de productos disponibles

            if (eleccion == 1) {
                List<Producto> disponiblesProducticos = ProductoService.getdisponiblesProducticos();

                System.out.println("Estos son nuestros productos disponibles:");
                //recorro mi lista con un for
                for (Producto product : disponiblesProducticos) {
                    System.out.println(product);//imprimo la lista en consola , ojo: solo para visualizarla
                }
                //2 para que el cliente ejecute su compra , luego de haber visto la lista
            } else if (eleccion == 2) {

                System.out.println("Ingresa el id del producto que quieres comprar (del 1 al 10): \n");
                int id = scanner.nextInt();

                System.out.println("Ingresa la cantidad que vas a adquirir de ese producto: \n");
                int quantity = scanner.nextInt();

                // usa scanner.nextLine() para consumir el salto de línea antes de leer el nombre del usuario
                scanner.nextLine();
                System.out.println("Ingresa tu nombre para generar la factura : \n");
                String customerName = scanner.nextLine();

                //agrego a mi nueva lista de productos vendidos , el id y la cantidad de la nueva compra



                ProductoService.productosVendidos(id, quantity);



                //en caso de que no exista un producto con ese id
                if (productosVendidos.isEmpty()) {
                    System.out.println("No es posible comprar el producto con id: " + id);

                    //sino, de inmediato se me genera la factura del cliente
                } else {
                    Factura factura = facturaService.generateFactura(productosVendidos, customerName);
                    System.out.println("Factura Generada exitosamente: \n" + factura);
                }
                //3 para que el cliente vea el registro de compras anteriores ,
                // es decir las facturas generadas anteriormente

            } else if (eleccion == 3) {
                //lista para almacenar las facturas de todos los clientes
                List<Factura> facturitas = facturaService.getfacturitas();
                System.out.println("Registro de facturas: ");
                //recorro esta lista con un for
                for (Factura Factura : facturitas) {
                    System.out.println(Factura);//imprimo las facturas
                }
            } else if(eleccion==4) {
                System.exit(0);
                System.out.println("Hasta la proxima , te esperamos de nuevo ");
                break;
            }

        }

    }
}


//uso @service porque necesito que SpringBoot me instancie esta clase

class ProductoService {
    //creo mi lista de productos
     public static ArrayList<Producto> producticos= new ArrayList<>(List.of(new Producto(1, "Polvo compacto Ruby Rose ", 20.500, 25),
        new Producto(2, "Corrector de Ani-k", 13.000, 40),
        new Producto(3, "Pestañina prosa", 37.500, 80),
        new Producto(4, "Rubor two faced", 45.200, 16),
        new Producto(5, "Delineador en gel ", 13.600, 42),
        new Producto(6, "Paleta de Sombras Rosy Mc Michael ", 230.200, 10),
        new Producto(7, "Tinta de labios Ruby Rose ", 5.000, 60),
        new Producto(8, "Base DIOR", 99.900, 25),
        new Producto(9, "Paleta de Sombras Anastacia", 150.200, 62),
        new Producto(10, "Bronzer two faced", 75.000, 21)));


        private static Map<Long, Producto> productos = new HashMap<>();

        public static Producto actualizarProducto(Long id, Producto producto) {
            if (productos.containsKey(id)) {
                productos.put(id, producto);
                return producto;
            } else {
                return null;
            }
        }

    //agrego productos a esta lista creada

    public ProductoService() {


    }

    //creo un get para la lista de productos
    // con el objetivo de mostrar , de obtener despues esta lista
    public List<Producto> getdisponiblesProducticos() {
        //implementé el uso de Stream, usando una funcion lamda
        //estoy filtrando y validando el la lista de "producticos" que la cantidad sea >0 y pueda mostrarse
        //y luego con el operador collectors , lo convierto de nuevo a lista.

        return producticos.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
    }

    //creo mi metodo imprimir productos disponibes
    public void imprimirProductosDispo() {
        System.out.println("Productos disponibles:");
        //uso un for para recorrer
        //clase : Producto
        //objeto creando ahi dentro: producto
        //metodo que necesito:getdisponiblesProducticos

        for (Producto producto : getdisponiblesProducticos()) {
            System.out.println(producto.toString());//imprimo mi lista
        }
    }

    //creo mi nueva lista para los productos que he vendido ya en el menu de arriba
    //le paso coo parametro un id y una cantidad , que corresponde a la compra del cliente
    public static List<Producto> productosVendidos(int id, int quantity) {
        //uso el tema de Stream para filtrar y validar un id para mi metodo corresondiente
        //ademas , uso findFirst para recuperar datos desde el inicio de un conjunto de registros ,
        // en mi caso de productos vendidos

        Producto product = producticos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        //valido en caso de que mi lista de productos vendidos este vacia o que la cantidad pedida sea menor a la debida
        //en ese caso, retorno a una nuva lista

        if (product == null || product.getQuantity() < quantity) {
            return new ArrayList<>();
        }
        //uso el metodo set de mi prductoService para validar el stock que hay disponible en tienda
        product.setQuantity(product.getQuantity() - quantity);

        //creo mi lista de productos vendidos
        List<Producto> productosVendidos = new ArrayList<>();
        //recorro la lista para agregar los productos que se vayan vendiendo
        for (int i = 0; i < quantity; i++) {
            productosVendidos.add(product);
        }
        return productosVendidos;
    }
}
//uso @service porque necesito que SpringBoot me instancie esta clase, debo inyectarla
@Service
class FacturaService {
    //creo mi lista de facturas
    static ArrayList<Factura> facturitas = new ArrayList<>();


    //creo mi constructor

    public FacturaService() {

    }
    //creo mi metodo para generar las facturas para los clientes
    //le paso 2 parametros: mi lista de producticos disponibles y el nombre del cliente
    public static Factura generateFactura(List<Producto> producticos, String name) {
        //hago uso de Stream para filtrar
        // para efectuar la suma correspondiente
        double total = producticos.stream().mapToDouble(p -> p.getPrice()).sum();

        //instancie mi clase Factura
        Factura factura = new Factura(name, total, producticos);
        //agrego a mi lista de facturitas generadas , esta nueva factura, para el registro
        facturitas.add(factura);
        return factura;
    }
    //creo el metodo get , para obtener las facturas , que me retorna a mi lista creada.
    public List<Factura> getfacturitas() {
        return facturitas;
    }
}
