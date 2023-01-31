package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Catalogo implements Produccion{
    @Override
    public void addProducto(Producto producto){
        BaseDeDatos.getBaseDeDatos().addProducto(producto);
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
    }
}
