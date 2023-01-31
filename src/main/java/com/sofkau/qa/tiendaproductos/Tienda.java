package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {

    private List <Producto> productoList;
    private List <Cliente> clienteList;


    public Tienda(List<Producto> productoList, List <Cliente> clienteList) {
        this.productoList = productoList;
        this.clienteList = clienteList;
    }

    public void verClientes(){
        System.out.println("Clientes: " + clienteList.toString());
    }

    public void verProductos(){
        System.out.println("Productos: " + productoList.toString());
    }

    public void iterarProducto(String nombre){
        List<Producto> productos1  = productoList.stream().filter(producto ->
                nombre.equals(producto.getNombreProducto())).toList();

    }


}
