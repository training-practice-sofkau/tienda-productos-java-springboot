package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ferreteria")
public class FerreteriaControlador {
    @Autowired
    public Ferreteria ferreteria;

    public FerreteriaControlador(Ferreteria ferreteria) {
        this.ferreteria = ferreteria;
    }

    @GetMapping("/mostrarproductos")
    public ResponseEntity productosDisponibles() {
        List<Producto> productos = this.ferreteria.getProductoStock();
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }

    @PostMapping("/agregarproductos")
    public ResponseEntity agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = new Producto(producto.getNombre(),producto.getPrecio(),producto.getStock());
        this.ferreteria.agregarProductos(nuevoProducto);
        return new ResponseEntity(nuevoProducto, HttpStatus.CREATED);
    }

   @PutMapping("/actualizarproducto/{ID}")
    public ResponseEntity actualizarProducto(@PathVariable("ID") int ID, @RequestBody Producto producto) {
        List<Producto> productos = this.ferreteria.getProductoStock();
        producto.setID(ID);
        productos = productos.stream().map(producto1 -> producto1.getID() == ID ? producto : producto1).collect(Collectors.toList());
        this.ferreteria.setProductoList(productos);
        this.ferreteria.productosDisponibles();
        return new ResponseEntity(productos, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminarproductos/{ID}")
    public ResponseEntity eliminarProducto (@PathVariable("ID") int ID) {
        List<Producto> productos = ferreteria.getProductoList().stream()
                .filter(producto -> producto.getID() != ID).collect(Collectors.toList());
        this.ferreteria.setProductoList(productos);
        this.ferreteria.getProductoStock();
        return new ResponseEntity(productos, HttpStatus.GONE);
    }

    @GetMapping("/listafactura")
    public ResponseEntity listarFactura (){
        List<Factura> facturas = this.ferreteria.getFacturas();
        return new ResponseEntity(facturas, HttpStatus.FOUND);
    }




}
