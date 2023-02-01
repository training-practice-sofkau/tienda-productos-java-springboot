package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferreteria")
public class FerreteriaControlador {

    public Ferreteria ferreteria;

    public FerreteriaControlador(Ferreteria ferreteria) {
        this.ferreteria = ferreteria;
    }

    @GetMapping("/mostrarproductos")
    public ResponseEntity productosDisponibles() {
        List<Producto> productos = this.ferreteria.getProductoStock();
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }

    @PostMapping("/agregarproductos")
    public ResponseEntity agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = new Producto(producto.getNombre(),producto.getPrecio(),producto.getStock());
        this.ferreteria.agregarProductos(nuevoProducto);
        return new ResponseEntity(nuevoProducto, HttpStatus.CREATED);
    }


}
