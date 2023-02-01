package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tienda")
public class StockTiendaController {

    List<Producto> productoRequest = new ArrayList<>();
    @Autowired
    private StockTienda stockTienda;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> productos = stockTienda.getProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createNewProduct(@RequestBody Producto producto){
        Producto newProducto = new Producto(producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad());
        this.productoRequest.add(newProducto);
        return new ResponseEntity(newProducto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable("productId") Integer id){
        List<Producto> newProducts = productoRequest.stream().filter(n -> !Objects.equals(n.getId(), id)).collect(Collectors.toList());
        this.productoRequest = newProducts;
        return new ResponseEntity(productoRequest, HttpStatus.GONE);
    }
}
