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
                        Factura.crearFactura(cliente,BaseDeDatos.getBaseDeDatos().getProductos().get(i),valores.get(j));
                    }
                }
            }
        }
    }
    private Tienda(){
    }
}
