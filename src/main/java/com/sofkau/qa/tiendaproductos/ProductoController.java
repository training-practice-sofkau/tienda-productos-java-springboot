package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.datos.Factura;
import com.sofkau.qa.tiendaproductos.datos.ProductosStock;
import com.sofkau.qa.tiendaproductos.datos.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/rest")
public class ProductoController {
    @Autowired
    public ProductosStock productosStock;
    @Autowired
    Tienda tienda;
    @Autowired
    Factura productosComprados;

    /**
     * GET Request para listar todos los productos disponibles en la tienda
     */
    @GetMapping("/bring/stock")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(this.productosStock.getStock(), HttpStatus.FOUND);
    }

    /**
     * Post Request para agregar un producto a la lista de compra
     */
    @PostMapping()
    public ResponseEntity buyProduct(@RequestBody Producto producto){
        Producto producto1 = new Producto(
                UUID.randomUUID().toString(),
                producto.getNombre(),
                productosComprados.setPrecioProducto());
        tienda.agregar(producto1);
        return new ResponseEntity(producto1, HttpStatus.CREATED);
    }

    /**
     * Para obtener la factura con los productos comprados y su respectivo precio
     */
    @GetMapping("/bring/purchased")
    public ResponseEntity getProducts(){
        return new ResponseEntity(productosComprados.getProductosComprados(), HttpStatus.FOUND);
    }
}
