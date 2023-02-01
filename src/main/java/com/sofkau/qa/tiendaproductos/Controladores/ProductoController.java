package com.sofkau.qa.tiendaproductos.Controladores;

import com.sofkau.qa.tiendaproductos.Modelos.Producto;
import com.sofkau.qa.tiendaproductos.Servicios.ProductoNoEncontradoException;
import com.sofkau.qa.tiendaproductos.Servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) throws ProductoNoEncontradoException {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) throws ProductoNoEncontradoException {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void borrarProducto(@PathVariable Long id) throws ProductoNoEncontradoException {
        productoService.borrarProducto(id);
    }

}
