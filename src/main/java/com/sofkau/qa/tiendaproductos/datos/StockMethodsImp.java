package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockMethodsImp implements StockMethods{
    List<Producto> productosStock = new ArrayList<>();
    @Override
    public void agregar(Producto producto) {
        productosStock.add(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productosStock.remove(producto);
    }

    @Override
    public void listar() {
        System.out.println("La lista de productos en el carrito de compras es: ");
        productosStock.stream().forEach(producto -> {
            System.out.println(producto.getNombre());
        });
    }

    @Override
    public List<Producto> getListaStock() {
        return this.productosStock;
    }


}
