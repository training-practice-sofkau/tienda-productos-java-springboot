package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.TiendaLS;
import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductosService implements IProductosService{

    @Autowired
    private TiendaLS tiendaLS;
    @Override
    public List<Producto> obtenerProductosDisponibles() {
        return tiendaLS.getProductos();
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        Producto productoInventario = new Producto(UUID.randomUUID().toString(),
                producto.getNombre(),
                producto.getCantidadProducto(),
                producto.getPrecio());
        tiendaLS.agregarProducto(productoInventario);
        return productoInventario;
    }
}
