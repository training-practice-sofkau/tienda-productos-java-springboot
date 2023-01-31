package TiendaProductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Tienda {
    Scanner entrada = new Scanner(System.in);
    @Autowired
    private Cliente cliente;
    @Autowired
    private Producto producto;
    private Factura factura;

    public static void main(String[] args){
        SpringApplication.run(Tienda.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            int opc;
            do {
                System.out.println("_____________________MUEBLES LS_________________-");
                System.out.println("1. Comprar\n" +
                        "2. Historico de facuras\n" +
                        "3. <--- Atras");
                System.out.print("Digite una opcion: ");
                opc = entrada.nextInt();
                switch (opc){
                    case 1:
                        System.out.println("----------------------------------------------------------------------");
                            producto.comprar();
                            factura.facturar();
                        break;
                    case 2:
                        System.out.println("----------------------------------------------------------------------");
                            factura.mostrarHistotial();
                        break;

                    case 3:
                        System.out.println("Saliendo.....");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }while(opc<3);



        };
    }
}


@Component
class Producto {
    ArrayList<Producto> productos = new ArrayList<>();
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public void mostrarStock(){
        System.out.println("Muebles LS --- Productos "+productos);
    }

    public String toString1(){
        return " Producto"+nombre+" Cantidad disponible: "+cantidad;
    }

    public void comprar(){
        List<String> busqued = Arrays.asList(productos.toString());
        List<String> filtro = busqued.stream().filter(busqueda -> busqueda.equals(nombre)).collect(Collectors.toList());

    }

    public void cargar() {
        productos.add(new Producto("Silla plastica", 67));
        productos.add(new Producto("Mesa de madera", 50));
        productos.add(new Producto("Mesa en pino", 20));
        productos.add(new Producto("Mesa plastica", 40));
        productos.add(new Producto("Silla rimax", 50));
        productos.add(new Producto("Sofa cama sencillo", 60));
        productos.add(new Producto("Sofa cama doble", 20));
        productos.add(new Producto("Comedor 4 puestos",450));
        productos.add(new Producto("Comedor 6 puestos", 350));
        productos.add(new Producto("Sala sencilla", 100));
        productos.add(new Producto("Closet pequeño", 50));
        productos.add(new Producto("Closet mediano", 50));

        System.out.println("_________________________________________________________________________________");

    }

    public void ejecutar(){
        cargar();
        mostrarStock();

    }
}
@Component
class Cliente{
    private String name;
    private ArrayList<String> names = new ArrayList<>();
    public Cliente(String name){
        this.name = name;
    }
    public void cargarCliente(String name){
        names.add(new Cliente(name).toString());
    }

    public void mostrarCliente(){
        System.out.println(names);
    }
}

@Component
class Factura {

    private ArrayList<Factura> facturas = new ArrayList<>();
    private String nombreC;
    private String nameProducto;
    private int cant;


    Producto producto;
    Cliente cliente;
    public Factura(String nombreC, String nameProducto, int cant){
        this.nombreC = nombreC;
        this.nameProducto = nameProducto;
        this.cant = cant;
    }

    public void facturar(){
        cliente.mostrarCliente();
        producto.comprar();
    }
    public void mostrarHistotial(){
        System.out.println("Historial de facturas generadas: "+facturas);
    }
}

