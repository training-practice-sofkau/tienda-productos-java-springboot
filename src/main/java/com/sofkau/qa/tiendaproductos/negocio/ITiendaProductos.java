package com.sofkau.qa.tiendaproductos.negocio;

import com.sofkau.qa.tiendaproductos.Producto;

public interface ITiendaProductos {
    public void agregarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    public void ListarProductos();
}
