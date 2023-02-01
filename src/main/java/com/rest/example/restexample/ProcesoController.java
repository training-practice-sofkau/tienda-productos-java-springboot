package com.rest.example.restexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rest")
public class ProcesoController {

    List<Producto> productos = new ArrayList<>();
    Map<Producto, Integer> facturaProductos = new HashMap<>();


    @GetMapping("/bring/all/products")
    public ResponseEntity getProductos(){
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }
    @GetMapping("/bring/all/factors")
    public ResponseEntity getFacturas(){
        return new ResponseEntity(facturaProductos, HttpStatus.FOUND);
    }
    @PostMapping()
    public ResponseEntity createProductos(@RequestBody Producto producto){
        Producto newProducto = new Producto(UUID.randomUUID().toString(),
                producto.getNombre(),
                producto.getPrecioUnit());
        this.productos.add(newProducto);
        return new ResponseEntity(newProducto, HttpStatus.CREATED);
    }
    @PostMapping()
    public ResponseEntity createListCompras(@RequestBody Factura factura){
        getFacturas();
        return new ResponseEntity(facturaProductos, HttpStatus.CREATED);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity updateProductos(@PathVariable("productoId") String id,
                                     @RequestBody Producto producto){
        List<Producto> newList = productos.stream()
                .map(n -> n.getId().equals(id)? producto :n).collect(Collectors.toList());

        this.productos = newList;
        return new ResponseEntity(producto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity deleteProducto(@PathVariable("productoId") String id){
        List<Producto> newProductos = productos.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.productos = newProductos;
        return new ResponseEntity(productos, HttpStatus.GONE);
    }
}
