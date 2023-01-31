package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;
@Service
public class Tienda{
    Scanner input=new Scanner(System.in);
    private static Tienda tienda=null;
    @Autowired
    BaseDeDatos baseDeDatos;
    @Autowired
    Cliente cliente;
    @Autowired
    Catalogo catalogo;
    public static Tienda getTienda(){
        if (tienda==null)
            return new Tienda();
        return tienda;
    }
    public void ejecutar(){
        do{
        }while(mostrarMenu()!=3);
    }
    public int mostrarMenu(){
        int op=0;
        agregar();
        System.out.println("Bienvenido a TuCocina" +
                "\nElige la opción a ejecutar:" +
                "\n1. Comprar" +
                "\n2. Registro de compras" +
                "\n3. Salir");
        while(true) {
            try {
                op = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número para continuar");
                input.nextLine();
            }
        }
        menu(op);
        return op;
    }
    public void menu(int op){
        switch(op){
            case 1: comprar();
                    break;
            case 3: System.out.println("Gracias por preferirnos");
                    break;
            default:
                System.out.println("Elige una opción válida");
        }
    }
    public void comprar(){
        mostrarProductos();
        catalogo.mostrarProducto(productoAComprar());
        cantidadAComprar();

    }
    public void cantidadAComprar(){
        int cantidad;
        System.out.println("Indica la cantidad que deseas comprar ");
        while(true) {
            try {
                cantidad=input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número para continuar");
                input.nextLine();
            }
        }

    }
    public int productoAComprar(){
        int producto;
        System.out.println("Ingrese el número del producto que desea comprar");
        while(true) {
            try {
                producto=input.nextInt()-1;
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número para continuar");
                input.nextLine();
            }
        }
        return producto;
    }
    public void mostrarProductos(){
        System.out.println("Elija el producto que desea comprar");
        catalogo.mostrarProductos();
        catalogo.mostrarProductosAComprar();
    }
    public void agregar(){
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Sarten Antiadherente")
                .cantidad(10)
                .precio(50000)
                .descripcion("Sarten de acero inoxidable con revestimiento antiadherente.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Batidora de Mano")
                .cantidad(15)
                .precio(70000)
                .descripcion("Batidora eléctrica con potencia de 300W y varillas de acero inoxidable.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Olla a Presión")
                .cantidad(5)
                .precio(90000)
                .descripcion("Olla con capacidad de 6 litros y sistema de seguridad de válvula.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Tostadora de Pan")
                .cantidad(20)
                .precio(40000)
                .descripcion("Tostadora con ajuste de temperatura y bandeja recolectora de migas.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Licuadora")
                .cantidad(10)
                .precio(80000)
                .descripcion("Licuadora con potencia de 600W y vaso de vidrio de 1,5 litros.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Exprimidor Eléctrico")
                .cantidad(15)
                .precio(60000)
                .descripcion("Exprimidor eléctrico con filtro de pulpa y capacidad de 1 litro.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Cafetera Automática")
                .cantidad(5)
                .precio(150000)
                .descripcion("Cafetera con capacidad de 1,5 litros y programador de encendido.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Ollas y Sartenes Set")
                .cantidad(3)
                .precio(200000)
                .descripcion(" Juego de ollas y sartenes de acero inoxidable con revestimiento antiadherente.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Plancha de Asar")
                .cantidad(10)
                .precio(100000)
                .descripcion("Plancha con revestimiento antiadherente y control de temperatura ajustable.").build());
        catalogo.addProducto(new ProductoBuilder()
                .nombre("Microondas")
                .cantidad(5)
                .precio(150000)
                .descripcion("Microondas con capacidad de 20 litros y programas de cocción automáticos.").build());
    }
    private Tienda(){
        catalogo=new Catalogo();
    }
}
