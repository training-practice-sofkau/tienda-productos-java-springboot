package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.models.Producto;

import java.util.List;

public interface IProductosService {

    List<Producto> obtenerProductosDisponibles();
    Producto agregarProducto(Producto producto);
}
