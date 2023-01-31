package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    int idProducto;
    String nombreCliente;
    int valorTolal;
    Date fecha;
    List<Integer> idFactProducto;

    public Factura() {
        idFactProducto = new ArrayList<>();
    }

    public Factura(String nombreCliente, int valorTolal) {
        this();
        fecha = new Date();
        this.nombreCliente = nombreCliente;
        this.valorTolal = valorTolal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getValorTolal() {
        return valorTolal;
    }

    public void setValorTolal(int valorTolal) {
        this.valorTolal = valorTolal;
    }
    public void generarFactura(){
        System.out.println("FACTURA:");
        System.out.println("Nombre cliente: " + nombreCliente);
        System.out.println("Id del producto: " + idProducto);
        System.out.println("TOTAL: " + valorTolal);
        System.out.println("FECHA: " + fecha);
    }
}
