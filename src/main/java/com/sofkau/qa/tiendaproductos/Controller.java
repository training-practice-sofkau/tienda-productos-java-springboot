package com.sofkau.qa.tiendaproductos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rest")
public class Controller {

    public Cafeteria cafeteria;

    public Controller() {
        super();
        this.cafeteria = new Cafeteria();
        this.llenar();
    }

    @GetMapping("/producto/listar")
    public ResponseEntity productosDisponibles() {
        List<Producto> productos = this.cafeteria.getProductoEnStock();
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }

    private void llenar() {
        Producto cafe = new Producto("Café americano", 2000, 0);
        Producto mocha = new Producto("Café mocha", 5000, 15);
        Producto espresso = new Producto("Café espresso", 3500, 20);
        Producto cappuccino = new Producto("Cappuccino", 5000, 21);
        Producto latte = new Producto("Café latte", 40000, 15);
        Producto coldbrew = new Producto("Cold Brew", 8000, 25);

        cafeteria.agregarProductos(cafe);
        cafeteria.agregarProductos(mocha);
        cafeteria.agregarProductos(espresso);
        cafeteria.agregarProductos(cappuccino);
        cafeteria.agregarProductos(latte);
        cafeteria.agregarProductos(coldbrew);
    }

    @PostMapping("/producto/crear")
    public ResponseEntity crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = new Producto(
                producto.getNombreProducto(),
                producto.getValor(),
                producto.getStock());
        this.cafeteria.agregarProductos(nuevoProducto);
        return new ResponseEntity(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/producto/actualizar/{ID}")
    public ResponseEntity actualizarProducto(@PathVariable("ID") int ID,
                                             @RequestBody Producto producto) {
        List<Producto> productos = this.cafeteria.getProductoList();
        producto.setID(ID);
        productos = productos.stream()
                .map(prod -> prod.getID() == ID ? producto : prod).collect(Collectors.toList());
        this.cafeteria.setProductoList(productos);
        this.cafeteria.mostrarProductos();
        return new ResponseEntity(producto, HttpStatus.ACCEPTED);
    }
}
