package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/v1/rest")
public class TiendaController {

      @Autowired
    TiendaDonJose tiendaDonJose;
      @Autowired
    Cliente cliente;

    List<Producto> productos = Arrays.asList(new Producto("1","sal",100,3000),
            new Producto("2","azucar",100,2500),
            new Producto("3","cereal",100,5000),
            new Producto("4","aceite",100,7000),
            new Producto("5","cerveza",100,2800),
            new Producto("6","ron",100,60000),
            new Producto("7","aguariente",100,50000),
            new Producto("8","doritos",100,4000),
            new Producto("9","mantequilla",100,3000),
            new Producto("10","salsa de tomate",100,4500));

    List<Producto> productos1 = new ArrayList<Producto>();
    List<Cliente> registro = new ArrayList<Cliente>();

    List<Producto> productosCarrito = new ArrayList<Producto>();

    @GetMapping("/bring/all")
    public ResponseEntity GETtraerProductos(){
        System.out.println(tiendaDonJose.getProductos());

        return new ResponseEntity(tiendaDonJose.getProductos() ,HttpStatus.FOUND);
    }

    @GetMapping("/bring/all2")
    public ResponseEntity GETtraerRecibos(){
        return new ResponseEntity(registro, HttpStatus.FOUND);
    }

    @GetMapping("/bring/all3")
    public ResponseEntity GETtraerCarrito(){
        return new ResponseEntity(productosCarrito, HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity listaProductos(@RequestBody Producto producto){
        Producto productoInventario = new Producto(UUID.randomUUID().toString(),
                producto.getNombre(),
                producto.getCantidadProducto(),
                producto.getPrecio());
        tiendaDonJose.agregarProducto(productoInventario);
        return new ResponseEntity(productoInventario, HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity listaCompra(@RequestBody Producto producto){
        Producto productoCarrito = new Producto(UUID.randomUUID().toString(),
                producto.getNombre(),
                producto.getCantidadProducto(),
                producto.getPrecio());
        productosCarrito.add(productoCarrito);
        return new ResponseEntity(productoCarrito, HttpStatus.CREATED);
    }



}
