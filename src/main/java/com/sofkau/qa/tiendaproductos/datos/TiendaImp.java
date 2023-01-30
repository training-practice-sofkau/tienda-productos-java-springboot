package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Se utiliza la anotación Repository en la clase TiendaImp porque se están implementando métodos CRUD
 */
@Repository
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
    public void listar() {
        System.out.println("La lista de productos en el carrito de compras es: ");
        productos.stream().forEach(producto -> {
            System.out.println(producto);
        });
    }
}
