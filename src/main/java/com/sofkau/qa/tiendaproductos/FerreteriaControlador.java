package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ferreteria")
public class FerreteriaControlador {

    public Ferreteria ferreteria;

    public FerreteriaControlador(Ferreteria ferreteria) {
        this.ferreteria = ferreteria;
    }

    @GetMapping("/productos")
    public ResponseEntity productosDisponibles() {
        List<Producto> productos = this.ferreteria.getProductoStock();
        return new ResponseEntity(productos, HttpStatus.FOUND);
    }
}
