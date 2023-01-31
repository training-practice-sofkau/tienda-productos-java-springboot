package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    int idProducto;
    String nombreCliente;
    int valorTotal;
    Date fecha;
    List<Integer> idFactProducto;

    public Factura() {
        idFactProducto = new ArrayList<>();
    }

    public Factura(String nombreCliente, int valorTotal) {
        this();
        fecha = new Date();
        this.nombreCliente = nombreCliente;
        this.valorTotal = valorTotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void generarFactura(){
        System.out.println("FACTURA:");
        System.out.println("Nombre cliente: " + getNombreCliente());
        System.out.println("Id del producto: " + getIdProducto());
        System.out.println("TOTAL: " + getValorTotal());
        System.out.println("FECHA: " + fecha);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idProducto=" + getIdProducto() +
                ", nombreCliente='" + getNombreCliente() + '\'' +
                ", valorTotal=" + getValorTotal() +
                ", fecha=" + fecha;
    }
}
