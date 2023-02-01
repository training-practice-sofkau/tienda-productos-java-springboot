package TiendaProductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class PruebaApp {
    Scanner entrada = new Scanner(System.in);


@Autowired
public TiendaLS tiendaLS;

    public static void main(String[] args){
        SpringApplication.run(PruebaApp.class,args);
    }

@Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            String name = "Pedro";
            String nproducto= "Reloj Q&Q";
            int cant = 5;
            int opc;
            System.out.println("___________________________ TIENDA LS __________________________________");

            System.out.print("Nombre del cliente: "+name);
            tiendaLS.cargarCliente(name);
            System.out.println();
            do {
                System.out.print("1. Comprar\n" +
                        "2. Historial de compras\n" +
                        "Seleccione una opcion: ");
                opc = entrada.nextInt();
                switch (opc){
                    case 1:
                        tiendaLS.mostrarStock();
                        System.out.println("Ingrese el nombre del producto a comprar: "+nproducto);
                        System.out.println("Cantidad a comprar: "+cant);

                        break;
                    case 2:
                        break;
                }
            }while(opc>2);

        };
    }

}
@Service
class TiendaLS{
    public List<Producto> stock;
    Cliente cliente;
    Compra compra;

    public TiendaLS() {
        this.stock = new ArrayList<>();
    }

    public void añadirListaStock(){
        List<Producto> productos = Arrays.asList(
                new Producto("Reloj inteligete niño",100),
                new Producto("Reloj inteligete dama", 150),
                new Producto("Reloj inteligete hombre", 120),
                new Producto("Reloj Rolex",120),
                new Producto("Reloj Q&Q",150),
                new Producto("Relog digital", 100),
                new Producto("Reloj de pared",100),
                new Producto("Reloj de escritorio", 200),
                new Producto(" Reloj de mesa de noche", 200),
                new Producto("Reloj Casio", 180)
        );
        productos.stream().forEach(producto -> {
            cargarProducto(producto);
        });
        System.out.println("____________________PRODUCTOS DISPONIBLES TIENDA LS: "+stock.size());

    }

    public void mostrarStock(){
        stock.stream().forEach(producto -> {
            System.out.println("Producto: "+producto.getNombre()+"Cantidad existente: "+producto.getCantidad());
        });
    }
    public void cargarProducto(Producto producto){
        System.out.println("Producto: "+ producto.getNombre()+"         Existencias: "+producto.getCantidad());
        stock.add(producto);
    }

    public String toString(){
        return "Producto: "+stock;
    }

    public void cargarCliente(String name){
        cliente = new Cliente(name);
        System.out.println(" Cliente: "+cliente.getName()+" registrado exitosamente....");
    }

}
class Producto{

    private String nombre;
    private int cantidad;

    public  Producto(String nombre, int cantidad){
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
class Cliente{
    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cliente registrado: "+ name ;
    }
}
class Compra{
    private String nameP;
    private int cant;

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Compra(String nameP, int cant) {
        this.nameP = nameP;
        this.cant = cant;
    }
    public void disminuirCantidad(int cant) {
        this.cant = this.cant - cant;
    }
}

class Factura {
    private Cliente cliente;
    private int num;
    private List<Producto> prodComprados;


    public Factura(Cliente cliente){

        this.cliente=cliente;
        prodComprados = new ArrayList<>();

    }

    public int getNumFact() {
        return num;
    }

    public void agregarCompra(Producto producto) {
        prodComprados.add(producto);
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura numero=" + num + "," + cliente +
                ", \nprodComprados=" + prodComprados.toString() ;
    }

}
class Todo {
    private Producto misProductos;
    private List<Factura> misFacturas;
    private Factura factuaActual;
    private Producto productoEntrada;

    public Todo(Producto misProductos) {
        this.misProductos = misProductos;
        this.misFacturas = new ArrayList<>();
    }

    public void agregarFactura(Factura miFactura) {
        factuaActual = miFactura;
        misFacturas.add(factuaActual);
    }

    public List<Factura> obtenerFacturas(){
        return misFacturas;
    }


}