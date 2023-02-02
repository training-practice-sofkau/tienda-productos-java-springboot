package com.sofkau.qa.tiendaproductos.controller;


import com.sofkau.qa.tiendaproductos.repository.domain.Producto;
import com.sofkau.qa.tiendaproductos.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rest")
public class ProductoController {

    @Autowired
    private IProductosService productosService;

    @GetMapping("/bring/all")
    public ResponseEntity GETtraerProductos(){
        return new ResponseEntity(productosService.mostrarArticulosDisponibles(), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity listaProductos(@RequestBody Producto producto){
        return new ResponseEntity(productosService.agregarArticulo(producto),HttpStatus.CREATED);
    }
}
