package com.sofkau.qa.tiendaproductos.repository;

import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TiendaLS {
    private final String nombre;
    private List<Producto> productos;

    private int precioProducto;

    public TiendaLS() {
        this.nombre = "Tienda LS";
        productos = new ArrayList<>(List.of(
                new Producto("1", "Reloj rolex", 150, 600000),
                new Producto("2", "Reloj Casio", 150, 15000),
                new Producto("4", "Reloj Q&Q", 150, 120000),
                new Producto("5", "Reloj de mesa", 150, 30000),
                new Producto("6", "Reloj de pared", 150, 20000),
                new Producto("7", "Reloj para niño", 150, 10000),
                new Producto("8", "Reloj dama digital", 150, 150000),
                new Producto("9", "Reloj hombre digital", 150, 150000),
                new Producto("10", "Reloj escritorio ", 105, 45000)));
    }


    @Override
    public String toString() {
        return "TiendaLS{" +
                "nombre='" + nombre + '\'' +
                ", productos=" + productos +
                ", precioProducto=" + precioProducto +
                '}';
    }

    public void actualizarStock(String id){
        List<Producto> resultado = productos.stream().map(producto -> {
            if(producto.getId().equals(id)){
                producto.actalizarStock();
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

