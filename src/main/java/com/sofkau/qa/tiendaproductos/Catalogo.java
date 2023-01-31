package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;

public class Catalogo implements Produccion{
    @Autowired
    BaseDeDatos catalogoDeProductos;
    @Override
    public void addProducto(int posicion,Producto producto){
        catalogoDeProductos.addProducto(posicion,producto);
    }
}
