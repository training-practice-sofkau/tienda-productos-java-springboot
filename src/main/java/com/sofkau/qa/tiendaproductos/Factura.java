package com.sofkau.qa.tiendaproductos;

import java.time.LocalDate;
import java.util.LinkedList;

public class Factura {

    private int id;
    private LocalDate fecha;
    private LinkedList<ProductoCompra> productoCompras;

    public Factura(int id, LocalDate fecha, LinkedList<ProductoCompra> productoCompras) {
        this.id = id;
        this.fecha = fecha;
        this.productoCompras = productoCompras;
    }

    public void generarFactura(){
        System.out.println("Fecha: "+fecha);
        for(ProductoCompra productoCompra:productoCompras){
            System.out.println(productoCompra.toString());
        }
    }
}
