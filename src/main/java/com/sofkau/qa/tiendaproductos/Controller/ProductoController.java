package com.sofkau.qa.tiendaproductos.Controller;

import com.sofkau.qa.tiendaproductos.Model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/rest")
public class ProductoController {

    List<Producto> productos = new ArrayList<>();

    @GetMapping("/productos/all")

    public ResponseEntity getAllProductos(){
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }


    @PostMapping("/")
    public ResponseEntity createNewProducto(@RequestBody Producto producto){
        Producto newProducto = new Producto(UUID.randomUUID().toString(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio());
        this.productos.add(newProducto);
        return new ResponseEntity(newProducto,HttpStatus.CREATED);
    }




    @PutMapping("/{productoId}")
    public ResponseEntity updateProducto(@PathVariable("productoId") String id, @RequestBody Producto producto) {
        List<Producto> newList = productos.stream()
                .map(n -> n.getId().equals(id)?producto:n).collect(Collectors.toList());
        this.productos = newList;
        return new ResponseEntity(producto, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{productoId}")
    public ResponseEntity deleteNote(@PathVariable("productoId") String id){
        List<Producto> newProductos = productos.stream().
                filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.productos = newProductos;
        return new ResponseEntity(productos, HttpStatus.OK);
    }
}
