package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;
@Service
public class Tienda{
    Scanner input=new Scanner(System.in);
    private static Tienda tienda=null;
    BaseDeDatos baseDeDatos;
    Cliente cliente;
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
        Catalogo.getCatalogo().mostrarProducto(productoAComprar());
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
        Catalogo.getCatalogo().mostrarProductos();
        Catalogo.getCatalogo().mostrarProductosAComprar();
    }
    private Tienda(){
    }
}
