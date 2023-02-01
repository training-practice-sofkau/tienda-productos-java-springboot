package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FacturaService {

    private List<Factura> facturas;

    public FacturaService() {
        facturas = new ArrayList<>();
    }


    public void generarFactura(Factura factura) {
        facturas.add(factura);
        System.out.println(facturas);
    }


    public List<Factura> getFacturas() {
        return(facturas);
    }
}
