package com.sofkau.qa.tiendaproductos.repository;


import com.sofkau.qa.tiendaproductos.repository.models.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacturaRepository {

    private List<Factura> facturas;

    public FacturaRepository(){
        this.facturas = new ArrayList<>();
    }

    public List<Factura> obtenerFacturas(){
        return this.facturas;
    }

    public void registrarVenta(Factura factura){
        facturas.add(factura);
    }
}
