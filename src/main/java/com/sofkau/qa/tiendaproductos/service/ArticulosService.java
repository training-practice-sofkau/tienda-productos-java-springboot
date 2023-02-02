package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.TiendaPc;
import com.sofkau.qa.tiendaproductos.repository.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticulosService implements IArticulosService{

    @Autowired
    private TiendaPc tiendaPc;
    @Override
    public List<Producto> articulosDisponibles() {
        return tiendaPc.get;
    }

    @Override
    public Producto agregarArticulo(Producto producto) {
        return null;
    }
}
