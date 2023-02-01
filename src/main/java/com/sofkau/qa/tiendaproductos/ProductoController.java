package com.sofkau.qa.tiendaproductos;

import com.sofkau.qa.tiendaproductos.datos.ProductosStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rest")
public class ProductoController {
    @Autowired
    public ProductosStock productosStock;

    /**
     * GET Request para listar todos los productos disponibles en la tienda
     */
    @GetMapping("/bring/all")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(this.productosStock.getStock(), HttpStatus.FOUND);
    }
}
