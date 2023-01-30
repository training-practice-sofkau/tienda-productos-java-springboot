package com.sofkau.qa.tiendaproductos.negocio;

import com.sofkau.qa.tiendaproductos.Producto;
import com.sofkau.qa.tiendaproductos.datos.Tienda;
import org.springframework.stereotype.Service;


@Service
public class TiendaProductosImp implements ITiendaProductos{

    /**
     * Se agrega el atributo Tienda para acceder a los métodos definidos en el paquete datos
     */
    public Tienda tienda;
    @Override
    public void agregarProducto(Producto producto) {
        tienda.agregar(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        tienda.eliminar(producto);
    }

    @Override
    public void ListarProductos() {
        tienda.listar();
    }
}
