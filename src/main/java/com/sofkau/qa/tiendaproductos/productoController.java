package com.sofkau.qa.tiendaproductos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class productoController {

    List<Producto> productos = new ArrayList<>();


    /**
     * Producto por Id
     *
     * @return
     */
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") String id) {
        Optional<Producto> producto = productos.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Todos los productos
     *
     * @return
     */
    @GetMapping("/listproduct")
    public ResponseEntity<List<Producto>> findAll() {

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    /**
     * Guardar todos los productos
     *
     * @param producto
     * @return
     */
    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto newProducto = new Producto(UUID.randomUUID().toString(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad());
        this.productos.add(newProducto);
        return new ResponseEntity(newProducto, HttpStatus.CREATED);
    }

    /**
     * Actualizar todos los productos
     *
     * @param id
     * @param producto
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody Producto producto) {
        List<Producto> newList = productos.stream().map(n -> n.getId().equals(id) ? producto : n).collect(Collectors.toList());

        this.productos = newList;
        return new ResponseEntity(producto, HttpStatus.ACCEPTED);
    }


    /**
     * Eliminar un producto por id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        List<Producto> newProducto = productos.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.productos = newProducto;
        return new ResponseEntity(productos, HttpStatus.GONE);
    }


}