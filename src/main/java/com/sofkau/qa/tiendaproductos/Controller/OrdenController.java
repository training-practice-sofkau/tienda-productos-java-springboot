package com.sofkau.qa.tiendaproductos.Controller;

import com.sofkau.qa.tiendaproductos.Model.Orden;
import com.sofkau.qa.tiendaproductos.Model.Producto;
import com.sofkau.qa.tiendaproductos.Services.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tienda")
public class OrdenController {
    @Autowired
    ICompraService compraService;
    @GetMapping("compras")
    public ResponseEntity obtenerCompras(){
        return new ResponseEntity(compraService.obtenerOrdenes(), HttpStatus.FOUND);
    }

    @PostMapping("comprar")
    public ResponseEntity realizarCompra(@RequestBody List<Producto> productos){
        compraService.registrarCompra(productos);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
