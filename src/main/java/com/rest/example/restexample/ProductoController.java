package com.rest.example.restexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rest.example.restexample.ProductoGuardado.productos;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private static ProductoGuardado ProductoGuardado;
    @GetMapping("getproducto")
    public List<Producto> getAllProductos() {
        return ProductoGuardado.getAllProductos();
    }

    @PutMapping("{nombre}")
    public ResponseEntity<Producto> updateProducto(@PathVariable("nombre") String nombre, @RequestBody Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equals(nombre)) {
                productos.set(i, productoActualizado);
                return ResponseEntity.ok(productoActualizado);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
