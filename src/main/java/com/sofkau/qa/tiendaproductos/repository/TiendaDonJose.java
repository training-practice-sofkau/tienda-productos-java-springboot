package com.sofkau.qa.tiendaproductos.repository;

import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TiendaDonJose {
    private final String nombre;
    private List<Producto> productos;

    private int precioProducto;

    public TiendaDonJose() {
        this.nombre = "Tienda Don Jose";
        productos = new ArrayList<>(List.of(new Producto("1", "sal", 100, 3000),
                new Producto("2", "azucar", 100, 2500),
                new Producto("3", "cereal", 100, 5000),
                new Producto("4", "aceite", 100, 7000),
                new Producto("5", "cerveza", 100, 2800),
                new Producto("6", "ron", 100, 60000),
                new Producto("7", "aguariente", 100, 50000),
                new Producto("8", "doritos", 100, 4000),
                new Producto("9", "mantequilla", 100, 3000),
                new Producto("10", "salsa de tomate", 100, 4500)));
    }


    @Override
    public String toString() {
        return "TiendaDonJose{" +
                "nombre='" + nombre + '\'' +
                ", productos=" + productos +
                ", precioProducto=" + precioProducto +
                '}';
    }

    public void disminuirStock(String id){
        List<Producto> resultado = productos.stream().map(producto -> {
            if(producto.getId().equals(id)){
                producto.disminuirStock();
                return producto;
            }
            return producto;
        }).collect(Collectors.toList());
    }


    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

