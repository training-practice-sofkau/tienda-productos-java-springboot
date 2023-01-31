package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;

import java.util.List;

public interface StockMethods {
    public void agregar(Producto producto);
    public void eliminar(Producto producto);
    public void listar();
    public List<Producto> getListaStock();
}
