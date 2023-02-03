package com.sofkau.qa.tiendaproductos;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("tiendita/Melisita")

public class ProductoController {
    @GetMapping("/productos")

    public ResponseEntity traerProducticos(){
        return new ResponseEntity(ProductoService.producticos, HttpStatus.FOUND);
    }

    @PostMapping

    public ResponseEntity comprarProducticos(@RequestBody Producto producto){

        Factura factura = FacturaService.generateFactura(ProductoService.productosVendidos(producto.getId(), producto.getQuantity()), producto.getName());

        return new ResponseEntity(factura,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actualizado = ProductoService.actualizarProducto(id, producto);
        if (actualizado != null) {
            return new ResponseEntity(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }





}


