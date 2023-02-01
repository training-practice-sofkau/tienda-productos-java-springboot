package com.sofkau.qa.tiendaproductos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/rest")
public class Controller {

    //List<Cafeteria> cafeterias = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();

    @GetMapping
    public ResponseEntity getAllProductos(){
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity createNewProduct(@RequestBody Producto producto){
        Producto newProducto = new Producto(
                producto.getNombreProducto(),
                producto.getValor(),
                producto.getStock());
        this.productos.add(newProducto);
        return new ResponseEntity(newProducto, HttpStatus.CREATED);
    }

}
