package com.sofkau.qa.tiendaproductos.Servicios;

public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(Long id) {
        super("No se encontró un producto con id: " + id);
    }

}
