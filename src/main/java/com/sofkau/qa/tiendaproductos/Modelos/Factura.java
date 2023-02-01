package com.sofkau.qa.tiendaproductos.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String nit;
    //private static int nitSiguiente = 1;
    private Cliente cliente;
    private List<ProdCantidad> prodComprados;
    private double total;
    public Factura(){

    }

    public Factura(Cliente cliente){

        this.cliente=cliente;
        prodComprados = new ArrayList<>();
        this.total = 0;
    }

    public String getNumeroFactura() {
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

    public List<ProdCantidad> getProdComprados() {
        return prodComprados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNit(String nit){
        this.nit=nit;
    }

    @Override
    public String toString() {
        return "Factura [nit=" + nit + "," + cliente +
                ", \nprodComprados=" + prodComprados.toString() + "]" + "\n Total = " + total;
    }

}
