package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.domain.Producto;

import java.util.List;

public interface IProductosService {

    List<Producto> mostrarArticulosDisponibles();

    Producto agregarArticulo(Producto producto);
}
