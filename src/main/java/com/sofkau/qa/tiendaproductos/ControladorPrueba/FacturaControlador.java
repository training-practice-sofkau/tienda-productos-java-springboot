package com.sofkau.qa.tiendaproductos.ControladorPrueba;

import com.sofkau.qa.tiendaproductos.TiendaProductosApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/factura")
public class FacturaControlador {

    @GetMapping("/verFacturas")
    public ResponseEntity getAllFacturas(){
        return new ResponseEntity(TiendaProductosApplication.historicoFacturas, HttpStatus.FOUND);
    }
}
