package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Factura {
    @Autowired
    public Tienda tienda;
    @Autowired
    public ProductosStock productosStock;
    public List<Producto> getProductosComprados(){
        return tienda.getLista();
    }

    /**
     *
     * TODO: revisar lógica para setear precio producto comprado en el primer POST Request de sesion
     */

    public int setPrecioProducto(){
        for (Producto productoComprado : this.getProductosComprados()){
            for (Producto productoStock : productosStock.getStock()){
                if (productoComprado.getNombre().equalsIgnoreCase(productoStock.getNombre())){
                    return productoStock.getPrecio();
                }
            }
        }
        return 3;
    }
}
