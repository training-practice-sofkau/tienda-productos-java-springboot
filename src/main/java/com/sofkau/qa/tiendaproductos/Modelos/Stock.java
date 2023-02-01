package com.sofkau.qa.tiendaproductos.Modelos;

import com.sofkau.qa.tiendaproductos.Modelos.ProdCantidad;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<ProdCantidad> misProductos;
    private ProdCantidad producto;

    public Stock() {
        misProductos = new ArrayList<>();
    }

    public void agregarProducto(String id, String nombre, double precio, int cantidad) {
        misProductos.add(new ProdCantidad(id,nombre,precio,cantidad));
    }

    public void listarProductos() {
        for (ProdCantidad stock : misProductos) {
            System.out.println(stock.toString());
        }
    }

    public List<ProdCantidad> getMisProductos() {
        return misProductos;
    }

    public ProdCantidad obtenerProducto(String id) {
        for (ProdCantidad prodCantidad : misProductos) {
            if(prodCantidad.getId().equalsIgnoreCase(id)) {
                producto = prodCantidad;
            }
        }
        return producto;
    }

    public void disminuirStockProducto(String id, int cantidad) {
        for (ProdCantidad prodCantidad : misProductos) {
            if(prodCantidad.getId().equalsIgnoreCase(id)) {
                prodCantidad.disminuirCantidad(cantidad);
            }
        }
    }
}
