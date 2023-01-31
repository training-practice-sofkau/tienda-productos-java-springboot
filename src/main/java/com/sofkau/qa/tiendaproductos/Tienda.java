package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Tienda {

    public List<Producto> listaProductos;

    public Tienda() {
        this.listaProductos = new ArrayList<>();
    }
    public void nombrarProductos(){
        listaProductos.stream().forEach(producto -> {
            System.out.println("Nombre producto: " + producto.getNombre());
            System.out.println("Precio del producto: " + producto.getPrecioUnit());
            System.out.println("Cantidad en stock: " + producto.getIdProducto());
        });
    }
    public void anadirProducto(Producto producto){
        listaProductos.add(producto);
    }
    public void comprarProducto(Producto producto){
        if (listaProductos.size() > 0) {
            System.out.println("Hay productos disponibles");
            listaProductos.remove(producto);
            producto.setIdProducto(producto.idProducto);
            producto.setNombre(producto.nombre);
            producto.setPrecioUnit(producto.precioUnit);
            System.out.println("Compra exitosa");
        }else {System.out.println("No hay productos disponibles");
        }
    }

    @Override
    public String toString() {
        return '\n' + "Tienda: " +'\n' +
                "Productos en stock: " + listaProductos;
    }
}
