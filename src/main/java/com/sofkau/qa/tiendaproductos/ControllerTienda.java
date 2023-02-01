package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
public class ControllerTienda {

    List<Producto> products = new ArrayList<>();
    List<CarritoCompras> carritos = new ArrayList<>();


    @Autowired
    public TiendaDeJuegos tienda;

//    @GetMapping("/")
//    public ResponseEntity getAllNotes(){
//        return new ResponseEntity(), HttpStatus.FOUND);
//    }

    //GET para traer todos los productos
    @GetMapping("/inventario")
    public ResponseEntity getProducts(){
        return new ResponseEntity(tienda.getProducts(), HttpStatus.FOUND);
    }

    //POST para agregar al carrito
    @PostMapping()
    public ResponseEntity addToCart(@RequestBody CarritoCompras carrito){
        CarritoCompras newItem = new CarritoCompras(carrito.getName(),
                carrito.getCant());
        carritos.add(newItem);
        return new ResponseEntity(newItem, HttpStatus.CREATED);
    }
    //POST Agregar un nuevo producto
    @PostMapping("/NuevoProducto")
    public ResponseEntity addToInventory(@RequestBody Producto producto){
        Producto newProduct = new Producto(producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock());
        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    //PUT para actualizar un producto existente
    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable("productId") int id,
                                     @RequestBody Producto product){
        List<Producto> newList = tienda.getProducts().stream()
                .map(p -> p.getId() == id?product:p).collect(Collectors.toList());
        this.products = newList;
        return new ResponseEntity(product, HttpStatus.ACCEPTED);
    }
//
//    @DeleteMapping("/{noteId}")
//    public ResponseEntity deleteNote(@PathVariable("noteId") String id){
//        List<Note> newNotes = notes.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
//        this.notes = newNotes;
//        return new ResponseEntity(notes, HttpStatus.GONE);
//    }
}