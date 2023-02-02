package com.sofkau.qa.tiendaproductos.controller;


import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import com.sofkau.qa.tiendaproductos.service.IComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/compras")
public class ComprasController {

    @Autowired

    private IComprasService service;


    @GetMapping()
    public ResponseEntity obtenerFacturas(){
        return new ResponseEntity(service.obtenerFacturas(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity registrarCompra(@RequestBody List<Producto> productos){
        service.registrarCompra(productos);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
