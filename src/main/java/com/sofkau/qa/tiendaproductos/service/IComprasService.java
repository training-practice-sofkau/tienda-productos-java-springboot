package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.models.Factura;
import com.sofkau.qa.tiendaproductos.repository.models.Producto;

import java.util.List;

public interface IComprasService {

    void registrarCompra(List<Producto> productosVendidos);

    List<Factura> obtenerFacturas();
}
