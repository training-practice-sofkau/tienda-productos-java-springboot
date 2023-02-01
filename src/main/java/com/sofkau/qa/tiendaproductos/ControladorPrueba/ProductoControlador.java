package com.sofkau.qa.tiendaproductos.ControladorPrueba;


import com.sofkau.qa.tiendaproductos.ProductoCompra;
import com.sofkau.qa.tiendaproductos.ProductoInventario;
import com.sofkau.qa.tiendaproductos.TiendaProductosApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/producto")
public class ProductoControlador {



    @GetMapping("/verProductos")
    public ResponseEntity getAllProductoInventario() {
        return new ResponseEntity(TiendaProductosApplication.inventario, HttpStatus.FOUND);
    }

    @PostMapping("/crearProducto")
    public ResponseEntity createNewProductoInventario(@RequestBody ProductoInventario productoInventario){
        ProductoInventario newProductoInventario=new ProductoInventario(
                productoInventario.getNombre(),
                productoInventario.getId(),
                productoInventario.getCantidad(),
                productoInventario.getPrecio());
        TiendaProductosApplication.inventario.add(newProductoInventario);
        return new ResponseEntity(newProductoInventario, HttpStatus.CREATED);

    }

    @PostMapping("/crearProductos")
    public LinkedList<ProductoInventario> ProductosInventario(@RequestBody LinkedList<ProductoInventario> productosInventario){
        productosInventario.stream().forEach(n -> {
            TiendaProductosApplication.inventario.add(n);
        });
        return productosInventario;
    }

    @PutMapping("/{productoId}")
    public ResponseEntity update(@PathVariable("productoId") int id,
                                 @RequestBody ProductoInventario productoInventario){
        ArrayList<ProductoInventario> newInventario= (ArrayList<ProductoInventario>) TiendaProductosApplication.inventario.stream()
                .map(n -> n.getId()==(id)? productoInventario:n).collect(Collectors.toList());
        TiendaProductosApplication.inventario=newInventario;
        return new ResponseEntity(productoInventario, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity deleteProductoInventario(@PathVariable("productoId") int id){
        ArrayList<ProductoInventario> newInventario= (ArrayList<ProductoInventario>) TiendaProductosApplication.inventario.stream()
                .filter(n -> !(n.getId() == id)).collect(Collectors.toList());
        TiendaProductosApplication.inventario=newInventario;
        return new ResponseEntity(TiendaProductosApplication.inventario, HttpStatus.GONE);
    }

}
