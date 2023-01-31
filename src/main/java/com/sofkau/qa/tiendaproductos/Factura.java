package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int nit;
    private static int nitSiguiente = 1;
    private Cliente cliente;
    private List<ProdCantidad> prodComprados;
    private double total;

    public Factura(Cliente cliente){
        nit = nitSiguiente;
        nitSiguiente ++;
        this.cliente=cliente;
        prodComprados = new ArrayList<>();
        this.total = 0;
    }

    public int getNumeroFactura() {
        return nit;
    }

    public void agregarProductosFactura(ProdCantidad producto) {
        prodComprados.add(producto);
    }

    public void totalFactura() {
       if (total == 0){
           for (ProdCantidad prodCantidad : prodComprados) {
               this.total += (prodCantidad.getPrecio() * prodCantidad.getCantidad());
           }
       }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura [nit=" + nit + "," + cliente +
                ", \nprodComprados=" + prodComprados.toString() + "]" + "\n Total = " + total;
    }

}
