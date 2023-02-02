package com.sofkau.qa.tiendaproductos.controller;

import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import com.sofkau.qa.tiendaproductos.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rest")
public class ProductoController {

    @Autowired
    private IProductosService productoService;

    @GetMapping("/bring/all")
    public ResponseEntity GETtraerProductos(){

        return new ResponseEntity(productoService.obtenerProductosDisponibles() ,HttpStatus.FOUND);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity listaProductos(@RequestBody Producto producto) {
        return new ResponseEntity(productoService.agregarProducto(producto), HttpStatus.CREATED);
    }

}
