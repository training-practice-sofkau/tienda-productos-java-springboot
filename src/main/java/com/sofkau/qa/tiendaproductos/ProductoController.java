package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.datos.ProductosStock;
import com.sofkau.qa.tiendaproductos.datos.Tienda;
import com.sofkau.qa.tiendaproductos.datos.TiendaImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/rest")
public class ProductoController {
    @Autowired
    public ProductosStock productosStock;
    @Autowired
    Tienda tienda;

    /**
     * GET Request para listar todos los productos disponibles en la tienda
     */
    @GetMapping("/bring/all")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(this.productosStock.getStock(), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity buyProduct(@RequestBody Producto producto){
        Producto producto1 = new Producto(producto.getNombre(),
                producto.getUnidades());
        tienda.agregar(producto1);
        return new ResponseEntity(producto1, HttpStatus.CREATED);
    }
}
