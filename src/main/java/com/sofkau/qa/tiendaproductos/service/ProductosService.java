package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.TiendaPc;
import com.sofkau.qa.tiendaproductos.repository.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductosService implements IProductosService {

    @Autowired
    private TiendaPc tiendaPc;
    @Override
    public List<Producto> mostrarArticulosDisponibles() {
        return tiendaPc.getProductos();
    }

    @Override
    public Producto agregarArticulo(Producto producto) {

        Producto productoAlmacen = new Producto(UUID.randomUUID().toString(),producto.getNombre(),producto.getPrecio(),
                producto.getCantidadProducto());
                tiendaPc.agregarProducto(productoAlmacen);
        return null;
    }
}
