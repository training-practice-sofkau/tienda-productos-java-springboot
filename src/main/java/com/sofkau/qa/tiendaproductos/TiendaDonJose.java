package com.sofkau.qa.tiendaproductos;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


public class TiendaDonJose {

    private String nombre;
    List<Producto> productos;
    List<Cliente> registro;
    List<String> nombreProducto;
public TiendaDonJose(String nombre) {
        this.nombre = nombre;
        productos = Arrays.asList(
                new Producto("Sal",100,3000),
                new Producto("Azucar",100,2500),
                new Producto("Cereal",100,5000),
                new Producto("Aceite",100,7000),
                new Producto("Cerveza",100,2800),
                new Producto("Ron",100,60000),
                new Producto("Aguariente",100,50000),
                new Producto("Doritos",100,4000),
                new Producto("Mantequilla",100,3000),
                new Producto("Salsa de tomate",100,4500)
        );
        registro = Arrays.asList(new Cliente("Efrain",11111));
        nombreProducto = Arrays.asList("Sal","Azucar","Cereal","Aceite","Ron","Aguardiente", "Doritos", "Mantequilla", "Salsa de tomate");
        }

        public void verRegistro(){
            System.out.println(registro.toString());
        }

        public void verProductos(){
            System.out.println(productos.toString());
        }
        public void iterarProducto(String nombre){
           List<Producto> productos1  = productos.stream().filter(producto -> nombre.equals(producto.getNombre())).collect(Collectors.toList());

        }

    @Override
    public String toString() {
        return "TiendaDonJose{" +
                "registro=" + registro +
                '}';
    }
}

