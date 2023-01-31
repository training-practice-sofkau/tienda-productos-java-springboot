package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopPc {

    public void  ejecutarDiademas(){
        Producto articulo = new Producto();
        List<Diadema> productos = new ArrayList<>();
        productos.add(new Diadema("Inalambrico"));
        productos.add(new Diadema("Diadema Gamer"));
        //articulo.agregarDiadema(pru);
        productos.forEach(informacion -> {
            System.out.println( informacion +"\n");
        });

    }

    public void  ejecutarDiscoduro(){
        List<DiscoDuro> productos = new ArrayList<>();
        productos.add(new DiscoDuro("250 Gb"));
        productos.add(new DiscoDuro("500 Gb"));
        productos.forEach(informacion -> {
            System.out.println( informacion +"\n");
        });
    }

    public void  ejecutarMonitor(){
        List<Monitor> productos = new ArrayList<>();
        productos.add(new Monitor("LCD"));
        productos.add(new Monitor("OLED"));
        productos.forEach(informacion -> {
            System.out.println( informacion +"\n");
        });
    }

    public void  ejecutarRaton(){
        List<Raton> productos = new ArrayList<>();
        productos.add(new Raton("Óptico"));
        productos.add(new Raton("Clasico"));
        productos.forEach(informacion -> {
            System.out.println( informacion +"\n");
        });
    }

    public void  ejecutarTeclado(){
        List<Teclado> productos = new ArrayList<>();
        productos.add(new Teclado("Proyeccion"));
        productos.add(new Teclado("Ergonómico"));
        productos.forEach(informacion -> {
            System.out.println( informacion +"\n");
        });
    }

    public  void tienda(){
        ejecutarDiademas();
        ejecutarDiscoduro();
        ejecutarMonitor();
        ejecutarRaton();
        ejecutarTeclado();
    }

}
