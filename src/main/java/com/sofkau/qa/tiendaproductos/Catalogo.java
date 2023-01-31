package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Catalogo implements Produccion{
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
    public void mostrarProductos(){
        BaseDeDatos.getBaseDeDatos().getProductos().stream().forEach(producto -> {
            System.out.println("Nombre: "+producto.getNombre()+
                    "\nCantidad disponible: "+producto.getCantidad()+
                    "\nPrecio: "+producto.getPrecio()+
                    "\nDescripción: "+producto.getDescripcion()+"\n");
        });
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
