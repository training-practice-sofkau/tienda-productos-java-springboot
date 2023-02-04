package com.sofkau.qa.tiendaproductos.services;

import com.sofkau.qa.tiendaproductos.Factura;
import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {

    private List<Factura> facturas = new ArrayList<>();

    public static Factura generateFactura(List<Producto> productos, String customerName) {
        Factura factura = new Factura(productos, customerName);
        Factura.add(factura);
        return factura;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}