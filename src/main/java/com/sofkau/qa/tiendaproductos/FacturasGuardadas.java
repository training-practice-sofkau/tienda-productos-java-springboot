package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class FacturasGuardadas {
    // Una lista estática para almacenar las facturas
    private static List<Factura> facturas = new ArrayList<>();

    // Método estático para agregar una nueva factura a la lista de facturas
    public static void addFactura(Factura factura) {
        facturas.add(factura);
    }

    // Método para obtener la lista completa de facturas
    public static List<Factura> getFacturas() {
        return facturas;
    }
}
