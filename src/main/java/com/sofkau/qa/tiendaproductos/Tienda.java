package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Tienda {

    public List<Factura> listaDeFacturas;
    public Map<Producto, Integer> listaProductos;

    public Tienda() {
        this.listaProductos = new HashMap<Producto, Integer>();
        this.listaDeFacturas = new ArrayList<>();
    }
    public void nombrarProductos(){

        listaProductos.forEach(
                (key, value)
                        ->  System.out.println("Nombre producto: " + key.getNombre() + ", Cantidad en stock:" + value)
        );

    }

    public void anadirProducto(Producto producto){
        var productoEnStock = listaProductos.containsKey(producto);

        if(productoEnStock)
        {
            listaProductos.put(producto, listaProductos.get(producto) + 1);
        }
        else{
            listaProductos.put(producto, 1);
        }
    }

    public void removerProducto(Producto producto){
        var productoEnStock = listaProductos.containsKey(producto);

        if(productoEnStock)
        {
            listaProductos.put(producto, listaProductos.get(producto) - 1);
        }
    }
    public void comprarProducto(Factura factura, Producto producto, Integer cantidad){
        if (listaProductos.size() > 0)
        {
            var productoEnStock = listaProductos.containsKey(producto);
            if(productoEnStock == false) System.out.println("El producto seleccionado no esta disponible");

            System.out.println("Hay productos disponibles");
            removerProducto(producto);
            factura.añadirProducto(producto, cantidad);

            System.out.println("Producto añadido");

        }
        else {System.out.println("No hay productos disponibles");
        }
    }

    public void finalizarCompra(Factura factura){

        System.out.println(factura.generarFactura());
        listaDeFacturas.add(factura);
    }

    @Override
    public String toString() {
        return '\n' + "Tienda: " +'\n' +
                "Productos en stock: " + listaProductos;
    }
}
