package com.sofkau.qa.tiendaproductos.controllers;

import com.sofkau.qa.tiendaproductos.Factura;
import com.sofkau.qa.tiendaproductos.Producto;
import com.sofkau.qa.tiendaproductos.services.FacturaService;
import com.sofkau.qa.tiendaproductos.services.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tienda")


        public class ProductoControllers {


        @GetMapping("/productos")

        public ResponseEntity traerProducts(){
            return new ResponseEntity(ProductoService.productos, HttpStatus.FOUND);
        }

        @PostMapping

        public ResponseEntity comprarproductos(@RequestBody Producto producto){

            Factura factura = FacturaService.generateFactura(ProductoService.productosVendidos(producto.getId(), producto.getQuantity()), producto.getName());

            return new ResponseEntity(factura,HttpStatus.OK);
        }

        @PutMapping("{id}")
        public ResponseEntity actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
            ProductoControllers ProductoService = new ProductoControllers();
            ResponseEntity actualizado = ProductoService.actualizarProducto(id, producto);
            if (actualizado != null) {
                return new ResponseEntity(actualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
        }

