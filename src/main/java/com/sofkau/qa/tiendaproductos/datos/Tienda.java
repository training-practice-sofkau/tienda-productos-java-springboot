package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;

public interface Tienda {
    public void agregar(Producto producto);
    public void eliminar(Producto producto);
    public void listar();
}
