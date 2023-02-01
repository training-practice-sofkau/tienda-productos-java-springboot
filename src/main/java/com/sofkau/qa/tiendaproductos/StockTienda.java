package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StockTienda {

    public static ArrayList<Producto> stock = new ArrayList<>(List.of(new Producto(1,"Jean Hombre", 75000, 80 ),
        new Producto(2, "Chaqueta", 90000, 100 ),
        new Producto(3,"Pantalon corto", 45000, 80 ),
        new Producto(4, "Jean Dama", 65000, 100 ),
        new Producto(5,"Basica blanca", 19000, 80 ),
        new Producto(6, "Medias tobilleras", 6000, 100 ),
        new Producto(7,"Camisa Hombre", 95000, 80 ),
        new Producto(8, "Blusa Dama", 50000, 100 ),
        new Producto(9,"Leggin deportivo", 76000, 80 ),
        new Producto(10, "Sudadera Hombre", 68000, 100 )));


    public List<Producto> getProductos(){

        return stock ;

    }

    public void mostrar(List<Producto> product){

        for (Producto p: product) {
            System.out.println(" "+ p.getId()+ "  " + p.getNombre() + " Precio: " + p.getPrecio());
        }
        System.out.println("--------------------------- ");

    }

    public void agregarPrenda(int id, String nombre, double precio, int cantidad) {

        stock.add(new Producto(id, nombre, precio, cantidad));
    }
}
