package com.sofkau.qa.tiendaproductos.Services;

import com.sofkau.qa.tiendaproductos.Model.Orden;
import com.sofkau.qa.tiendaproductos.Model.Producto;

import java.util.List;

public interface ICompraService {

    void registrarCompra(List<Producto> productosVendidos);

    List<Orden> obtenerOrdenes();
}
