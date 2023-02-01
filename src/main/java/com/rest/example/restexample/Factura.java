package com.rest.example.restexample;

import java.util.*;

public class Factura {
    int idProducto;
    String nombreCliente;
    int valorTotal;
    Date fecha;
    List<Factura> listaCompras;

    public Factura(String nombreCliente) {
        fecha = new Date();
        this.nombreCliente = nombreCliente;
        this.valorTotal = valorTotal;
        listaCompras = new ArrayList<>();
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

    public Date getFecha() {
        return fecha;
    }


    @Override
    public String toString() {
        return "-----Factura----- " +
                "Id Producto: " + idProducto + '\'' +
                ", Nombre del cliente: " + nombreCliente + '\'' +
                ", Valor Total: " + valorTotal + '\'' +
                ", Fecha de compra" + fecha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombreCliente, valorTotal, fecha);
    }
}