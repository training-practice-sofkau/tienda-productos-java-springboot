package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    public List<CarritoCompra> carritoCompras;

    public Compra(List<CarritoCompra> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }
    public Compra() {
        this.carritoCompras = new ArrayList<>();
    }


    public void addProductoCarritoCompras(CarritoCompra carritoCompra){
        carritoCompras.add(carritoCompra);

    }
}
