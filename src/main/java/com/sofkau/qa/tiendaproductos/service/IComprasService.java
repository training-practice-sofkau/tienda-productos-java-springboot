package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.domain.Factura;
import com.sofkau.qa.tiendaproductos.repository.domain.Producto;

import java.util.List;

public interface IComprasService {

    void registrarCompra(List<Producto> productosVendidos);

    List<Factura> mostrarFacturas();
}
