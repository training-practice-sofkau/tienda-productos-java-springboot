package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final int idOrden;
    private List<ShopPc> productos = new ArrayList<>();
    private static int contadorOrdenes;


    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
    }
    public void agregarProducto(ShopPc producto){
        productos.add(producto);

    }
    public void mostrarOrden(){
        System.out.println("Orden #: " + this.idOrden);
        System.out.println("Productos de la orden #: " + this.idOrden);

        productos.forEach(informacion -> {
            System.out.println("Productossssssss " + informacion +"\n");
        });
    }
}
