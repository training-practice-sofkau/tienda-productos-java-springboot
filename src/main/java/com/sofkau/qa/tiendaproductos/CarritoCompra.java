package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;

public class CarritoCompra {
    private String cliente;
    private ArrayList<Compra> compras;


    public CarritoCompra(String cliente, ArrayList<Compra> compras) {
        this.cliente = cliente;
        this.compras = compras;
    }
}
