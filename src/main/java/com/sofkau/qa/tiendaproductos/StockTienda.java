package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class StockTienda {

    public void mostrarStock(){

        List<Producto> stock = new ArrayList<Producto>();

        stock.add(new Producto(1,"Tomate", 1990, 80 ));
        stock.add(new Producto(2, "Papa", 1490, 100 ));
        stock.add(new Producto(3,"Platano", 1990, 80 ));
        stock.add(new Producto(4, "Banano", 1290, 100 ));
        stock.add(new Producto(5,"Zanahoria", 690, 80 ));
        stock.add(new Producto(6, "Papa", 1490, 100 ));
        stock.add(new Producto(7,"Cebolla cabezona", 1790, 80 ));
        stock.add(new Producto(8, "Limon Tahiti", 990, 100 ));
        stock.add(new Producto(9,"Platano maduro", 1990, 80 ));
        stock.add(new Producto(10, "Cebolla larga", 2290, 100 ));

        for (Producto p: stock) {
            System.out.println(" "+ p.getId()+ "  " + p.getNombre());

        }

        System.out.println("--------------------------- ");

    }

}
