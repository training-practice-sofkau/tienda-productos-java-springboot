package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TiendaImp implements Tienda{

    List<Producto> productos = new ArrayList<>();
    @Override
    public void agregar(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productos.remove(producto);
    }

    @Override
    public List<Producto> getLista() {
        return this.productos;
    }
}
