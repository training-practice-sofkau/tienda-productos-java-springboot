package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tienda")
public class StockTiendaController {
    @Autowired
    private StockTienda stockTienda;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> productos = stockTienda.getProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
