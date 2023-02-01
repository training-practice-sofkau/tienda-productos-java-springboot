package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void comprar(ArrayList<String> claves,ArrayList<Integer> valores,Cliente cliente){
        for(int i=0;i<BaseDeDatos.getBaseDeDatos().getProductos().size();i++){
            for(int j=0;j<claves.size();j++){
                if(BaseDeDatos.getBaseDeDatos().getProductos().get(i).getNombre().equalsIgnoreCase(claves.get(j))){
                    if(BaseDeDatos.getBaseDeDatos().getProductos().get(i).getCantidad()<valores.get(j)){
                        System.out.println("No hay suficientes productos");
                    }else{
                        BaseDeDatos.getBaseDeDatos().getProductos().get(i).setCantidad(
                                BaseDeDatos.getBaseDeDatos().getProductos().get(i).getCantidad() - valores.get(j)
                        );
                        Factura.crearFactura(cliente,BaseDeDatos.getBaseDeDatos().getProductos().get(i));
                    }
                }
            }
        }
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
