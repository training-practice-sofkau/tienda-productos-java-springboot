package com.sofkau.qa.tiendaproductos;

public class Factura {
    String nombreCliente;

    public Factura() {

    }

    public void generarFactura(){
        System.out.println("Nombre del cliente");
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
