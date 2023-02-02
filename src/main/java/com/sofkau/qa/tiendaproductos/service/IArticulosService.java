package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.domain.Producto;

import java.util.List;

public interface IArticulosService {

    List<Producto> articulosDisponibles();

    Producto agregarArticulo(Producto producto);
}
