package com.sofkau.qa.tiendaproductos;
import java.util.List;

public class Compra {

    private String nombreCliente;
    private List<CompraDetalle> detalles;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<CompraDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<CompraDetalle> detalles) {
        this.detalles = detalles;
    }
}