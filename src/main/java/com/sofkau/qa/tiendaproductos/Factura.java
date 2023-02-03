package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private final List<Compra> compras = new ArrayList<>();

    public void add(Compra compra) {
        compras.add(compra);
    }

    public void mostrar(boolean selector) {
        final int[] total = {0};
        if (selector) {
            compras.forEach(compra -> {
                System.out.println("Compra n°" + (compras.indexOf(compra) + 1) + " " + compra.getCompra());
            });
        } else {
            compras.forEach(compra -> {
                System.out.println("Compra n°" + (compras.indexOf(compra) + 1) + " " + compra.getCompra());
            });
            compras.forEach(compra -> {
                total[0] += compra.total;
            });
            System.out.println("Total a pagar: $" + total[0]);
        }

    }
}