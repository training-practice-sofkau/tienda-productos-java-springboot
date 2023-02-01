package com.sofkau.qa.tiendaproductos.ControladorPrueba;

import com.sofkau.qa.tiendaproductos.ProductoCompra;
import com.sofkau.qa.tiendaproductos.ProductoInventario;
import com.sofkau.qa.tiendaproductos.TiendaProductosApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@RequestMapping("api/carrito")
public class ControladorCarrito {

    @PostMapping("/crearCarrito")
    public LinkedList<ProductoCompra> ProductosCarrito(@RequestBody LinkedList<ProductoCompra> productosCompra){
        productosCompra.stream().forEach(n -> {
            TiendaProductosApplication.carritoPostman.add(n);
        });
        return productosCompra;
    }
}
