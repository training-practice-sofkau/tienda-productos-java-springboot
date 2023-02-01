package com.rest.example.restexample;

import java.util.ArrayList;
import java.util.List;

public class FacturasGuardadas {
    private static List<Factura> facturas = new ArrayList<>();
    public static void addFactura(Factura factura) {
        facturas.add(factura);
    }
    public static List<Factura> getFacturas() {
        return facturas;
    }
}
