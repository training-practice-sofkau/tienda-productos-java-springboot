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
    public Producto mostrarProducto(Producto producto){
        return producto;
    }
    public List<Producto> mostrarProductos(){
        return BaseDeDatos.getBaseDeDatos().getProductos();
    }
}
