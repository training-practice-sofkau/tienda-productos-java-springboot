package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class StockTienda {

    private List<Producto> stock= new ArrayList<>();

    public List<Producto> getProductos(){

        stock.add(new Producto(1,"Jean Hombre", 75000, 80 ));
        stock.add(new Producto(2, "Chaqueta", 90000, 100 ));
        stock.add(new Producto(3,"Pantalon corto", 45000, 80 ));
        stock.add(new Producto(4, "Jean Dama", 65000, 100 ));
        stock.add(new Producto(5,"Basica blanca", 19000, 80 ));
        stock.add(new Producto(6, "Medias tobilleras", 6000, 100 ));
        stock.add(new Producto(7,"Camisa Hombre", 95000, 80 ));
        stock.add(new Producto(8, "Blusa Dama", 50000, 100 ));
        stock.add(new Producto(9,"Leggin deportivo", 76000, 80 ));
        stock.add(new Producto(10, "Sudadera Hombre", 68000, 100 ));

        for (Producto p: stock) {
            System.out.println(" "+ p.getId()+ "  " + p.getNombre() + " Precio: " + p.getPrecio());
        }
        System.out.println("--------------------------- ");
        return stock;

    }


}
