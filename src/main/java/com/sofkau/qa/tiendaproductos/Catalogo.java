package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Catalogo implements Produccion{
    private static Catalogo catalogo=null;
    public static Catalogo getCatalogo(){
        if(catalogo==null)
            return new Catalogo();
        return catalogo;
    }
    private Catalogo(){
    }
    @Override
    public void addProducto(Producto producto){
        BaseDeDatos.getBaseDeDatos().addProducto(producto);
    }
    public void mostrarProducto(int producto){
        Producto impresion=BaseDeDatos.getBaseDeDatos().getProductos().get(producto);
        System.out.println("Nombre: "+impresion.getNombre()+
                "\nCantidad disponible: "+impresion.getCantidad()+
                "\nPrecio: "+impresion.getPrecio()+
                "\nDescripción: "+impresion.getDescripcion());
    }
    public List<Producto> mostrarProductos(){
        return BaseDeDatos.getBaseDeDatos().getProductos();
    }
    public void mostrarProductosAComprar(){
        int i=0;
        for(Producto producto:BaseDeDatos.getBaseDeDatos().getProductos()){
            i++;
            System.out.println(i+" Nombre: "+producto.getNombre());
        }
        System.out.println();
    }
}
